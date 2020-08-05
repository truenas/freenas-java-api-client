/**
 * Copyright (C) 2018 iXsystems
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of freenas-java-api-client nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.freenas.cli;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ixsystems.vcp.entities.AlertMessage;
import com.ixsystems.vcp.entities.Dataset;
import com.ixsystems.vcp.entities.Volume;
import com.ixsystems.vcp.entities.Children;
import com.ixsystems.vcp.entities.network.GlobalConfigurations;
import com.ixsystems.vcp.entities.share.NFSShare;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.freenas.client.v2.alertsystem.AlertSystem;
import org.freenas.client.v2.alertsystem.rest.imp.AlertSystemImp;
import org.freenas.client.v2.connectors.rest.imp.AuthenticationConnector;
import org.freenas.client.v2.connectors.rest.imp.EndpointConnector;
import org.freenas.client.v2.network.GlobalConfigurationConnector;
import org.freenas.client.v2.network.rest.impl.GlobalConfigurationRestConnector;
import org.freenas.client.v2.storage.rest.impl.DatasetRestConnector;
import org.freenas.client.v2.storage.rest.impl.VolumeRestConnector;
import org.freenas.client.v2.storage.rest.impl.SharingNFSRestConnector;
import org.freenas.client.websockets.ReceivedMessage;
import org.freenas.client.websockets.WSClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * This is the main for freenas cli
 */
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private String url;
    private String username;
    private String password;
    private Boolean websockets;
    private String websocketsUri;

    private String volumeName;

    // Constructor;
    public Main(){

    }

    /**
     * Main App Here - Start workflow.
     *
     * @param args
     */
    public static void main(String [] args){
        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);

        // create Options object
        Options options = new Options();

        Option help = new Option( "help", "help how to use the freenas-cli" );
        Option usernameOpt = new Option( "user", "set the username" );
        usernameOpt.setArgs(1);
        Option passwordOpt = new Option( "pass", "set the password " );
        passwordOpt.setArgs(1);
        Option urlOpt = new Option( "url", "url" );
        urlOpt.setArgs(1);

        Option volume = new Option( "volume", "create volume" );
        volume.setArgs(2);
        Option config = new Option( "config", "config list" );
        config.setArgs(1);

        Option share = new Option( "share", "share type path/share list all/share list nfs" );
        config.setArgs(2);



        Option alerts = new Option( "alerts", "alerts list" );
        config.setArgs(1);

        Option iterative = new Option( "iterative", "iterative mode" );
        config.setArgs(0);


        Option vnameOpt = new Option( "vname", "volume name" );
        vnameOpt.setArgs(1);
        // add t option
        options.addOption(help);
        options.addOption(volume);
        options.addOption(usernameOpt);
        options.addOption(passwordOpt);
        options.addOption(vnameOpt);
        options.addOption(config);
        options.addOption(share);
        options.addOption(alerts);
        options.addOption(iterative);

        options.addOption(urlOpt);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        Main app = new Main();
        try {
            cmd = parser.parse( options, args);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        // Load Configurations
        YmlConfs yml = new YmlConfs();
        try {
            yml.load();
            // Set settings
            app.username = yml.getUsername();
            app.password = yml.getPassword();
            app.url = yml.getUrl();
            app.websockets = yml.getWebSockets();
            app.websocketsUri = yml.getWebSocketsUri();

        } catch (FileNotFoundException e) {
            LOGGER.info("No freenas yml configuration available.");
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(cmd.hasOption("user")) { // User
            app.username = cmd.getOptionValue("user");
        }
        if(cmd.hasOption("pass")) { // Pass
            app.password = cmd.getOptionValue("pass");
        }
        if(cmd.hasOption("url")) { // Pass
            app.url = cmd.getOptionValue("url");
        }
        if(cmd.hasOption("vname")) { // Pass
            app.volumeName = cmd.getOptionValue("vname");
        }
        if(cmd.hasOption("volume")) {
            app.handleVolumes(cmd);
        }
        if(cmd.hasOption("config")) {
            app.globalConfigurations(cmd);
        }
        if(cmd.hasOption("share")) {
            // Need to handle here the shares type
            app.handleShares(cmd);
        }
        if(cmd.hasOption("alerts")) {
            // Need to handle here the shares type
            app.handleAlerts(cmd);
        }
        if(cmd.hasOption("iterative")) {
            // Need to handle here the shares type
            //app.handleIterativeMode(cmd);
        }
        if(cmd.hasOption("help")) {

            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "freenas-client", options );
        }
        //System.out.println(app);
    }

    private void handleIterativeMode(CommandLine cmd) {

        if (!this.websockets) {
            System.out.println("FreNAS - Not possible enter in iterative mode without enable WebSockets Options. " +
                    "Please check your conf/freenas.yml");
        }

        // Connect to WebSockets
        WSClient wsClient = new WSClient(websocketsUri, username, password);
        wsClient.start();
        wsClient.retrieveSessionId();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            while (!input.equalsIgnoreCase("stop")) {
                showMenu();
                input = in.readLine();
                if(input.equals("nfs share")) {

                    String idMsg = UUID.randomUUID().toString();

                    //do something
                    ReceivedMessage callable = new ReceivedMessage() {
                        @Override
                        public Object call(String message) {
                            // Decode Message ;

                            ObjectMapper objectMapper = new ObjectMapper();
                            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                            JSONObject jsonObject = new JSONObject(message);
                            JSONArray arr = jsonObject.getJSONArray("result");
                            System.out.println("[FreeNAS] - Available NFS Shares:");
                            for (int i = 0 ; i<arr.length(); i++){
                                try {
                                    NFSShare nfsShare = objectMapper.readValue(arr.getJSONObject(i).toString(), NFSShare.class);
                                    System.out.println("ID="+nfsShare.getId() +", " + nfsShare.getPaths());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }



                            // Handle it!

                            return message;
                        }


                    };
                    wsClient.registerCallable(idMsg, callable);
                    wsClient.listNfsShare(idMsg);
                }
                else if(input.equals("stop")) {
                    //do something else
                    System.exit(0);
                }
                else if(input.equals("help")) {
                    showMenu();
                }
            }
        } catch (Exception e) {
            LOGGER.error("FreeNAS - Iterative mode, error " + e.getMessage());
        }


    }

    public static void showMenu() {
        System.out.println("nfs share: List the NFS Share");
        System.out.println("help");
        System.out.println("Enter the command or \"stop\" to exit");
    }

    /**
     * Handle the alerts
     *
     * @param cmd
     */
    private void handleAlerts(CommandLine cmd) {
        System.out.println("[FreeNAS] Alerts");

        String [] opts = cmd.getArgs();
        int indexOpt = 0 ;

        String optLst = opts[indexOpt];

        if (optLst.equals("list")){
            listAlerts(optLst);
        }
        else if (optLst.equals("dismiss")){
            System.out.println("FreeNAS - dismiss a specific alert "+opts[indexOpt+1]);
            dismissAlert(opts[indexOpt+1]);
        }
        else{
            System.out.println("No options available for alerts.");
        }
    }

    /**
     * Dismiss the alerts
     * @param optLst
     */
    private void dismissAlert(String optLst) {
        AlertSystem alertSystem = new AlertSystemImp(getEndPointConnector(),getAuth());
        alertSystem.dismiss(optLst);
    }

    /**
     * List all alerts from FreeNAS system
     * @param optLst
     */
    private void listAlerts(String optLst) {
        AlertSystem alertSystem = new AlertSystemImp(getEndPointConnector(),getAuth());
        List<AlertMessage> alerts = alertSystem.list();
        if (alerts.size()==0) {
            System.out.println("No alerts available at moment.");
            return;
        }
        System.out.printf("############################\n");
        for (AlertMessage m : alerts){
            System.out.println(m.getId());
            System.out.println(m.getFormatted());
        }
        System.out.printf("############################\n");
    }

    /**
     * Handle Volumes
     *
     * @param cmd Command Line options
     */
    private void handleVolumes(CommandLine cmd){
        System.out.println("[FreeNAS] Volumes");

        String [] opts = cmd.getOptionValues("volume");
        int indexOpt = 0;
        if (opts[indexOpt].equals("add")){
            System.out.println("FreeNAS - adding new dataset named "+opts[indexOpt+1]);
            addDataset(opts[indexOpt+1]);
        } else if (opts[indexOpt].equals("delete")){
            System.out.println("FreeNAS - delete new dataset named "+opts[indexOpt+1]);
            deleteDataset(opts[indexOpt+1]);
        } else if (opts[indexOpt].equals("list")){
            System.out.println("FreeNAS - listing current pools");
            listPools();
        } else{
            System.out.println("No options available for volume.");
        }
    }

    /**
     * Handle Volumes
     *
     * @param cmd Command Line options
     */
    private void handleShares(CommandLine cmd){

        System.out.println("[FreeNAS] Shares");

        String [] opts = cmd.getArgs();
        int indexOpt = 0 ;
        if (opts[indexOpt].equals("add")){
            System.out.println("FreeNAS - creating a new share "+opts[indexOpt+1]);
            createShare(opts[indexOpt+1], opts[indexOpt+2], opts[indexOpt+3], opts[indexOpt+4]);
            System.out.println("FreeNAS - created a new share.");
        }else if (opts[indexOpt].equals("delete")){
            System.out.println("FreeNAS - remove an existing share "+opts[indexOpt+1]);
            deleteShare(opts[indexOpt+1]);
        }else if (opts[indexOpt].equals("list")){
            System.out.println("FreeNAS - listing current shares");
            listCurrentShares();
        }

        else{
            System.out.println("No options available for volume.");
        }
    }

    private void deleteShare(String opt) {

    }

    /**
     * Create the share for a specific path and also a type
     * @param opt will be the path to share
     * @param type will be type to share, like for instance, nfs, cifs, iscsi
     */
    private void createShare(String type, String path, String comment, String security) {

        if (type.equals("nfs")){

            SharingNFSRestConnector connector = new SharingNFSRestConnector(getEndPointConnector(), getAuth());
            Map<String, Object> args = new HashMap<String, Object>();
            args.put("nfs_comment", comment);
            List<String> paths = new ArrayList<>();
            paths.add(path);
            args.put("nfs_paths",paths);
            args.put("nfs_security", security);

            connector.create(path, args);

        }

    }


    public AuthenticationConnector getAuth(){
        AuthenticationConnector auth = new AuthenticationConnector(username, password);
        return auth;
    }

    public EndpointConnector getEndPointConnector(){
        EndpointConnector ep = new EndpointConnector(this.url, "http");
        return ep;
    }

    public DatasetRestConnector getConnector(){
        AuthenticationConnector auth = getAuth();
        EndpointConnector ep = getEndPointConnector();
        DatasetRestConnector gs = new DatasetRestConnector(ep, auth);

        return gs;
    }
    public VolumeRestConnector getVolumeConnector(){
        AuthenticationConnector auth = getAuth();
        EndpointConnector ep = getEndPointConnector();
        VolumeRestConnector gs = new VolumeRestConnector(ep, auth);

        return gs;
    }
    private boolean addDataset(String name){
        boolean result = false;
        DatasetRestConnector gs = getConnector();
        Map<String, String> args = new HashMap<String, String>();

        args.put("name", name);

        String volumeName = this.volumeName;
        Dataset ds = null ;
        try {
            ds = gs.create(volumeName, args);
            result = true;
        }
        catch (Exception e){
            LOGGER.error("Error while creating dataset", e);
        }
        if (result) {
            System.out.println("Dataset has been created: " + ds.getName());
            System.out.println("Dataset is mounted at: " + ds.getMountPoint());
            System.out.println("Dataset " + ds.getName() + " has available " + ds.getAvailable() / 1024 / 1024 / 1024 + "GB.");
        }
        return result;

    }

    private boolean listPools(){
        boolean result = false;
        VolumeRestConnector gs = getVolumeConnector();
        Map<String, String> args = new HashMap<String, String>();

        List<Volume> pools = null;
        try {
            pools = gs.list();
            result = true;
        } catch (Exception e) {
            LOGGER.error("Error while listing pools", e);
        }
        if (result){
            System.out.println("The following pools:");
            for (Volume v: pools){
                if (v.getId() !=0 )
                    System.out.println(">> Pool id: " + v.getId());
                if (v.getName() != null)
                    System.out.println(">> Pool name: " + v.getName() + " in " + v.getPath());
                System.out.println(">> Used size " + v.getUsed() + " or " + v.getUsed_pct());
                if (v.getChildren() != null && v.getChildren().length != 0) {
                    System.out.println(">> Children");
                    for(Children c : v.getChildren()) {
                        System.out.println(c);
                    }
                }else{
                    System.out.println(">> Childless");
                }
                System.out.println(">> ===========");
            }
        }
        return result;
    }

    private boolean listDatasets(){
        boolean result = false;
        DatasetRestConnector gs = getConnector();
        Map<String, String> args = new HashMap<String, String>();

        //String volumeName = this.volumeName;
        List<Dataset> datasets = null;
        try {
            //datasets = gs.list();
            result = true;
        } catch (Exception e) {
            LOGGER.error("Error while listing datasets", e);
        }
        if (result){
            System.out.println("The following datasets:");
            for (Dataset d : datasets){
                if (d.getName() != null)
                    System.out.println(">> Dataset name: " + d.getName() + " in " + d.getMountPoint());
                System.out.println(">> Used size " + d.getUsed());
                System.out.println(">> ===========");
            }
        }
        return result;
    }

    /**
     * List the current shares
     * @return
     */
    private boolean listCurrentShares(){
        boolean result = false;

        SharingNFSRestConnector connector = new SharingNFSRestConnector(getEndPointConnector(), getAuth());



        List<NFSShare> shares  = null ;
        try {
            shares = connector.list();

            result = true;
        }
        catch (Exception e){
            LOGGER.error("Error while lists datasets", e);
        }
        if (result){
            System.out.println("The following datasets:");
            for (NFSShare v: shares){
                System.out.println(">> Share path: "+v.getPaths());
                System.out.println(">> ===========");
            }
        }

        return result;

    }


    private boolean deleteDataset(String name){

        boolean result = false;

        DatasetRestConnector gs = getConnector();


        System.out.println(">> FreeNAS - deleting the dataset named: " + name);
        Dataset ds = null ;
        try {
            gs.delete(name);
            result = true;
        }
        catch (Exception e){
            LOGGER.error("Error while creating dataset", e);
        }

        return result;
    }



    private boolean globalConfigurations(CommandLine cmd){
        boolean result = false;

        String [] opts = cmd.getOptionValues("config");
        int indexOpt = 0 ;
        if (opts[indexOpt].equals("list")){

            EndpointConnector ep = new EndpointConnector(url, "http");
            GlobalConfigurationConnector gs = new GlobalConfigurationRestConnector(ep, getAuth());
            String hostname = gs.getHostname();
            System.out.println("# FreeNAS Global Configurations: ");
            System.out.println(">> Hostname : " + hostname);
            GlobalConfigurations gc = gs.get();
            System.out.println(">> Domain is: " + gc.getGcDomain());
        }
        return result;

    }

    @Override
    public String toString() {
        return "Main{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Boolean getWebsockets() {
        return websockets;
    }

    public void setWebsockets(Boolean websockets) {
        this.websockets = websockets;
    }

    public String getWebsocketsUri() {
        return websocketsUri;
    }

    public void setWebsocketsUri(String websocketsUri) {
        this.websocketsUri = websocketsUri;
    }
}

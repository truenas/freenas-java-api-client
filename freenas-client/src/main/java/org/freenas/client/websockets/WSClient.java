package org.freenas.client.websockets;


import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import javax.websocket.*;

/**
 * This is the module to do WebSocket Communication
 */
@ClientEndpoint
public class WSClient  {
    private Object waitLock = new Object();
    private String wsUrl = "ws://10.20.21.194/websocket";
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(WSClient.class);
    private RemoteEndpoint.Basic basicSession = null;
    private String id ;
    private String username ;
    private String password;

    public WSClient(String wsUrl, String username, String password) {
        this.wsUrl = wsUrl;
        this.username = username;
        this.password = password;


    }

    /**
     * Perform the steps of authentication and connections
     */
    public void start(){
        WebSocketContainer container=null;//
        Session session=null;
        try {
            container = ContainerProvider.getWebSocketContainer();
            LOGGER.info(("Trying to the server " + wsUrl));
            session = container.connectToServer(WSClient.class, URI.create(wsUrl));
            basicSession = session.getBasicRemote();
        }
        catch (Exception e){
            LOGGER.error("There is a problem while starting websockets ", e);
        }
    }

    /**
     * Performs the authentication
     * @return
     */
    public boolean authentication(){
        sendMessage(WSAuthenticationMessages.getConnectMsg());
        basicSession.sendText(WSAuthenticationMessages.getAuth(
                WSAuthenticationMessages.decodeSessionId(message),
                "root",
                "abcd1234"));
        id = WSAuthenticationMessages.decodeSessionId(message);

        return true;
    }

    /**
     * Sends the message by websockets
     * @param message
     */
    public void sendMessage(String message){
        try {
            basicSession.sendText(WSSharingMessages.getNFSSharingQuery(id));
        } catch (IOException e) {
            LOGGER.error("There is a problem while sending the message ", e);
        }
    }

    /**
     * Handle the onMessage
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received msg: "+message);
        String msg = WSAuthenticationMessages.decodeMessage(message);
        if (msg.equals(WSAuthenticationMessages.MSG_CONNECTED)) {

            try {
                basicSession.sendText(WSAuthenticationMessages.getAuth(
                        WSAuthenticationMessages.decodeSessionId(message),
                        "root",
                        "abcd1234"));
                id = WSAuthenticationMessages.decodeSessionId(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (msg.equals(WSAuthenticationMessages.MSG_RESULT)){
            System.out.println("Authenticated via Websockets with Storage Node at "+ wsUrl);
            try {
                System.out.println("Sending  getNFSSharingQuery");
                System.out.println(WSSharingMessages.getNFSSharingQuery(id));
                basicSession.sendText(WSSharingMessages.getNFSSharingQuery(id));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("WSClient.onMessage - UNKNOWN");
            System.out.println(message);
        }
    }

}
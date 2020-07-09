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
package org.freenas.client.websockets;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.rmi.CORBA.Util;
import javax.websocket.*;

/**
 * This is the module to do WebSocket Communication
 */
@ClientEndpoint
public class WSClient  {
    private static Object waitLock = new Object();

    private String wsUrl = "ws://10.20.21.194/websocket";
    private static final Logger LOGGER = LogManager.getLogger(WSClient.class);
    private RemoteEndpoint.Basic basicSession = null;
    private String id ;
    private String username ;
    private String password;
    private Map<String, ReceivedMessage> callableMap = new HashMap<String, ReceivedMessage>();

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
            //System.out.println(("Trying to the server " + wsUrl));
            session = container.connectToServer(this, URI.create(wsUrl));

            basicSession = session.getBasicRemote();
            //System.out.println("Connected.");
        }
        catch (Exception e){
            LOGGER.error("There is a problem while starting websockets ", e);
        }
    }

    /**
     * Performs the authentication
     * @return
     */
    public boolean retrieveSessionId() {
        //System.out.println(WSAuthenticationMessages.getConnectMsg());
        sendMessage(WSAuthenticationMessages.getConnectMsg());
        return true;
    }

    /**
     * Sends message regarding authentication
     * @param connectedMessage
     * @return
     */
    public boolean authentication(String connectedMessage){
        id = WSAuthenticationMessages.decodeSessionId(connectedMessage);
        try {
            basicSession.sendText(WSAuthenticationMessages.getAuth(
                    id,
                    username
                    , password));
        } catch (IOException e) {
            LOGGER.error("There is a problem while sending the message ", e);
        }


        return true;
    }

    public boolean registerCallable(String idMsg,  ReceivedMessage callable){

        this.callableMap.put(idMsg, callable);
        return true;

    }

    // WSSharingMessages.getNFSSharingQuery(id)
    public String listNfsShare(String idMsg){


        String message = WSSharingMessages.getNFSSharingQuery(idMsg);
        sendMessage(message);

        return idMsg;

    }

    /**
     * Sends the message by websockets
     * @param message
     */
    public void sendMessage(String message){
        try {
            basicSession.sendText(message);
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
        //System.out.println("Received msg: "+message);
        String msg = WSAuthenticationMessages.decodeMessage(message);
        if (msg.equals(WSAuthenticationMessages.MSG_CONNECTED)) {

            try {

                this.authentication(message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (msg.equals(WSAuthenticationMessages.MSG_RESULT)){
            //System.out.println("Authenticated via Websockets with Storage Node at "+ wsUrl);
            ReceivedMessage call = callableMap.get(WSAuthenticationMessages.decodeId(message));
            //System.out.println(callableMap);
            if (call!=null)
                call.call(message);

        }
        else{
            System.out.println("WSClient.onMessage - UNKNOWN");
            System.out.println(message);
        }
    }

}

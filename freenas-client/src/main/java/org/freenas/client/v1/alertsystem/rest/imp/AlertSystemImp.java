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
package org.freenas.client.v1.alertsystem.rest.imp;

import com.ixsystems.vcp.entities.AlertMessage;
import com.ixsystems.vcp.entities.AlertsMessageTransport;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.freenas.client.v1.alertsystem.AlertSystem;
import org.freenas.client.v1.connectors.Authentication;
import org.freenas.client.v1.connectors.Endpoint;
import org.freenas.client.v1.storage.rest.impl.DatasetRestConnector;
import org.freenas.client.v1.utils.UnirestUtils;

import java.util.List;

public class AlertSystemImp implements AlertSystem {
    private static String ENDPOINT_ALERTS_LIST = "/api/v1.0/system/alert/";
    private static String ENDPOINT_ALERTS_DISMISS = "/api/v1.0/system/alert/(string: id)/dismiss/";
    // /api/v1.0/system/alert/(string: id)/dismiss/
    private static final Logger LOGGER = LogManager.getLogger(DatasetRestConnector.class);


    private Endpoint endpoint;
    private Authentication auth;

    public AlertSystemImp(Endpoint endpoint, Authentication auth){
        this.endpoint = endpoint;
        this.auth = auth;
    }
    public List<AlertMessage> list() {
        try {
            UnirestUtils.mapUnirest();
            try {

                HttpResponse<AlertsMessageTransport> jsonResponse = Unirest.get(endpoint.getRootEndPoint() + ENDPOINT_ALERTS_LIST)
                        .basicAuth(auth.getUsername(), auth.getPassword())
                        .header("accept", "application/json")
                        .asObject(AlertsMessageTransport.class);
                //System.out.print(jsonResponse.getBody());

                System.out.println("FreeNAS - get list of alerts.");

                if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                    AlertsMessageTransport body = jsonResponse.getBody();
                    // STOPSHIP: 11/24/2018
                    //System.out.println("body.getObjects() = " + body.getObjects());
                    //System.out.println(body);
                    return body.getObjects();
                }

            } catch (UnirestException e) {
                LOGGER.error("Error while connecting service ", e);
            }

        } catch (Exception e) {
            LOGGER.error("Error while connecting service ", e);
        }

        return null;
    }

    public List<AlertMessage> list(String filter) {
        return null;
    }

    public void dismiss(String id) {

        String url = ENDPOINT_ALERTS_DISMISS.replace("(string: id)", id);

    }
}

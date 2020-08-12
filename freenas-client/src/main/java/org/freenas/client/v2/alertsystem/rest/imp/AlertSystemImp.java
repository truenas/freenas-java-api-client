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
package org.freenas.client.v2.alertsystem.rest.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ixsystems.vcp.entities.AlertMessage;
import kong.unirest.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.freenas.client.v2.alertsystem.AlertSystem;
import org.freenas.client.v2.connectors.Authentication;
import org.freenas.client.v2.connectors.Endpoint;
import org.freenas.client.v2.storage.rest.impl.DatasetRestConnector;
import org.freenas.client.v2.utils.UnirestUtils;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class AlertSystemImp implements AlertSystem {
    private static String ENDPOINT_ALERTS_LIST = "/api/v2.0/alert/list";
    ///api/v1.0/system/alert/(string: id)/dismiss/
    private static String ENDPOINT_ALERTS_DISMISS = "/api/v2.0/alert/dismiss/";
    private static String ENDPOINT_ALERTS_RESTORE = "/api/v2.0/alert/restore/"; //New in v2
    private static String ENDPOINT_ALERTS_CATEGORIES = "/api/v2.0/alert/list_categories/"; //New in v2
    private static String ENDPOINT_ALERTS_POLICIES = "/api/v2.0/alert/list_policies/"; //New in v2
    private static final Logger LOGGER = LogManager.getLogger(DatasetRestConnector.class);

    private Endpoint endpoint; private Authentication auth;

    public AlertSystemImp(Endpoint endpoint, Authentication auth){
        this.endpoint = endpoint;
        this.auth = auth;

        ObjectMapper om = new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper =
                    new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Unirest.config().setObjectMapper(om);
    }

    public List<AlertMessage> list() {
        List<AlertMessage> alertList = new ArrayList<AlertMessage>();

        try {
            HttpResponse<AlertMessage[]> jsonResponse = Unirest.get(endpoint.getRootEndPoint() + ENDPOINT_ALERTS_LIST)
                    .basicAuth(auth.getUsername(), auth.getPassword())
                    .header("accept", "application/json")
                    .asObject(AlertMessage[].class);
            if(jsonResponse.getParsingError().isPresent()) {
                System.out.println(jsonResponse.getParsingError().get());
                return null;
            }
            System.out.print(jsonResponse.getBody());
            System.out.println("FreeNAS - get list of alerts.");

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                AlertMessage[] body = jsonResponse.getBody();
                if(body != null) {
                    for (AlertMessage b : body) {
                        alertList.add(b);
                    }
                    System.out.println(alertList);
                    return alertList;
                }
            }
        } catch (UnirestException e) {
            LOGGER.error("Error while connecting service ", e);
        }

        return null;
    }

    /*public List<AlertMessage> list(String filter) {
        return null;
    }*/

    public void dismiss(String id) {
        //Id sent as param instead of in endpoint
        String url = ENDPOINT_ALERTS_DISMISS;//.replace("(string: id)", id);
    }

    public void restore(String id) {
        String url = ENDPOINT_ALERTS_RESTORE;
    }

    public List<String> listCategories() {
        String url = ENDPOINT_ALERTS_CATEGORIES;
        return null;
    }

    public List<String> listPolicies() {
        String url = ENDPOINT_ALERTS_POLICIES;
        return null;
    }
}

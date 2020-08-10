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
package org.freenas.client.v2.storage.rest.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ixsystems.vcp.entities.Replication;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestParsingException;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.freenas.client.v2.connectors.Authentication;
import org.freenas.client.v2.connectors.Endpoint;
import org.freenas.client.v2.storage.ReplicationConnector;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReplicationRestConnector implements ReplicationConnector {
    private String ENDPOINT_REPLICATION_CREATE = "/api/v2.0/replication";
    private String ENDPOINT_REPLICATION_LIST = "/api/v2.0/replication";
    private String ENDPOINT_REPLICATION_DELETE = "/api/v2.0/id/{id}";
    private String ENDPOINT_REPLICATION_GET = "/api/v2.0/id/{id}";
    private String ENDPOINT_REPLICATION_UPDATE = "/api/v2.0/id/{id}";

    private Endpoint endpoint;
    private Authentication auth;
    private String rootUrl = "";
    private JSONObject myObj;

    public ReplicationRestConnector(Endpoint endpoint, Authentication auth) {
        this.endpoint = endpoint;
        this.auth = auth;
        this.rootUrl = endpoint.getRootEndPoint();
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

    public Replication create() {
        try {
            HttpResponse<Replication> jsonResponse = Unirest.post(ENDPOINT_REPLICATION_CREATE)
                    .header("accept", "application/json")
                    .queryString("apiKey", "123")
                    .field("parameter", "value")
                    .field("foo", "bar")
                    .asObject(Replication.class);

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                Replication body = jsonResponse.getBody();
                System.out.println(body);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Replication update(int id, Replication newTask) {
        return null;
    }

    public Replication delete(int id) {
        return null;
    }

    public Replication get(int id) {
        return null;
    }

    public List<Replication> list() {
        // This will be the result
        List<Replication> tasks = new ArrayList<Replication>();
        try {
            HttpResponse<Replication[]> jsonResponse = Unirest.get(rootUrl + ENDPOINT_REPLICATION_LIST)
                    .basicAuth(auth.getUsername(), auth.getPassword())
                    .header("accept", "application/json")
                    .asObject(Replication[].class);
            if(jsonResponse.getParsingError().isPresent()) {
                UnirestParsingException jsonError = jsonResponse.getParsingError().get();
                String originalBody = jsonError.getOriginalBody();
                System.out.println(jsonError);
                System.out.println(originalBody);
            }

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                Replication[] body = jsonResponse.getBody();
                System.out.println(body);
                if(body != null) {
                    for (Replication b : body){
                        System.out.println(b);
                        tasks.add(b);
                    }
                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}

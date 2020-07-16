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
import com.ixsystems.vcp.entities.Dataset;
import com.ixsystems.vcp.entities.Volume;
import kong.unirest.HttpResponse;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.freenas.client.v2.connectors.Authentication;
import org.freenas.client.v2.connectors.Endpoint;
import org.freenas.client.v2.storage.VolumeConnector;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VolumeRestConnector implements VolumeConnector {


    private String ENDPOINT_DATASET_CREATE;
    // /api/v1.0/storage/volume/
    private String ENDPOINT_DATASET_LIST = "/api/v2.0/pool";

    private Endpoint endpoint;
    private Authentication auth;
    private String rootUrl = "";

    private JSONObject myObj;


    public VolumeRestConnector(Endpoint endpoint, Authentication auth) {
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

    public Volume create() {
        try {
            HttpResponse<Volume> jsonResponse = Unirest.post(ENDPOINT_DATASET_CREATE)
                    .header("accept", "application/json")
                    .queryString("apiKey", "123")
                    .field("parameter", "value")
                    .field("foo", "bar")
                    .asObject(Volume.class);

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                Volume body = jsonResponse.getBody();
                System.out.println(body);
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Volume update(Dataset id) {
        return null;
    }

    public Volume delete(Long id) {
        return null;
    }

    public Volume get(Long id) {
        return null;
    }

    public List<Volume> list() {


        // This will be the result
        List<Volume> volumes = new ArrayList<Volume>();

        try {

            HttpResponse<Volume[]> jsonResponse = Unirest.get(rootUrl + ENDPOINT_DATASET_LIST)
                    .basicAuth(auth.getUsername(),auth.getPassword())
                    .header("accept", "application/json")
                    .asObject(Volume[].class);
            //System.out.print(jsonResponse.getBody());

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                Volume [] body = jsonResponse.getBody();
                System.out.println(body);

                for (Volume b: body){
                    volumes.add(b);
                }
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return volumes;
    }
}

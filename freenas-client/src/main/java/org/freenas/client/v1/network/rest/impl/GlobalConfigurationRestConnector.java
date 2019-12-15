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
package org.freenas.client.v1.network.rest.impl;

import com.ixsystems.vcp.entities.network.GlobalConfigurations;
import com.ixsystems.vcp.entities.serializers.GlobalConfigurationSerializer;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONObject;
import org.freenas.client.v1.connectors.Authentication;
import org.freenas.client.v1.connectors.Endpoint;
import org.freenas.client.v1.network.GlobalConfigurationConnector;

public class GlobalConfigurationRestConnector implements GlobalConfigurationConnector {
    private static String ENDPOINT_DATASET_CREATE = "/api/v1.0/network/globalconfiguration/";
    private Endpoint endpoint;
    private Authentication auth;
    private String rootUrl = "";

    private JSONObject myObj;
    private GlobalConfigurationSerializer serializer;
    private GlobalConfigurations gc;

    public GlobalConfigurationRestConnector(Endpoint endpoint, Authentication auth){
        this.endpoint = endpoint;
        this.auth = auth;
        this.rootUrl = endpoint.getRootEndPoint();

        this.serializer = new GlobalConfigurationSerializer();

        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(rootUrl + ENDPOINT_DATASET_CREATE)
                    .basicAuth(auth.getUsername(),auth.getPassword())
                    .header("accept", "application/json")
                    .asJson();


            this.myObj = jsonResponse.getBody().getObject();
            this.init();

        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    private void init(){
        this.gc = new GlobalConfigurations();
        this.serializer.decode(myObj, gc);

    }

    public String getHostname() {
        return this.gc.getGcHostname();
    }

    public GlobalConfigurations get() {
        return this.gc;
    }
}

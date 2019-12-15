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
package org.freenas.client.v1.storage.rest.impl;

import com.ixsystems.vcp.entities.serializers.NFSShareSerializer;
import com.ixsystems.vcp.entities.share.NFSShare;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.freenas.client.v1.connectors.Authentication;
import org.freenas.client.v1.connectors.Endpoint;
import org.freenas.client.v1.storage.SharingNFSConnector;
import org.freenas.client.v1.utils.UnirestUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharingNFSRestConnector implements SharingNFSConnector {
    private String ENDPOINT_SHARING_LIST = "/api/v1.0/sharing/nfs/";
    private String ENDPOINT_SHARING_CREATE = "/api/v1.0/sharing/nfs/";
    private String ENDPOINT_SHARING_DELETE = "/api/v1.0/sharing/nfs/";

    private static final Logger LOGGER = Logger.getLogger(SharingNFSRestConnector.class);


    private Endpoint endpoint;
    private Authentication auth;

    public SharingNFSRestConnector(Endpoint endpoint, Authentication auth) {
        this.endpoint = endpoint;
        this.auth = auth;
    }

    public NFSShare create(String volumeName, Map<String, Object> args) {
        /**
         *           "nfs_comment": "My Test Share",
         *           "nfs_paths": ["/mnt/tank"],
         *           "nfs_security": "sys"
         */
        try {
            JSONObject obj = new JSONObject(args);

            HttpResponse<JsonNode> jsonResponse = Unirest.post(endpoint.getRootEndPoint() + ENDPOINT_SHARING_CREATE )
                    .header("accept", "*/*")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + auth.get64bitEncoded())
                    .body(obj)
                    .asJson();


            NFSShareSerializer ds = new NFSShareSerializer();
            NFSShare result = new NFSShare();
            ds.decode(jsonResponse.getBody().getObject(), result);
            return result;



        } catch (UnirestException e) {
            LOGGER.error("Error while connecting service ", e);
        }

        return null;

    }

    public NFSShare update(NFSShare id) {
        return null;
    }

    public NFSShare delete(String name) {
        // /api/v1.0/sharing/nfs/(int: id)/
        try {

            HttpResponse<String> jsonResponse = Unirest.delete(endpoint.getRootEndPoint() + ENDPOINT_SHARING_DELETE + name + "/")
                    .header("accept", "*/*")
                    .header("Content-Type", "application/json")
                    //.header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Basic " + auth.get64bitEncoded())
                    .asString();

        } catch (UnirestException e) {
            LOGGER.error("Error while delete the dataset named " + name);
        }


        return null;


    }

    public NFSShare get(Long id) {
        return null;
    }

    public List<NFSShare> list() {
        UnirestUtils.mapUnirest();
        try {

            HttpResponse<NFSShare[]> jsonResponse = Unirest.get(endpoint.getRootEndPoint() + ENDPOINT_SHARING_LIST)
                    .basicAuth(auth.getUsername(), auth.getPassword())
                    .header("accept", "application/json")
                    .asObject(NFSShare[].class);
            //System.out.print(jsonResponse.getBody());

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                NFSShare[] body = jsonResponse.getBody();
                List<NFSShare> list = new ArrayList<NFSShare>();
                for (NFSShare b : body) {
                    list.add(b);
                }
                return list;
            }

        } catch (UnirestException e) {
            LOGGER.error("Error while connecting service ", e);
        }



        return null;
    }
}

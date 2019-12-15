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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ixsystems.vcp.entities.Dataset;

import com.ixsystems.vcp.entities.Volume;
import com.ixsystems.vcp.entities.exceptions.DatasetAlreadyExists;
import com.ixsystems.vcp.entities.serializers.DatasetSerializer;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.freenas.client.utils.SSLManager;
import org.freenas.client.v1.connectors.Authentication;
import org.freenas.client.v1.connectors.Endpoint;
import org.freenas.client.v1.storage.DatasetConnector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatasetRestConnector implements DatasetConnector {

    private String ENDPOINT_VOLUME_LIST = "/api/v1.0/storage/volume/";
    private String ENDPOINT_DATASET_CREATE = "/api/v1.0/storage/dataset/";
    private String ENDPOINT_DATASET_LIST = "/api/v1.0/storage/dataset/";
    private String ENDPOINT_DATASET_UPDATE = "/api/v1.0/storage/volume/";
    private String ENDPOINT_DATASET_DELETE = "/api/v1.0/storage/dataset/";
    private String ENDPOINT_DATASET_SHARING_CIFS = "/api/v1.0/sharing/cifs";
    private String ENDPOINT_DATASET_SHARING_NFS = "/api/v1.0/sharing/nfs";
    private String ENDPOINT_DATASET_SHARING_ISCISI = "/api/v1.0/sharing/nfs"; // FIXME

    private Endpoint endpoint;
    private Authentication auth;
    private String rootUrl = "";

    private static final Logger LOGGER = Logger.getLogger(DatasetRestConnector.class);

    private JSONObject myObj;

    public DatasetRestConnector(Endpoint endpoint, Authentication auth) {
        this.endpoint = endpoint;
        this.auth = auth;
    }

    public Dataset create(String volumeName, Map<String, String> args) throws DatasetAlreadyExists {
        try {
            //Gson gson = new Gson();
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            ObjectMapper mapper = new ObjectMapper() {
                com.fasterxml.jackson.databind.ObjectMapper mapper
                        = new com.fasterxml.jackson.databind.ObjectMapper();

                public String writeValue(Object value) {
                    try {
                        return mapper.writeValueAsString(value);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                public <T> T readValue(String value, Class<T> valueType) {
                    try {
                        return mapper.readValue(value, valueType);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };

            Unirest.config().setObjectMapper(mapper);
            Map<String, Object> mapStr = new HashMap<String, Object>();
            args.forEach((s, k) ->  mapStr.put(s, k));

            JSONObject obj = new JSONObject(mapStr);
            System.out.println(endpoint.getRootEndPoint() + ENDPOINT_DATASET_CREATE + volumeName + "/");


            HttpResponse<JsonNode> jsonResponse = Unirest.post(endpoint.getRootEndPoint() + ENDPOINT_DATASET_CREATE + volumeName + "/")
                    .header("accept", "*/*")
                    .header("Content-Type", "application/json")
                    //.header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Basic " + auth.get64bitEncoded())
                    //.fields((Map)args)

                    //.body((Object)gson.toJson(args))

                    .body(obj)
                    .asJson();


            DatasetSerializer ds = new DatasetSerializer(Dataset.class);
            Dataset result = new Dataset();
            ds.decode(jsonResponse.getBody().getObject(), result);
            return result;


            /** Need to decode an object similar to this:
             * {"avail":24420864000,"atime":"on","comments":null,"pool":"zz","recordsize":131072,"refreservation":0,"used":90112,"sync":"standard","dedup":"off","mountpoint":"/mnt/zz/datasetNameTest","inherit_props":["compression","aclinherit","org.freebsd.ioc:active"],"readonly":"off","refer":90112,"quota":0,"name":"zz/datasetNameTest","reservation":0,"compression":"lz4","refquota":0,"exec":"on"}
             */


        }
        catch (DatasetAlreadyExists e) {
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error while connecting service ", e);
        }

        return null;
    }


    public Dataset update(Dataset id) {
        return null;
    }

    public Dataset delete(String name) {

        try {

            HttpResponse<String> jsonResponse = Unirest.delete(endpoint.getRootEndPoint() + ENDPOINT_DATASET_DELETE + name + "/")
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

    public Dataset get(Long id) {
        return null;
    }


    public List<Volume> list(Long id) {
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
        try {

            HttpResponse<Volume[]> jsonResponse = Unirest.get(endpoint.getRootEndPoint() + ENDPOINT_DATASET_LIST)
                    .basicAuth(auth.getUsername(), auth.getPassword())
                    .header("accept", "application/json")
                    .asObject(Volume[].class);
            //System.out.print(jsonResponse.getBody());

            if (jsonResponse.getStatus() == HttpStatus.SC_OK) {
                Volume[] body = jsonResponse.getBody();
                List<Volume> volumeList = new ArrayList<Volume>();
                for (Volume b : body) {
                    volumeList.add(b);
                }
                return volumeList;
            }

        } catch (UnirestException e) {
            LOGGER.error("Error while connecting service ", e);
        }

        return null;
    }

    public boolean shareCIFS(String name, String path) {

        //Gson gson = new Gson();
        Map<String, String> args = new HashMap<String, String>();

        args.put("cifs_name", name);
        args.put("cifs_path'", path);
        args.put("cifs_guestonly", "True");
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        Map<String, Object> mapStr = new HashMap<String, Object>();
        args.forEach((s, k) ->  mapStr.put(s, k));
        JSONObject obj = new JSONObject(mapStr);

        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(endpoint.getRootEndPoint() + ENDPOINT_DATASET_SHARING_CIFS)
                    .header("accept", "*/*")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + auth.get64bitEncoded())
                    .body(obj)
                    .asJson();
        } catch (UnirestException e) {
            LOGGER.error("Error while connecting service ", e);
        }

        return true;
    }

    public boolean shareNFS(String name, String path) {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            Map<String, String> args = new HashMap<String, String>();

            /**
             *           "nfs_comment": "My Test Share",
             *           "nfs_paths": ["/mnt/tank"],
             *           "nfs_security": "sys"
             */

            args.put("nfs_comment", name);
            args.put("nfs_paths'", path);
            args.put("nfs_security", "sys");



            Map<String, Object> mapStr = new HashMap<String, Object>();
            args.forEach((s, k) ->  mapStr.put(s, k));
            JSONObject obj = new JSONObject(mapStr);
            System.out.println(endpoint.getRootEndPoint() + ENDPOINT_DATASET_SHARING_NFS );
            HttpResponse<JsonNode> jsonResponse = Unirest.post(endpoint.getRootEndPoint() + ENDPOINT_DATASET_SHARING_NFS)
                    .header("accept", "*/*")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + auth.get64bitEncoded())
                    .body(obj)
                    .asJson();
            jsonResponse.getStatus();
            jsonResponse.getBody();

            DatasetSerializer ds = new DatasetSerializer(Dataset.class);
            Dataset result = new Dataset();
            ds.decode(jsonResponse.getBody().getObject(), result);
            return true;
        } catch (Exception e) {
            LOGGER.error("Error while connecting service ", e);
        }
        return true;
    }

    public List<String> getNFSShares() {
        return null;
    }

    public List<String> getCIFS() {
        return null;
    }
}

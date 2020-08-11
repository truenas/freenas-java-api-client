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

//import com.ixsystems.vcp.entities.serializers.NFSShareSerializer;
import com.ixsystems.vcp.entities.ZVol;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.freenas.client.v2.connectors.Authentication;
import org.freenas.client.v2.connectors.Endpoint;
import org.freenas.client.v2.storage.ZVolConnector;
import org.freenas.client.v2.utils.UnirestUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZVolRestConnector implements ZVolConnector {
    private String ENDPOINT_LIST = "/api/v2.0/pool/dataset";
    private String ENDPOINT_CREATE = "/api/v2.0/pool/dataset";
    private String ENDPOINT_DELETE = "/api/v2.0/pool/dataset/id/{id}";

    private static final Logger LOGGER = LogManager.getLogger(ZVolRestConnector.class);

    private Endpoint endpoint;
    private Authentication auth;

    public ZVolRestConnector(Endpoint endpoint, Authentication auth) {
        this.endpoint = endpoint;
        this.auth = auth;
    }

    public ZVol create() {
        ZVol zvol = null;

        return zvol;
    }

    public ZVol update(ZVol id) {
        ZVol zvol = null;

        return zvol;
    }

    public ZVol delete(Long id) {
        ZVol zvol = null;

        return zvol;
    }

    public ZVol get(Long id) {
        ZVol zvol = null;

        return zvol;
    }

    public List<ZVol> list() {
        List<ZVol> zvolList = new ArrayList<ZVol>();

        return zvolList;
    }
}

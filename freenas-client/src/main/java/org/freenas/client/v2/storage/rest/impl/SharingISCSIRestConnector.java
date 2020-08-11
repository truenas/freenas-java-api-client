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
import com.ixsystems.vcp.entities.AssociatedTarget;
import com.ixsystems.vcp.entities.Extent;
import com.ixsystems.vcp.entities.Target;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.freenas.client.v2.connectors.Authentication;
import org.freenas.client.v2.connectors.Endpoint;
import org.freenas.client.v2.storage.SharingISCSIConnector;
import org.freenas.client.v2.utils.UnirestUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharingISCSIRestConnector implements SharingISCSIConnector {
    private String ENDPOINT_SHARING_LIST = "/api/v2.0/sharing/nfs";
    private String ENDPOINT_SHARING_CREATE = "/api/v2.0/sharing/nfs";
    private String ENDPOINT_SHARING_DELETE = "/api/v2.0/sharing/nfs/id/{id}";

    private static final Logger LOGGER = LogManager.getLogger(SharingISCSIRestConnector.class);

    private Endpoint endpoint;
    private Authentication auth;

    public SharingISCSIRestConnector(Endpoint endpoint, Authentication auth) {
        this.endpoint = endpoint;
        this.auth = auth;
    }

    public Extent createExtent(String name, Map<String, String> args)  {
        Extent extent = null;

        return extent;
    }

    public Extent updateExtent(int id) {
        Extent extent = null;

        return extent;
    }

    public Extent deleteExtent(String name) {
        Extent extent = null;

        return extent;
    }

    public Extent getExtent(int id) {
        Extent extent = null;

        return extent;
    }

    public List<Extent> listExtents() {
        List<Extent> extentList = new ArrayList<Extent>();

        return extentList;
    }


    public AssociatedTarget createAssociatedTarget(String name, Map<String, String> args) {
        AssociatedTarget target = null;

        return target;
    }

    public AssociatedTarget updateAssociatedTarget(int id) {
        AssociatedTarget target = null;

        return target;
    }

    public AssociatedTarget deleteAssociatedTarget(String name) {
        AssociatedTarget target = null;

        return target;
    }

    public AssociatedTarget getAssociatedTarget(int id) {
        AssociatedTarget target = null;

        return target;
    }

    public List<AssociatedTarget> listAssociatedTargets() {
        List<AssociatedTarget> targetList = new ArrayList<AssociatedTarget>();

        return targetList;
    }

    public Target createTarget(String name, Map<String, String> args) {
        Target target = null;

        return target;
    }

    public Target updateTarget(int id) {
        Target target = null;

        return target;
    }

    public Target deleteTarget(String name) {
        Target target = null;

        return target;
    }

    public Target getTarget(int id) {
        Target target = null;

        return target;
    }

    public List<Target> listTargets() {
        List<Target> targetList = new ArrayList<Target>();

        return targetList;
    }
}

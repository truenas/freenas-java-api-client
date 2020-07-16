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
package com.ixsystems.vcp.entities.serializers;

import com.ixsystems.vcp.entities.network.GlobalConfigurations;
import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class GlobalConfigurationSerializer{
    public GlobalConfigurations decode(JSONObject obj, GlobalConfigurations gc){
        gc.setGcHostname(obj.getString("hostname"));
        gc.setGcHostnameB(obj.getString("hostname_b"));
        if (obj.get("hostname_virtual")!=null)
            gc.setGcHostnameVirtual(obj.get("hostname_virtual").toString());

        gc.setGcDomain(obj.getString("domain"));

        List<String> props = new ArrayList<String>();
        JSONArray arrDomains = obj.getJSONArray("domains");
        for (int i = 0; i < arrDomains.length(); i++){
            String prop = arrDomains.getString(i);
            props.add(prop);
        }
        gc.setGcDomains(props);

        gc.setGcIpv4Gateway(obj.getString("ipv4gateway"));
        gc.setGcIpv4Gateway(obj.getString("ipv6gateway"));
        gc.setGcNameservers1(obj.getString("nameserver1"));
        gc.setGcNameservers2(obj.getString("nameserver2"));
        gc.setGcNameservers3(obj.getString("nameserver3"));
        gc.setGcHttpProxy(obj.getString("httpproxy"));
        gc.setGcNetwaitEnabled(obj.getBoolean("netwait_enabled"));

        props = new ArrayList<String>();
        JSONArray arrNetwait = obj.getJSONArray("netwait_ip");
        for (int i = 0; i < arrNetwait.length(); i++){
            String prop = arrNetwait.getString(i);
            props.add(prop);
        }
        gc.setGcNetwaitIp(props);

        gc.setGcHosts(obj.getString("hosts"));
        gc.setId(obj.get("id").toString());
        return gc;
    }
}

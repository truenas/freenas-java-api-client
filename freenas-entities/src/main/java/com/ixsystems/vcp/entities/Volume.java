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
package com.ixsystems.vcp.entities;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.ixsystems.vcp.entities.serializers.VolumeSerializer;

/* Retrieved with /pool */
@JsonIgnoreProperties(ignoreUnknown=true,
        value = {"hibernateLazyInitializer", "children", "created"})
@JsonSerialize(include=Inclusion.NON_NULL)
//@JsonSerialize(using = VolumeSerializer.class)
public class Volume {
    private int id;
    private String name;
    @JsonProperty("guid")
    private String vol_guid;
    @JsonProperty("encrypt")
    private int vol_encrypt;
    @JsonProperty("encryptkey")
    private String vol_encryptkey;
    private String path; //New in v2.0
    private String status;
    @JsonIgnore
    private JsonNode scan; //New in v2.0
    @JsonProperty("topology")
    private Topology topology;
    private long used;
    private String used_pct;

    private boolean healthy; //Not connected to methods. New in v2.0
    private String status_detail; //Not connected to methods. New in v2.0
    private String encryptkey_path; //Not connected to methods. New in v2.0
    private boolean is_decrypted;
    //private boolean is_upgraded; //Remove in v2.0
    //private String vol_name; //Removed in v2.0
    //private String mountpoint; //Removed in v2.0
    //private String vol_fstype; //Removed in v2.0

    @JsonIgnore
    //private List<Map<String, Volume>> children;
    private Children[] children;

    public Children[] getChildren() {
        List<Children> children = new ArrayList<Children>();
        if(topology != null) {
            for(VolumeContents cont : topology.getData()) {
                if(cont != null) {
                    for(Children c : cont.getChildren()) {
                        children.add(c);
                    }
                }else{
                    return null;
                }
            }
            return children.toArray(new Children[0]);
        }
        return null;
    }
    /*public void setChildren(Children[] children) {
        this.children = children;
    }*/
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isIs_decrypted() {
        return is_decrypted;
    }
    public void setIs_decrypted(boolean is_decrypted) {
        this.is_decrypted = is_decrypted;
    }
    /*public boolean isIs_upgraded() {
        return is_upgraded;
    }
    public void setIs_upgraded(boolean is_upgraded) {
        this.is_upgraded = is_upgraded;
    }*/
    /*public String getMountpoint() {
        return mountpoint;
    }
    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public long getUsed() {
        if(topology == null) {
            return -1;
        }
        VolumeContents data = topology.getData()[0];
        if(data == null) {
            return -2;
        }
        return data.getStats().get("allocated").asLong();
    }
    /*public void setUsed(long used) {
        this.used = used;
    }*/
    public String getUsed_pct() {
        if(topology == null) {
            return "0%";
        }
        VolumeContents data = topology.getData()[0];
        if(data == null) {
            return "0%";
        }
        double allocated = data.getStats().get("allocated").asDouble();
        double size = data.getStats().get("size").asDouble();
        return Long.toString(Math.round(allocated / size)) + "%";
    }
    /*public void setUsed_pct(String used_pct) {
        this.used_pct = used_pct;
    }*/
    public int getVol_encrypt() {
        return vol_encrypt;
    }
    public void setVol_encrypt(int vol_encrypt) {
        this.vol_encrypt = vol_encrypt;
    }
    public String getVol_encryptkey() {
        return vol_encryptkey;
    }
    public void setVol_encryptkey(String vol_encryptkey) {
        this.vol_encryptkey = vol_encryptkey;
    }
    /*public String getVol_fstype() {
        return vol_fstype;
    }
    public void setVol_fstype(String vol_fstype) {
        this.vol_fstype = vol_fstype;
    }*/
    public String getVol_guid() {
        return vol_guid;
    }
    public void setVol_guid(String vol_guid) {
        this.vol_guid = vol_guid;
    }
    /*public String getVol_name() {
        return vol_name;
    }
    public void setVol_name(String vol_name) {
        this.vol_name = vol_name;
    }*/
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public String toString() {
        return "Volume [id=" + id
                + ", name = " + name
                + ", status = " + status
                + ", used = " + getUsed()
                + ", used_pct = " + getUsed_pct()
                + ", path = " + path 
                + ", vol_encrypt=" + vol_encrypt
                + ", vol_encryptkey=" + vol_encryptkey
                + ", vol_guid=" + vol_guid
                + ", children=" + Arrays.toString(getChildren())
                + ", is_decrypted = " + is_decrypted
                + "]";
    }
}

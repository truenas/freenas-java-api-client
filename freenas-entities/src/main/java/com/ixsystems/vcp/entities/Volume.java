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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.ixsystems.vcp.entities.serializers.VolumeSerializer;

import java.util.List;
import java.util.Map;

@JsonSerialize(using = VolumeSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true,
        value = {"hibernateLazyInitializer", "children", "created"})

public class Volume {
    @JsonProperty("status")
    private String status;

    @JsonAlias("vol_guid")
    @JsonProperty("guid")
    private String volGuid;

    //@JsonProperty("used")
    //private String used;

    @JsonProperty("name")
    private String name;

    //@JsonProperty("used_pct")
    //private String used_pct;

    //@JsonProperty("used_si")
    //private String used_si;

    @JsonProperty("id")
    private String id;

    @JsonAlias("vol_encryptkey")
    @JsonProperty("encryptkey")
    private String volEncryptedKey;

    //@JsonProperty("vol_name")
    //private String volName ;

    @JsonProperty("is_decrypted")
    private String isDecrypted;

    //@JsonProperty("avail_si")
    //private String availableSi;

    //@JsonProperty("avail")
    //private String available;

    @JsonProperty("mountpoint")
    private String mountPoint;

    @JsonAlias("vol_encrypt")
    @JsonProperty("encrypt")
    private String volEncrypted;

    @JsonProperty("children")
    private List<Map<String, Volume>> children;

    //@JsonProperty("total_si")
    //private String totalSi;

    //TODO Add get/set
    @JsonProperty("path")
    private String path;
    /* Other Fields
     * healthy
     * status_detail
     * encryptkey_path
     * stats
     * device
     * disk
     */

    public Volume() { }

    public List<Map<String, Volume>> getChildren() {
        return children;
    }

    public void setChildren(List<Map<String, Volume>> children) {
        this.children = children;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVolGuid() {
        return volGuid;
    }

    public void setVolGuid(String volGuid) {
        this.volGuid = volGuid;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsed_pct() {
        return used_pct;
    }

    public void setUsed_pct(String used_pct) {
        this.used_pct = used_pct;
    }

    public String getUsed_si() {
        return used_si;
    }

    public void setUsed_si(String used_si) {
        this.used_si = used_si;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVolEncryptedKey() {
        return volEncryptedKey;
    }

    public void setVolEncryptedKey(String volEncryptedKey) {
        this.volEncryptedKey = volEncryptedKey;
    }

    public String getVolName() {
        return volName;
    }

    public void setVolName(String volName) {
        this.volName = volName;
    }

    public String getIsDecrypted() {
        return isDecrypted;
    }

    public void setIsDecrypted(String isDecrypted) {
        this.isDecrypted = isDecrypted;
    }

    public String getAvailableSi() {
        return availableSi;
    }

    public void setAvailableSi(String availableSi) {
        this.availableSi = availableSi;
    }

    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }

    public String getVolEncrypted() {
        return volEncrypted;
    }

    public void setVolEncrypted(String volEncrypted) {
        this.volEncrypted = volEncrypted;
    }

    public String getTotalSi() {
        return totalSi;
    }

    public void setTotalSi(String totalSi) {
        this.totalSi = totalSi;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "status='" + status + '\'' +
                ", volGuid='" + volGuid + '\'' +
                ", used='" + used + '\'' +
                ", name='" + name + '\'' +
                ", used_pct='" + used_pct + '\'' +
                ", used_si='" + used_si + '\'' +
                ", id='" + id + '\'' +
                ", volEncryptedKey='" + volEncryptedKey + '\'' +
                ", volName='" + volName + '\'' +
                ", isDecrypted='" + isDecrypted + '\'' +
                ", availableSi='" + availableSi + '\'' +
                ", available='" + available + '\'' +
                ", mountPoint='" + mountPoint + '\'' +
                ", volEncrypted='" + volEncrypted + '\'' +
                ", children='" + children + '\'' +
                ", totalSi='" + totalSi + '\'' +
                '}';
    }
}

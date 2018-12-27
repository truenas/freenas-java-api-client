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
package com.ixsystems.vcp.entities.share;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class NFSShare {

    //{"id": 1, "comment": "", "hosts": [], "alldirs": true, "ro": false, "quiet": false, "maproot_user": "root",
    // "maproot_group": "wheel", "mapall_user": null, "mapall_group": null, "security": [],
    // "paths": ["/mnt/primary"], "networks": []}


    @JsonAlias("alldirs")
    @JsonProperty("nfs_alldirs")
    private Boolean allDirs ;

    @JsonProperty("id")
    private String id ;


    @JsonAlias("comment")
    @JsonProperty("nfs_comment")
    private String comment ;


    @JsonProperty("nfs_hosts")
    private String hosts ;

    @JsonProperty("hosts")
    private List<String> getHostList(){
        List<String> hosts = new ArrayList<String>();
        if (this.hosts!=null) {
            String[] tmp = this.hosts.split(",");
            for (int i = 0; i < tmp.length; i++)
                hosts.add(tmp[i]);
        }
        return hosts;
    }


    @JsonAlias("mapall_user")
    @JsonProperty("nfs_mapall_user")
    private String mapAllUser;

    @JsonAlias("mapall_group")
    @JsonProperty("nfs_mapall_group")
    private String mapAllGroup;

    @JsonAlias("maproot_user")
    @JsonProperty("nfs_maproot_user")
    private String mapRootUser;

    @JsonAlias({"maproot_group", "nfs_maproot_group"})
    @JsonProperty("nfs_maproot_group")
    private String mapRootGroup;

    @JsonAlias("network")
    @JsonProperty("nfs_network")
    private String network;

    @JsonAlias({"paths", "nfs_paths"})
    @JsonProperty("paths")
    private List<String> paths;

    @JsonAlias("quiet")
    @JsonProperty("nfs_quiet")
    private Boolean quiet;

    @JsonAlias("ro")
    @JsonProperty("nfs_ro")
    private Boolean readOnly;

    @JsonIgnore
    @JsonAlias("security")
    @JsonProperty("nfs_security")
    private List<String> security;

    public Boolean getAllDirs() {
        return allDirs;
    }

    public void setAllDirs(Boolean allDirs) {
        this.allDirs = allDirs;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public String getMapAllUser() {
        return mapAllUser;
    }

    public void setMapAllUser(String mapAllUser) {
        this.mapAllUser = mapAllUser;
    }
    public String getMapAllGroup() {
        return mapAllGroup;
    }

    public String getMapRootGroup() {
        return mapRootGroup;
    }

    public void setMapRootGroup(String mapRootGroup) {
        this.mapRootGroup = mapRootGroup;
    }

    public void setMapAllGroup(String mapAllGroup) {
        this.mapAllGroup = mapAllGroup;
    }

    public String getMapRootUser() {
        return mapRootUser;
    }

    public void setMapRootUser(String mapRootUser) {
        this.mapRootUser = mapRootUser;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public Boolean getQuiet() {
        return quiet;
    }

    public void setQuiet(Boolean quiet) {
        this.quiet = quiet;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public List<String> getSecurity() {
        return security;
    }

    public void setSecurity(List<String> security) {
        this.security = security;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NFSShare nfsShare = (NFSShare) o;

        if (allDirs != null ? !allDirs.equals(nfsShare.allDirs) : nfsShare.allDirs != null) return false;
        if (comment != null ? !comment.equals(nfsShare.comment) : nfsShare.comment != null) return false;
        if (hosts != null ? !hosts.equals(nfsShare.hosts) : nfsShare.hosts != null) return false;
        if (mapAllGroup != null ? !mapAllGroup.equals(nfsShare.mapAllGroup) : nfsShare.mapAllGroup != null)
            return false;
        if (mapRootUser != null ? !mapRootUser.equals(nfsShare.mapRootUser) : nfsShare.mapRootUser != null)
            return false;
        if (network != null ? !network.equals(nfsShare.network) : nfsShare.network != null) return false;
        if (paths != null ? !paths.equals(nfsShare.paths) : nfsShare.paths != null) return false;
        if (quiet != null ? !quiet.equals(nfsShare.quiet) : nfsShare.quiet != null) return false;
        if (readOnly != null ? !readOnly.equals(nfsShare.readOnly) : nfsShare.readOnly != null) return false;
        return security != null ? security.equals(nfsShare.security) : nfsShare.security == null;
    }

    @Override
    public int hashCode() {
        int result = allDirs != null ? allDirs.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (hosts != null ? hosts.hashCode() : 0);
        result = 31 * result + (mapAllGroup != null ? mapAllGroup.hashCode() : 0);
        result = 31 * result + (mapRootUser != null ? mapRootUser.hashCode() : 0);
        result = 31 * result + (network != null ? network.hashCode() : 0);
        result = 31 * result + (paths != null ? paths.hashCode() : 0);
        result = 31 * result + (quiet != null ? quiet.hashCode() : 0);
        result = 31 * result + (readOnly != null ? readOnly.hashCode() : 0);
        result = 31 * result + (security != null ? security.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NFSShare{" +
                "allDirs=" + allDirs +
                ", id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                ", hosts='" + hosts + '\'' +
                ", mapAllUser='" + mapAllUser + '\'' +
                ", mapAllGroup='" + mapAllGroup + '\'' +
                ", mapRootUser='" + mapRootUser + '\'' +
                ", mapRootGroup='" + mapRootGroup + '\'' +
                ", network='" + network + '\'' +
                ", paths=" + paths +
                ", quiet=" + quiet +
                ", readOnly=" + readOnly +
                ", security=" + security +
                '}';
    }
}

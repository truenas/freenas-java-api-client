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
 * * Neither the name of py-bsd nor the names of its
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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Replication {


    @JsonProperty("repl_end")
    private String replEnd;
    @JsonProperty("repl_remote_dedicateduser")
    private String replRemoteDedicatedUser;
    @JsonProperty("repl_userepl")
    private Boolean replUserPl;
    @JsonProperty("repl_limit")
    private Long replLimit;
    @JsonProperty("repl_remote_port")
    private Integer replRemotePort;
    @JsonProperty("repl_remote_dedicateduser_enabled")
    private Boolean isReplRemoteDedicatedUserEnabled;
    @JsonProperty("repl_begin")
    private String replBegin;
    @JsonProperty("repl_filesystem")
    private String replFilesystem;
    @JsonProperty("repl_remote_cipher")
    private String replRemoteCipher;
    @JsonProperty("repl_remote_hostkey")
    private String replRemoteHostKey;

    @JsonProperty("repl_enabled")
    private Boolean replEnabled;
    @JsonProperty("repl_compression")
    private String replCompression;
    @JsonProperty("repl_remote_hostname")
    private String replRemoteHostname;
    @JsonProperty("repl_lastsnapshot")
    private String replLastSnapshot;
    @JsonProperty("repl_status")
    private String replStatus;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("repl_zfs")
    private String replZfs;


    public String getReplEnd() {
        return replEnd;
    }

    public void setReplEnd(String replEnd) {
        this.replEnd = replEnd;
    }

    public String getReplRemoteDedicatedUser() {
        return replRemoteDedicatedUser;
    }

    public void setReplRemoteDedicatedUser(String replRemoteDedicatedUser) {
        this.replRemoteDedicatedUser = replRemoteDedicatedUser;
    }

    public Boolean getReplUserPl() {
        return replUserPl;
    }

    public void setReplUserPl(Boolean replUserPl) {
        this.replUserPl = replUserPl;
    }

    public Long getReplLimit() {
        return replLimit;
    }

    public void setReplLimit(Long replLimit) {
        this.replLimit = replLimit;
    }

    public Integer getReplRemotePort() {
        return replRemotePort;
    }

    public void setReplRemotePort(Integer replRemotePort) {
        this.replRemotePort = replRemotePort;
    }

    public Boolean getReplRemoteDedicatedUserEnabled() {
        return isReplRemoteDedicatedUserEnabled;
    }

    public void setReplRemoteDedicatedUserEnabled(Boolean replRemoteDedicatedUserEnabled) {
        isReplRemoteDedicatedUserEnabled = replRemoteDedicatedUserEnabled;
    }

    public String getReplBegin() {
        return replBegin;
    }

    public void setReplBegin(String replBegin) {
        this.replBegin = replBegin;
    }

    public String getReplFilesystem() {
        return replFilesystem;
    }

    public void setReplFilesystem(String replFilesystem) {
        this.replFilesystem = replFilesystem;
    }

    public String getReplRemoteCipher() {
        return replRemoteCipher;
    }

    public void setReplRemoteCipher(String replRemoteCipher) {
        this.replRemoteCipher = replRemoteCipher;
    }

    public String getReplRemoteHostKey() {
        return replRemoteHostKey;
    }

    public void setReplRemoteHostKey(String replRemoteHostKey) {
        this.replRemoteHostKey = replRemoteHostKey;
    }


    public Boolean getReplEnabled() {
        return replEnabled;
    }

    public void setReplEnabled(Boolean replEnabled) {
        this.replEnabled = replEnabled;
    }

    public String getReplCompression() {
        return replCompression;
    }

    public void setReplCompression(String replCompression) {
        this.replCompression = replCompression;
    }

    public String getReplRemoteHostname() {
        return replRemoteHostname;
    }

    public void setReplRemoteHostname(String replRemoteHostname) {
        this.replRemoteHostname = replRemoteHostname;
    }

    public String getReplLastSnapshot() {
        return replLastSnapshot;
    }

    public void setReplLastSnapshot(String replLastSnapshot) {
        this.replLastSnapshot = replLastSnapshot;
    }

    public String getReplStatus() {
        return replStatus;
    }

    public void setReplStatus(String replStatus) {
        this.replStatus = replStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReplZfs() {
        return replZfs;
    }

    public void setReplZfs(String replZfs) {
        this.replZfs = replZfs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Replication that = (Replication) o;

        if (replEnd != null ? !replEnd.equals(that.replEnd) : that.replEnd != null) return false;
        if (replRemoteDedicatedUser != null ? !replRemoteDedicatedUser.equals(that.replRemoteDedicatedUser) : that.replRemoteDedicatedUser != null)
            return false;
        if (replUserPl != null ? !replUserPl.equals(that.replUserPl) : that.replUserPl != null) return false;
        if (replLimit != null ? !replLimit.equals(that.replLimit) : that.replLimit != null) return false;
        if (replRemotePort != null ? !replRemotePort.equals(that.replRemotePort) : that.replRemotePort != null)
            return false;
        if (isReplRemoteDedicatedUserEnabled != null ? !isReplRemoteDedicatedUserEnabled.equals(that.isReplRemoteDedicatedUserEnabled) : that.isReplRemoteDedicatedUserEnabled != null)
            return false;
        if (replBegin != null ? !replBegin.equals(that.replBegin) : that.replBegin != null) return false;
        if (replFilesystem != null ? !replFilesystem.equals(that.replFilesystem) : that.replFilesystem != null)
            return false;
        if (replRemoteCipher != null ? !replRemoteCipher.equals(that.replRemoteCipher) : that.replRemoteCipher != null)
            return false;
        if (replRemoteHostKey != null ? !replRemoteHostKey.equals(that.replRemoteHostKey) : that.replRemoteHostKey != null)
            return false;

        if (replEnabled != null ? !replEnabled.equals(that.replEnabled) : that.replEnabled != null) return false;
        if (replCompression != null ? !replCompression.equals(that.replCompression) : that.replCompression != null)
            return false;
        if (replRemoteHostname != null ? !replRemoteHostname.equals(that.replRemoteHostname) : that.replRemoteHostname != null)
            return false;
        if (replLastSnapshot != null ? !replLastSnapshot.equals(that.replLastSnapshot) : that.replLastSnapshot != null)
            return false;
        if (replStatus != null ? !replStatus.equals(that.replStatus) : that.replStatus != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return replZfs != null ? replZfs.equals(that.replZfs) : that.replZfs == null;
    }

    @Override
    public int hashCode() {
        int result = replEnd != null ? replEnd.hashCode() : 0;
        result = 31 * result + (replRemoteDedicatedUser != null ? replRemoteDedicatedUser.hashCode() : 0);
        result = 31 * result + (replUserPl != null ? replUserPl.hashCode() : 0);
        result = 31 * result + (replLimit != null ? replLimit.hashCode() : 0);
        result = 31 * result + (replRemotePort != null ? replRemotePort.hashCode() : 0);
        result = 31 * result + (isReplRemoteDedicatedUserEnabled != null ? isReplRemoteDedicatedUserEnabled.hashCode() : 0);
        result = 31 * result + (replBegin != null ? replBegin.hashCode() : 0);
        result = 31 * result + (replFilesystem != null ? replFilesystem.hashCode() : 0);
        result = 31 * result + (replRemoteCipher != null ? replRemoteCipher.hashCode() : 0);
        result = 31 * result + (replRemoteHostKey != null ? replRemoteHostKey.hashCode() : 0);
        result = 31 * result + (replEnabled != null ? replEnabled.hashCode() : 0);
        result = 31 * result + (replCompression != null ? replCompression.hashCode() : 0);
        result = 31 * result + (replRemoteHostname != null ? replRemoteHostname.hashCode() : 0);
        result = 31 * result + (replLastSnapshot != null ? replLastSnapshot.hashCode() : 0);
        result = 31 * result + (replStatus != null ? replStatus.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (replZfs != null ? replZfs.hashCode() : 0);
        return result;
    }
}

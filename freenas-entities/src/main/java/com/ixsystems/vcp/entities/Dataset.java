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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Dataset {
    @JsonProperty("atime")
    private String atime; //ON or OFF
    //New with v2.0
    @JsonProperty("exec")
    private String exec; //ON or OFF
    @JsonAlias("avail")
    @JsonProperty("available")
    private Long available;
    @JsonProperty("volsize")
    private Long volsize;
    //@JsonProperty("comments")
    //private String comments;
    @JsonProperty("compression")
    private String compression;//OFF, LZ4, GZIP,..., INHERIT

    @JsonAlias("dedup")
    @JsonProperty("deduplication")
    private String dedup;//VISIBLE or HIDDEN or INHERIT

    //@JsonProperty("inherit_props")
    //private List<String> inheritProps;

    @JsonProperty("mountpoint")
    private String mountPoint;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pool")
    private String pool;

    @JsonProperty("quota")
    private Long quota; //Can be null

    @JsonProperty("readonly")
    private String readOnly; //ON or OFF

    //Switched to String enum in v2.0
    @JsonProperty("recordsize")
    private String recordSize; //512, 1K, 2K,..., 1024K

    //@JsonProperty("refer")
    //private Long refer;

    @JsonProperty("refquota")
    private Long refQuota; //Can be null

    @JsonProperty("refreservation")
    private Long refReservation;

    @JsonProperty("reservation")
    private Long reservation;

    @JsonProperty("used")
    private Long used;
    /* Other Fields
     * type
     * children
     * encryption_root
     * key_loaded
     * managedby  
     * pbkdf2iters
     * special_small_block_size
     * encryption_algorithm
     * key_format
     * snapdir
     * copies
     * origin
     * compressratio
     * sync
     * casesensitivity
     * xattr
     * acltype
     * aclmode
     */


    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getExec() {
        return exec;
    }

    public void setExec(String exec) {
        this.exec = esec;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    /*public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }*/

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getDedup() {
        return dedup;
    }

    public void setDedup(String dedup) {
        this.dedup = dedup;
    }

    /*public List<String> getInheritProps() {
        return inheritProps;
    }

    public void setInheritProps(List<String> inheritProps) {
        this.inheritProps = inheritProps;
    }*/

    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public Long getQuota() {
        return quota;
    }

    public void setQuota(Long quota) {
        this.quota = quota;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    public String getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(String recordSize) {
        this.recordSize = recordSize;
    }

    /*public Long getRefer() {
        return refer;
    }

    public void setRefer(Long refer) {
        this.refer = refer;
    }*/

    public Long getRefQuota() {
        return refQuota;
    }

    public void setRefQuota(Long refQuota) {
        this.refQuota = refQuota;
    }

    public Long getRefReservation() {
        return refReservation;
    }

    public void setRefReservation(Long refReservation) {
        this.refReservation = refReservation;
    }

    public Long getReservation() {
        return reservation;
    }

    public void setReservation(Long reservation) {
        this.reservation = reservation;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dataset dataset = (Dataset) o;

        if (atime != null ? !atime.equals(dataset.atime) : dataset.atime != null) return false;
        if (exec != null ? !exec.equals(dataset.exec) : dataset.exec != null) return false;
        if (available != null ? !available.equals(dataset.available) : dataset.available != null) return false;
        //if (comments != null ? !comments.equals(dataset.comments) : dataset.comments != null) return false;
        if (compression != null ? !compression.equals(dataset.compression) : dataset.compression != null) return false;
        if (dedup != null ? !dedup.equals(dataset.dedup) : dataset.dedup != null) return false;
        //if (inheritProps != null ? !inheritProps.equals(dataset.inheritProps) : dataset.inheritProps != null) return false;
        if (mountPoint != null ? !mountPoint.equals(dataset.mountPoint) : dataset.mountPoint != null) return false;
        if (name != null ? !name.equals(dataset.name) : dataset.name != null) return false;
        if (pool != null ? !pool.equals(dataset.pool) : dataset.pool != null) return false;
        if (quota != null ? !quota.equals(dataset.quota) : dataset.quota != null) return false;
        if (readOnly != null ? !readOnly.equals(dataset.readOnly) : dataset.readOnly != null) return false;
        if (recordSize != null ? !recordSize.equals(dataset.recordSize) : dataset.recordSize != null) return false;
        //if (refer != null ? !refer.equals(dataset.refer) : dataset.refer != null) return false;
        if (refQuota != null ? !refQuota.equals(dataset.refQuota) : dataset.refQuota != null) return false;
        if (refReservation != null ? !refReservation.equals(dataset.refReservation) : dataset.refReservation != null)
            return false;
        if (reservation != null ? !reservation.equals(dataset.reservation) : dataset.reservation != null) return false;
        return used != null ? used.equals(dataset.used) : dataset.used == null;
    }

    @Override
    public int hashCode() {
        int result = atime != null ? atime.hashCode() : 0;
        result = 31 * result + (exec != null ? exec.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + (volsize != null ? volsize.hashCode() : 0);
        //result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (compression != null ? compression.hashCode() : 0);
        result = 31 * result + (dedup != null ? dedup.hashCode() : 0);
        //result = 31 * result + (inheritProps != null ? inheritProps.hashCode() : 0);
        result = 31 * result + (mountPoint != null ? mountPoint.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pool != null ? pool.hashCode() : 0);
        result = 31 * result + (quota != null ? quota.hashCode() : 0);
        result = 31 * result + (readOnly != null ? readOnly.hashCode() : 0);
        result = 31 * result + (recordSize != null ? recordSize.hashCode() : 0);
        //result = 31 * result + (refer != null ? refer.hashCode() : 0);
        result = 31 * result + (refQuota != null ? refQuota.hashCode() : 0);
        result = 31 * result + (refReservation != null ? refReservation.hashCode() : 0);
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        result = 31 * result + (used != null ? used.hashCode() : 0);
        return result;
    }
}

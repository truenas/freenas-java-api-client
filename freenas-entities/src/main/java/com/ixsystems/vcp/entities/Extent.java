package com.ixsystems.truenas.vcp.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/* Retrieved from /iscsi/extent */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class Extent {
    private int id;
    private String name;
    private String serial;
    private String type;
    private String path;
    private String filesize;
    private int blocksize;
    private boolean pblocksize;
    private int avail_threshold;
    private String naa;
    private String comment;
    private boolean insecure_tpc;
    private boolean xen;
    private String rpm;
    private boolean ro;
    private boolean enabled;
    private String vendor;
    private String disk;
    private boolean legacy;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getFilesize() {
        return filesize;
    }
    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }
    public int getBlocksize() {
        return blocksize;
    }
    public void setBlocksize(int blocksize) {
        this.blocksize = blocksize;
    }
    public boolean getPBlocksize() {
        return pblocksize;
    }
    public void setPBlockSize(boolean pblocksize) {
        this.pblocksize = pblocksize;
    }
    public int getAvail_threshold() {
        return avail_threshold;
    }
    public void setAvail_threshold(int avail_threshold) {
        this.avail_threshold = avail_threshold;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getNaa() {
        return naa;
    }
    public void setNaa(String naa) {
        this.naa = naa;
    }
    public boolean getInsecure_tpc() {
        return insecure_tpc;
    }
    public void setInsecure_tpc(boolean insecure_tpc) {
        this.insecure_tpc = insecure_tpc;
    }
    public boolean getXen() {
        return xen;
    }
    public void setXen(boolean xen) {
        this.xen = xen;
    }
    public String getRpm() {
        return rpm;
    }
    public void setRpm(String rpm) {
        this.rpm = rpm;
    }
    public boolean getRo() {
        return ro;
    }
    public void setRo(boolean ro) {
        this.ro = ro;
    }
    public boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getDisk() {
        return disk;
    }
    public void setDisk(String disk) {
        this.disk = disk;
    }
    public boolean getLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    @Override
    public String toString() {
        return "Extent [id= " + id
                + ", name= " + name
                + ", serial= " + serial
                + ", type= " + type
                + ", path= " + path
                + ", filesize= " + filesize
                + ", blocksize= " + blocksize
                + ", pblocksize= " + pblocksize
                + ", avail_threshold= " + avail_threshold
                + ", comment= " + comment
                + ", naa= " + naa
                + ", insecure_tpc= " + insecure_tpc
                + ", xen= " + xen
                + ", rpm= " + rpm
                + ", ro= " + ro
                + ", enabled= " + enabled
                + ", vendor= " + vendor
                + ", disk= " + disk
                + ", locked= " + locked
                + "]";
    }
}

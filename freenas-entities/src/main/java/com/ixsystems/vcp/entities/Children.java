package com.ixsystems.vcp.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Arrays;

/* Used in conjunction with Volume */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
@JsonDeserialize()
public class Children {
    private String type;
    private String path;
    private String guid;
    private String status;
    @JsonProperty("stats")
    private JsonNode stats;

    private long avail;
    private String used_pct;
    private long used;
    private Children[] children;
    private String device;
    private String disk;
    //Removed in v2.0:
    //private int id;
    //private String mountpoint;
    //private String name;

    public Children[] getChildren() {
        return children;
    }
    public void setChildren(Children[] children) {
        this.children = children;
    }
    public long getAvail() {
        if(stats != null) {
            this.avail = stats.get("size").asLong() - getUsed();
            return avail;
        }
        return 0;
    }
    /*public void setAvail(long avail) {
        this.avail = avail;
    }*/
    /*public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }*/
    public String getUsed_pct() {
        long allocated = getUsed();
        if(stats != null) {
            double size = stats.get("size").asDouble();
            this.used_pct = Long.toString(Math.round(allocated / size)) + "%";
            return used_pct;
        }
        return null;
    }
    /*public void setUsed_pct(String used_pct) {
        this.used_pct = used_pct;
    }*/
    /*public String getMountpoint() {
        return mountpoint;
    }
    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }*/
    /*public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }*/
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getUsed() {
        if(stats != null) {
            this.used = stats.get("allocated").asLong();
            return used;
        }
        return 0;
    }
    /*public void setUsed(long used) {
        this.used = used;
    }*/
    @Override
    public String toString() {
        return "Children [type=" + type
                + ", path = " + path
                + ", guid=" + guid
                + ", status = " + status
                + ", used = " + getUsed()
                + ", used_pct = " + getUsed_pct()
                + ", avail = " + getAvail()
                + ", path = " + path 
                + ", device =" + device
                + ", disk =" + disk
                + ", children=" + Arrays.toString(getChildren())
                + "]";
    }
}

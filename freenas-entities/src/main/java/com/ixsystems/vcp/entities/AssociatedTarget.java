package com.ixsystems.truenas.vcp.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/* Retrieved from /iscsi/targetextent */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class AssociatedTarget {
    int id;
    int extent; 
    int lunid;
    int target;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getExtent() {
        return extent;
    }
    public void setExtent(int extent) {
        this.extent = extent;
    }
    public int getLunid() {
        return lunid;
    }
    public void setLunid(int lunid) {
        this.lunid = lunid;
    }
    public int getTarget() {
        return target;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    @Override
    public String toString() {
        return "AssociatedTarget [id= " + id
                + ", extent= " + extent
                + ", lunid= " + lunid
                + ", target= " + target
                + "]";
    }
}

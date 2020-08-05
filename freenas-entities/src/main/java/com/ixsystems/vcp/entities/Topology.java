package com.ixsystems.vcp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/* Used with Volume */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class Topology {
    VolumeContents[] data;
    VolumeContents[] log;
    VolumeContents[] cache;
    VolumeContents[] spare;
    VolumeContents[] special;
    VolumeContents[] dedup;

    public VolumeContents[] getData() {
        return data;
    }
    @Override
    public String toString() {
        return "Topology[data= " + data
                + ", log=" + log
                + ", cache=" + cache
                + ", spare=" + spare
                + ", special=" + special
                + ", dedup=" + dedup
                + "]";
    }
}

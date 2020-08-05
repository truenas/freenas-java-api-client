package com.ixsystems.vcp.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/* Used with Topology */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class VolumeContents {
    private String type;
    private String path;
    private String guid;
    private String status;
    private JsonNode stats;
    private Children[] children;

    public JsonNode getStats() {
        return stats;
    }
    public Children[] getChildren() {
        return children;
    }
    @Override
    public String toString() {
        return "VolumeContents[type= " + type
                + ", path=" + path
                + ", guid=" + guid
                + ", status=" + status
                + "]";
    }
}

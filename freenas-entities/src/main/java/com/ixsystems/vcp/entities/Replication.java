package com.ixsystems.vcp.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author Ryussi Tech
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class Replication {
    private int id;
    private String name; //New in v2.0
    private String direction; //New in v2.0. Enum value
    private String transport; //New in v2.0. Enum value

    private JsonNode ssh_credentials;
    /*@JsonProperty("id")
    private int credential_id;
    @JsonProperty("name")
    private int credential_name;
    @JsonProperty("name")
    private int credential_type;
    @JsonUnwrapped
    private JsonNode attributes;
    @JsonProperty("host")
    private String repl_remote_hostname;
    @JsonProperty("port")
    private int repl_remote_http_port;
    @JsonProperty("username")
    private String repl_remote_dedicateduser;
    //private int repl_remote_port; //Not in v2.0
    @JsonProperty("private_key")
    private int private_key; //New in v2.0
    @JsonProperty("remote_host_key")
    private String repl_remote_hostkey;
    @JsonProperty("cipher")
    private String repl_remote_cipher;
    @JsonProperty("connect_timeout")
    private int connect_timeout;*/

    private String netcat_active_side;
    private String netcat_active_side_listen_address;
    private int netcat_active_side_port_min;
    private int netcat_active_side_port_max;
    private String[] source_datasets;
    private String target_dataset;
    @JsonProperty("recursive")
    private boolean repl_userepl;
    private String[] exclude;
    private boolean properties;
    private String[] naming_schema;
    private boolean auto;
    private boolean only_matching_schedule;
    private String readonly; //Enum value
    private boolean allow_from_scratch;
    private boolean hold_pending_snapshots;
    private String retention_policy; //Enum value
    private int lifetime_value;
    private String lifetime_unit;
    @JsonProperty("compression")
    private String repl_compression; //Enum value
    @JsonProperty("speed_limit")
    private int repl_limit;
    private boolean large_block;
    private boolean embed;
    private boolean compressed;
    private int retries;
    @JsonProperty("enabled")
    private boolean repl_enabled;

    private JsonNode state;
    /*@JsonProperty("last_snapshot")
    private String repl_lastsnapshot;
    @JsonProperty("state")
    private String repl_status;*/

    private JsonNode[] periodic_snapshot_tasks;
    private String[] also_include_naming_schema;
    private JsonNode schedule;
    private JsonNode restrict_schedule;
    private JsonNode job;

    /*public String getRepl_remote_dedicateduser() {
        return repl_remote_dedicateduser;
    }
    public void setRepl_remote_dedicateduser(String repl_remote_dedicateduser) {
        this.repl_remote_dedicateduser = repl_remote_dedicateduser;
    }
    public boolean isRepl_userepl() {
        return repl_userepl;
    }
    public void setRepl_userepl(boolean repl_userepl) {
        this.repl_userepl = repl_userepl;
    }*/
    public int getRepl_limit() {
        return repl_limit;
    }
    public void setRepl_limit(int repl_limit) {
        this.repl_limit = repl_limit;
    }
    /*public int getRepl_remote_http_port() {
        return repl_remote_http_port;
    }
    public void setRepl_remote_http_port(int repl_remote_port) {
        this.repl_remote_http_port = repl_remote_port;
    }
    public String getRepl_remote_cipher() {
        return repl_remote_cipher;
    }
    public void setRepl_remote_cipher(String repl_remote_cipher) {
        this.repl_remote_cipher = repl_remote_cipher;
    }
    public String getRepl_remote_hostkey() {
        return repl_remote_hostkey;
    }
    public void setRepl_remote_hostkey(String repl_remote_hostkey) {
        this.repl_remote_hostkey = repl_remote_hostkey;
    }*/
    public boolean isRepl_enabled() {
        return repl_enabled;
    }
    public void setRepl_enabled(boolean repl_enabled) {
        this.repl_enabled = repl_enabled;
    }
    public String getRepl_compression() {
        return repl_compression;
    }
    public void setRepl_compression(String repl_compression) {
        this.repl_compression = repl_compression;
    }
    /*public String getRepl_remote_hostname() {
        return repl_remote_hostname;
    }
    public void setRepl_remote_hostname(String repl_remote_hostname) {
        this.repl_remote_hostname = repl_remote_hostname;
    }
    public String getRepl_lastsnapshot() {
        return repl_lastsnapshot;
    }
    public void setRepl_lastsnapshot(String repl_lastsnapshot) {
        this.repl_lastsnapshot = repl_lastsnapshot;
    }
    public String getRepl_status() {
        return repl_status;
    }
    public void setRepl_status(String repl_status) {
        this.repl_status = repl_status;
    }*/
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
    public String getTarget_dataset() {
        return target_dataset;
    }
    public void setTarget_dataset(String target_dataset) {
        this.target_dataset = target_dataset;
    }
}

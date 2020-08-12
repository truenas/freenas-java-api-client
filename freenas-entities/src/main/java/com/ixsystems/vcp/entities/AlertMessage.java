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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(include=Inclusion.NON_NULL)
public class AlertMessage {
    private String uuid;
    private String source;
    private String klass;
    private Object args;
    private String node;
    private String key;
    private JsonNode datetime;
    private JsonNode last_occurrence;
    private boolean dismissed;
    private String mail;
    private String text;
    private String id;
    private String level;
    private String formatted;
    private boolean one_shot;

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String souce) {
        this.source = source;
    }
    public String getKlass() {
        return klass;
    }
    public void setKlass(String klass) {
        this.klass = klass;
    }
    public Object getArgs() {
        //TODO: Fix when args become String[]
        return args;
    }
    public void setArgs(Object args) {
        //TODO: Fix when args become String[]
        //this.args = args;
    }
    public String getNode() {
        return node;
    }
    public void setNode(String node) {
        this.node = node;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    //datetime and last_occurrence are not automatically seralized through
    //Jackson due to how they're wrapped in an object
    @JsonIgnore
    public long getDatetime() { 
        if(datetime != null) {
            return datetime.get("$date").asLong();
        }
        return -1;
    }
    @JsonIgnore
    public void setDatetime(long date) {
        //TODO: Wrap in object
        //this.datetime = date;
    }
    @JsonIgnore
    public long getLast_occurrence() { 
        if(last_occurrence != null) {
            return last_occurrence.get("$date").asLong();
        }
        return -1;
    }
    @JsonIgnore
    public void setLast_occurrence(long date) {
        //TODO: Wrap in object
        //this.last_occurrence = date;
    }
    public boolean isDismissed() {
        return dismissed;
    }
    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getFormatted() {
        return formatted;
    }
    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
    public boolean getOne_shot() {
        return one_shot;
    }
    public void setOne_shot(boolean one_shot) {
        this.one_shot = one_shot;
    }
    @Override
    public String toString() {
        return "AlertMessage{ " +
                "uuid= " + uuid +
                ", source= " + source +
                ", klass= " + klass +
                //", args= " + args +
                ", node= " + node +
                ", key= " + key +
                ", datetime= " + getDatetime() +
                ", last_occurrence" + getLast_occurrence() +
                ", dismissed= " + dismissed +
                ", mail= " + mail +
                ", text= " + text +
                ", id= " + id +
                ", level= " + level +
                ", formatted= " + formatted +
                ", one_shot= " + one_shot +
                '}';
    }
}

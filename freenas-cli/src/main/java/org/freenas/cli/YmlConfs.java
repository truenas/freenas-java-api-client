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
package org.freenas.cli;

import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YmlConfs {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(YmlConfs.class);
    Map<String, Object> properties = null;

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public YmlConfs() {

    }

    public void load() throws FileNotFoundException {
        File f = new File("conf/freenas.yml");
        if (!f.exists()){
            throw new FileNotFoundException(f.getAbsolutePath());
        }
        Yaml yaml = new Yaml();

        InputStream inputStream = new FileInputStream(f);
        Map<String, Object> obj = yaml.load(inputStream);
        LOGGER.info("There is one object.. ");
        this.properties = obj;
    }

    public String getUsername(){
        Map<String, String> prop = (Map<String, String>) this.properties.get("freenas");
        return prop.get("username");
    }

    public String getPassword(){
        Map<String, String> prop = (Map<String, String>) this.properties.get("freenas");
        return prop.get("password");
    }
    public String getUrl(){
        Map<String, String> prop = (Map<String, String>) this.properties.get("freenas");
        return prop.get("url");
    }

    public Boolean getWebSockets(){
        Map<String, String> prop = (Map<String, String>) this.properties.get("freenas");
        return Boolean.parseBoolean(prop.get("websockets"));
    }

    public Map<String, Object> getProperties() {
        return properties;
    }


}

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
package com.ixsystems.vcp.entities.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ixsystems.vcp.entities.Dataset;
import com.ixsystems.vcp.entities.Volume;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetSerializer extends StdSerializer<Dataset> implements EntitySerializer<Dataset>  {
    private static final Logger LOGGER = Logger.getLogger(DatasetSerializer.class);

    public DatasetSerializer(Class<Dataset> t) {
        super(t);
    }

    public DatasetSerializer(JavaType type) {
        super(type);
    }

    public DatasetSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    public DatasetSerializer(StdSerializer<?> src) {
        super(src);
    }

    public void serialize(Dataset dataset, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    }

    public Dataset decode(JSONObject obj, Dataset instance) {
        instance.setAtime(obj.getString("atime"));
        instance.setAvailable(obj.getLong("avail"));
        try {
            instance.setComments(obj.getString("comments"));
        }
        catch (Exception e)
        {
            LOGGER.debug("Problem decoding comments ", e);
        }
        instance.setCompression(obj.getString("compression"));
        instance.setDedup(obj.getString("dedup"));
        instance.setName(obj.getString("name"));
        instance.setPool(obj.getString("pool"));

        // Get Inherit Props

        List<String> props = new ArrayList<String>();

        JSONArray iInheritProps = obj.getJSONArray("inherit_props");

        for (int i = 0 ; i<iInheritProps.length();i++){
            String prop = iInheritProps.getString(i);
            props.add(prop);
        }

        instance.setInheritProps(props);
        instance.setMountPoint(obj.getString("mountpoint"));
        instance.setName(obj.getString("name"));
        instance.setPool(obj.getString("pool"));
        instance.setQuota(obj.getLong("quota"));
        instance.setReadOnly(obj.getString("readonly"));
        instance.setRecordSize(obj.getLong("recordsize"));
        instance.setRefer(obj.getLong("refer"));
        instance.setRefQuota(obj.getLong("refquota"));
        instance.setRefReservation(obj.getLong("refreservation"));
        instance.setReservation(obj.getLong("reservation"));
        instance.setUsed(obj.getLong("used"));

        return instance;
    }


}

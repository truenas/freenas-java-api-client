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
package com.ixsystems.vcp.entities.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ixsystems.vcp.entities.Volume;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class VolumeSerializer extends StdSerializer<Volume> implements EntitySerializer<Volume>  {

    public VolumeSerializer(Class<Volume> t) {
        super(t);
    }

    public VolumeSerializer(JavaType type) {
        super(type);
    }

    public VolumeSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    public VolumeSerializer(StdSerializer<?> src) {
        super(src);
    }

    public Volume decode(JSONObject obj, Volume instance) {

        instance.setStatus(obj.getString("status"));
        instance.setVolGuid(obj.getString("vol_guid"));
        instance.setUsed(obj.getString("used"));
        instance.setUsed_pct(obj.getString("used_pct"));
        instance.setUsed_si(obj.getString("used_si"));
        instance.setId(obj.getString("id"));
        instance.setVolEncrypted(obj.getString("vol_encryptkey"));
        instance.setVolName(obj.getString("vol_name"));
        instance.setIsDecrypted(obj.getString("is_decrypted"));
        instance.setAvailableSi(obj.getString("avail_si"));
        instance.setMountPoint(obj.getString("mountpoint"));
        instance.setVolEncrypted(obj.getString("vol_encrypt"));
        //instance.setChildren(new ArrayList<String>());
        instance.setTotalSi(obj.getString("total_si"));
        return instance;
    }

    public void serialize(Volume volume,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

    }
}

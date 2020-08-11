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
package com.ixsystems.truenas;

import com.ixsystems.vcp.entities.Dataset;
import com.ixsystems.vcp.entities.Volume;
import com.ixsystems.vcp.entities.exceptions.DatasetAlreadyExists;
import org.freenas.client.utils.SSLManager;
import org.freenas.client.v2.connectors.rest.imp.AuthenticationConnector;
import org.freenas.client.v2.connectors.rest.imp.EndpointConnector;
import org.freenas.client.v2.storage.rest.impl.DatasetRestConnector;
import org.junit.jupiter.api.Test;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/*import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;*/

public class TestDataset {

    public DatasetRestConnector getConnector() {
        DatasetRestConnector gs = AuxiliarAuth.getConnector();
        return gs;
    }

    @Test
    public void testCreate() throws KeyManagementException, NoSuchAlgorithmException, DatasetAlreadyExists {
        SSLManager.checkSSL();
        DatasetRestConnector gs = getConnector();
        Map<String, String> args = new HashMap<String, String>();

        args.put("name", "datasetNameTest"+ UUID.randomUUID().toString());

        String volumeName = "ds";

        Dataset ds  = gs.create(volumeName, args);
        //assertNotNull("Dataset is not returned", ds);
        assertNotNull(ds, "Dataset is not returned");

        //List<Dataset> volumeList = gs.list();
    }

    @Test
    public void testMassCreate() {
        DatasetRestConnector gs = getConnector();
        String volumeName = "ds";

        Map<String, String> args = new HashMap<String, String>();

        for (int i = 0; i<10; i++) {
            args.put("name", "datasetNameTest"+i);
            try {
                Dataset ds = gs.create(volumeName, args);
            }catch (DatasetAlreadyExists e){
                System.out.println("Dataset already exists.." + volumeName + args);
            }
            //assertNotNull("Dataset is not returned", ds);
        }
    }

    @Test
    public void testList() {
        DatasetRestConnector gs = getConnector();

        //List<Volume> volumeList = gs.list(0L);
        List<Volume> volumeList = gs.list();
        //Map<String, String> vol = new HashMap<String, String>();
        Map<String, Long> vol = new HashMap<String, Long>();
        for (Volume v : volumeList){
            System.out.println("Volume " + v);
            //vol.put(v.getName(), v.getUsed().toLowerCase());
            vol.put(v.getName(), Long.valueOf(v.getUsed()));
        }
        System.out.println(vol);
        System.out.println(vol.size());
    }
}

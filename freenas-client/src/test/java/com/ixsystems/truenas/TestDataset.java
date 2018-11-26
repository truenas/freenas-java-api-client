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
package com.ixsystems.truenas;

import com.ixsystems.vcp.entities.Dataset;
import com.ixsystems.vcp.entities.Volume;
import org.freenas.client.connectors.rest.imp.AuthenticationConnector;
import org.freenas.client.connectors.rest.imp.EndpointConnector;
import org.freenas.client.storage.rest.impl.DatasetRestConnector;
import org.freenas.client.storage.rest.impl.VolumeRestConnector;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
public class TestDataset {

    public DatasetRestConnector getConnector(){
        AuthenticationConnector auth = AuxiliarAuth.getAuth();
        EndpointConnector ep = new EndpointConnector("http://10.20.21.194", "http");
        DatasetRestConnector gs = new DatasetRestConnector(ep, auth);

        return gs;
    }

    @Test
    public void testCreate() {
        DatasetRestConnector gs = getConnector();
        Map<String, String> args = new HashMap<String, String>();

        args.put("name", "datasetNameTest"+ UUID.randomUUID().toString());

        String volumeName = "zz";


        Dataset ds  = gs.create(volumeName, args);
        assertNotNull("Dataset is not returned", ds);

        //List<Dataset> volumeList = gs.list();

    }

    @Test
    public void testMassCreate() {
        DatasetRestConnector gs = getConnector();
        String volumeName = "zd";

        Map<String, String> args = new HashMap<String, String>();


        for (int i = 0; i<10; i++) {
            args.put("name", "datasetNameTest"+i);
            Dataset ds  = gs.create(volumeName, args);
            //assertNotNull("Dataset is not returned", ds);
        }


    }


    @Test
    public void testList() {
        DatasetRestConnector gs = getConnector();

        List<Volume> volumeList = gs.list(0L);
        for (Volume v : volumeList){
            System.out.println("Volume " + v);
        }

    }



}




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
package org.freenas.client.websockets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSAuthenticationMessages {

    public static final String MSG_CONNECTED = "connected";
    public static final String MSG_RESULT = "result";



    public static String getConnectMsg(){
        Map<String, Object> args = new HashMap<String, Object>();

        args.put("msg", "connect");
        args.put("version", "1");
        List<String> arr = new ArrayList<String>();
        arr.add("1");
        args.put("support", arr);
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JSONObject obj = new JSONObject(args);
        return obj.toString();
    }

    public static String decodeSessionId(String message){
        JSONObject jsonObject = new JSONObject(message);
        String id = jsonObject.getString("session");
        return id;
    }
    public static String decodeMessage(String message){
        JSONObject jsonObject = new JSONObject(message);
        String msg = jsonObject.getString("msg");
        return msg;
    }

    public static String decodeId(String message){
        JSONObject jsonObject = new JSONObject(message);
        String id = jsonObject.getString("id");
        return id;
    }

    public static String getAuth(String id, String username, String password){
        Map<String, Object> args = new HashMap<String, Object>();

        args.put("id", id);
        args.put("msg", "method");
        args.put("method", "auth.login");
        List<String> arr = new ArrayList<String>();
        arr.add(username);
        arr.add(password);
        args.put("params", arr);
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JSONObject obj = new JSONObject(args);
        return obj.toString();
    }




}

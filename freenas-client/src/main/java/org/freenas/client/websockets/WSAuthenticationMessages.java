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

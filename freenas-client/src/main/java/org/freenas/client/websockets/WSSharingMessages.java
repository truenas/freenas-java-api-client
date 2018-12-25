package org.freenas.client.websockets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSSharingMessages {

    public static final String METHOD_SHARING_NFS_QUERY = "sharing.nfs.query";

    public static String getNFSSharingQuery(String id){
        Map<String, Object> args = new HashMap<String, Object>();

        Map<String, Object> params = new HashMap<String, Object>();

        args.put("id", id);
        args.put("msg", "method");
        args.put("method", METHOD_SHARING_NFS_QUERY);

        List<List> filtersLst = new ArrayList<List>();
        List<List> filtersLst2 = new ArrayList<List>();
        filtersLst.add(filtersLst2);

        params.put("query-filters", filtersLst);
        //args.put("query-filters", filtersLst);
        //args.put("params", params);
        JSONObject obj = new JSONObject(args);
        return obj.toString();
    }
}

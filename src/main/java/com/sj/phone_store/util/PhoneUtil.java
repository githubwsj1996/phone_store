package com.sj.phone_store.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneUtil {

    public static List<Map<String,String>> createTag(String tag){
        String[] str=tag.split("&");
        Map<String,String> map=null;
        List<Map<String,String>> list=new ArrayList<>();
        for (String s : str) {
            map=new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return  list;
    }
}

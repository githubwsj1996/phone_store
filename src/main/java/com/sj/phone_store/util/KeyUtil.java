package com.sj.phone_store.util;

import java.util.Random;

public class KeyUtil {
    public static synchronized  String  createId()
    {
        Random random=new Random();
        Integer id=random.nextInt(900000)+100000;
        return  System.currentTimeMillis()+String.valueOf(id);
    }
}

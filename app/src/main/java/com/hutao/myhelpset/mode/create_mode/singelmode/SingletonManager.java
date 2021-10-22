package com.hutao.myhelpset.mode.create_mode.singelmode;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例管理类
 * @author: hutao
 * @date: 2021/10/19
 */
public class SingletonManager {
    private static Map<String,Object> objectMap = new HashMap<>();

    public static void registerService(String key,Object instance){
        if (!objectMap.containsKey(key)){
            objectMap.put(key,instance); //添加单例
        }
    }
    public static Object getService(String key){
        return objectMap.get(key);  //获取单例
    }
}
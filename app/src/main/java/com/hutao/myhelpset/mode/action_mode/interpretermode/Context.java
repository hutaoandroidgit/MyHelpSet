package com.hutao.myhelpset.mode.action_mode.interpretermode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Context {
    public Map<String,Object> map = new HashMap<>();//使用HashMap来保存结果

    public void put(String key,Object obj){
        map.put(key,obj);
    }

    public int get(String key){
        return (int)map.get(key);
    }
}
package com.hutao.myhelpset.mode.structure_mode.flyweightmode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class BikeFactory {
    private Map<String,IBike> pool  = new HashMap<>();//使用HashMap来保存IBike对象
    public IBike getBike(String name){
        IBike iBike = null;
        if (pool .containsKey(name)){//如果存在对象的话，直接使用
            System.out.println("押金已交，直接用车：" + name);
            iBike = pool.get(name);
        }else{//对象不存在的话，先创建对象
            iBike = new ShareBike();
            pool.put(name,iBike);
            System.out.println(name + "交100押金，可以用车了。");
        }
        return iBike;
    }
}
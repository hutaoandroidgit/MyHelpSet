package com.hutao.myhelpset.mode.create_mode.easyfactorymode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class EasyFactory2 {

    public static <T extends Product> T create(Class<T> cls){
        Product product = null;
        try {
            product = (Product)Class.forName(cls.getName()).newInstance();//反射出实例
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T) product;
    }
}
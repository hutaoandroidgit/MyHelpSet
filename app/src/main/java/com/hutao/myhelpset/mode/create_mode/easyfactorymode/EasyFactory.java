package com.hutao.myhelpset.mode.create_mode.easyfactorymode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class EasyFactory {
    public static Product create(String name){
        Product product = null;
        //通过switch语句控制生产哪种商品
        switch(name){
            case "A":
                product =  new ProductA();
                break;
            case "B":
                product =  new ProductB();
                break;
            default:
                break;
        }
        return product;
    }
}
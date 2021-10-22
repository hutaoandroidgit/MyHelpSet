package com.hutao.myhelpset.mode.action_mode.templatemode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public abstract class PostmanTemplate {//抽象快递员类
    //派送流程
    public final void psot(){//这里申明为final，不希望子类覆盖这个方法，防止更改流程的执行顺序
        prepare();//准备派送
        call();//联系收货人
        if (isSign()){
            sign();
        }else{
            refuse();
        }
    }
    protected void refuse(){//拒签，空实现，这个也是钩子方法，子类可以跟进实际来决定是否去实现这个方法

    }
    protected void sign(){//签收，这个是固定流程，父类实现
        System.out.println("客户已签收，上报系统");
    }
    protected boolean isSign(){//是否签收,这个是钩子方法，用来控制流程的走向
        return true;
    }
    protected abstract void call();//联系收货人，联系人不一样，所以为抽象方法，子类实现

    protected void prepare(){//准备操作，固定流程，父类实现
        System.out.println("快递已达到，准备派送");
    }
}
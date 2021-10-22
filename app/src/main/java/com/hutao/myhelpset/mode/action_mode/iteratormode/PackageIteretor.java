package com.hutao.myhelpset.mode.action_mode.iteratormode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class PackageIteretor implements Iterator{
    private Aggragate aggragate;//容器对象
    private int index;//当前索引

    public PackageIteretor(Aggragate aggragate) {
        this.aggragate = aggragate;//初始化容器对象
    }

    @Override
    public boolean hasNext() {//是否存在下一条记录
        if (index < aggragate.size()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object next() {//返回当前记录并移到下一条记录
        return aggragate.get(index++);
    }
}
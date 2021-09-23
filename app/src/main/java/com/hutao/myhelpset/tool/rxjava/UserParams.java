package com.hutao.myhelpset.tool.rxjava;

import com.hutao.helplibrary.basebean.BaseBean;

/**
 * @author: hutao
 * @date: 2021/9/23
 */
public class UserParams extends BaseBean {

    private String userName;
    private String userPsd;

    public UserParams(String userName, String userPsd) {
        this.userName = userName;
        this.userPsd = userPsd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }
}
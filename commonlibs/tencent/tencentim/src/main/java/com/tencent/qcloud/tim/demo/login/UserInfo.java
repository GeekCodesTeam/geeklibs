package com.tencent.qcloud.tim.demo.login;

import android.content.SharedPreferences;

import com.geek.libutils.app.BaseApp;
import com.google.gson.Gson;

import com.tencent.qcloud.tim.demo.utils.Constants;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private final static String PER_USER_MODEL = "per_user_model";

    private static UserInfo sUserInfo;

    private String zone;
    private String phone;
    private String token;
    private String userId;
    private String userSig;
    private String name;
    private String avatar;
    private boolean autoLogin;

    public synchronized static UserInfo getInstance() {
        if (sUserInfo == null) {
            SharedPreferences shareInfo = BaseApp.get().getSharedPreferences(Constants.USERINFO, 0);
            String json = shareInfo.getString(PER_USER_MODEL, "");
            sUserInfo = new Gson().fromJson(json, UserInfo.class);
            if (sUserInfo == null) {
                sUserInfo = new UserInfo();
            }
        }
        return sUserInfo;
    }

    private UserInfo() {

    }

    public void setUserInfo(UserInfo info) {
        SharedPreferences shareInfo = BaseApp.get().getSharedPreferences(Constants.USERINFO, 0);
        SharedPreferences.Editor editor = shareInfo.edit();
        editor.putString(PER_USER_MODEL, new Gson().toJson(info));
        editor.commit();
    }

    public String getUserSig() {
        return this.userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
        setUserInfo(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        setUserInfo(this);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        setUserInfo(this);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
        setUserInfo(this);
    }

    public String getZone() {
        return this.zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
        setUserInfo(this);
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String userPhone) {
        this.phone = userPhone;
        setUserInfo(this);
    }

    public Boolean isAutoLogin() {
        return this.autoLogin;
    }

    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
        setUserInfo(this);
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String url) {
        this.avatar = url;
        setUserInfo(this);
    }

}

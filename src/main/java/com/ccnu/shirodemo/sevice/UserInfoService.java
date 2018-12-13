package com.ccnu.shirodemo.sevice;


import com.ccnu.shirodemo.entity.UserInfo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
    public UserInfo save(UserInfo user);
}
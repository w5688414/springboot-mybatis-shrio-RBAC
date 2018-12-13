package com.ccnu.shirodemo.mapper;

import com.ccnu.shirodemo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public UserInfo findByUsername(String username);
	public UserInfo save(UserInfo user);
}
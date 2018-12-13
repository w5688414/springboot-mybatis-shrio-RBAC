package com.ccnu.shirodemo.controller;

import com.ccnu.shirodemo.config.ShiroUtils;
import com.ccnu.shirodemo.entity.UserInfo;
import com.ccnu.shirodemo.mapper.UserMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserMapper userMapper;

    private ShiroUtils shiroUtils=new ShiroUtils();



    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * http://127.0.0.1:8080/userInfo/userAdd
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }

    /**
     * 添加用户信息示例
     */
    @RequestMapping("saveUser")
    @ResponseBody
    public void saveUser(){
        UserInfo user=new UserInfo();
        String salt = ShiroUtils.generateSalt(20);
        user.setPassword("1234");
        user.setName("管理员");
        user.setUsername("wu");
        user.setSalt(salt);
        user.setState((byte) 0);
        shiroUtils.encryptPassword(user);
//        userInfoDao.save(user);


    }
}
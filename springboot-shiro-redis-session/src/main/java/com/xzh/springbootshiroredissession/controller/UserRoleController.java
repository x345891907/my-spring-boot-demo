package com.xzh.springbootshiroredissession.controller;

import com.xzh.springbootshiroredissession.common.util.ShiroUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 角色测试
 *
 */
@RestController
@RequestMapping("role")
public class UserRoleController {

    /**
     * 管理员角色测试接口
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getAdminInfo")
    @RequiresRoles("ADMIN")
    public Map<String,Object> getAdminInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有管理员角色能访问的接口");
        return map;
    }

    /**
     * 用户角色测试接口
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getUserInfo")
    @RequiresRoles("USER")
    public Map<String,Object> getUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有用户角色能访问的接口");
        return map;
    }

    /**
     * 角色测试接口
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getRoleInfo")
    @RequiresRoles(value={"ADMIN","USER"},logical = Logical.OR)
    @RequiresUser
    public Map<String,Object> getRoleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只要有ADMIN或者USER角色能访问的接口");
        return map;
    }

    /**
     * 登出(测试登出)
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getLogout")
    @RequiresUser
    public Map<String,Object> getLogout(){
        ShiroUtils.logout();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登出");
        return map;
    }
}

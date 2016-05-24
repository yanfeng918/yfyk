package com.yanfeng.controller;

import com.yanfeng.dao.UserMapper;
import com.yanfeng.entity.StudentExample;
import com.yanfeng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yanfeng on 2016/5/19.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    
    @Autowired(required = true)
//    @Qualifier("userMapper")
//    @Resource
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        User load = userMapper.load(1);
        System.out.print(load.toString());
        return "yanfeng";
    }


    
}

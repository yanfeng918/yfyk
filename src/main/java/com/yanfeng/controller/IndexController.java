package com.yanfeng.controller;

import com.yanfeng.dao.mbg.HouseInfoCrawlMapper;
import com.yanfeng.entity.HouseInfoCrawl;
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
    private HouseInfoCrawlMapper houseInfoCrawlMapper;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        HouseInfoCrawl house = new HouseInfoCrawl();

        house.setAddress("123");
        houseInfoCrawlMapper.insertSelective(house);
        return "yanfeng";
    }


    
}

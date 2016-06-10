package com.yanfeng;


import com.yanfeng.crawl.DagongpanPageProcessor;
import com.yanfeng.dao.extend.AreaExtendMapper;
import com.yanfeng.dao.extend.HouseInfoCrawlExtendMapper;
import com.yanfeng.dao.extend.HouseInfoValidExtendMapper;
import com.yanfeng.dao.mbg.HouseInfoCrawlMapper;
import com.yanfeng.dao.mbg.HouseInfoValidMapper;
import com.yanfeng.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng on 2016/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class HouseInfoCrawlTest {


    @Resource
    private DagongpanPageProcessor dagongpanPageProcessor;

    @Autowired
    private HouseInfoCrawlExtendMapper houseInfoCrawlMapper;

    @Autowired
    private HouseInfoValidExtendMapper houseInfoValidMapper;

    @Autowired
    private AreaExtendMapper areaExtendMapper;

    @Test
    public void crawlData()  {

        int totalPager=1;
        List<HouseInfoCrawl> list = null;

        String baseUrl="http://dagongpan.cn/yjbadmin/auth/houseInfo/list?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=";
        for (int i=1;i<=totalPager;i++){
            list = dagongpanPageProcessor.begin(baseUrl+i);
            //过滤数据 已存在的数据
            List<HouseInfoCrawl> filterList = filter(list);
            //处理数据的区域名称到区域id
            List<HouseInfoCrawl> newHouseList = changeToAreaId(filterList);

            //保存数据
            if (newHouseList!=null&&newHouseList.size()!=0){
                //保存有效数据到有效房源
                houseInfoValidMapper.batchInsert(filterValid(newHouseList));
                //保存其它类型的房源到爬虫数据
                houseInfoCrawlMapper.batchInsert(filterInValid(newHouseList));
            }
            dagongpanPageProcessor.clearList();
        }
        System.out.print(list.size());

    }



    public List<HouseInfoCrawl> filter(List<HouseInfoCrawl> list){
        List<HouseInfoCrawl> newList = new ArrayList<>();
        //过滤待审核的数据 过滤已经存在的数据

        for(HouseInfoCrawl house :list){
            if ("待审核".equals(house.getStatus())){
                continue;
            }
            if (!isExitHouse(house.getOid())){
                newList.add(house);
            }
        }
        return newList;
    }

    public List<HouseInfoCrawl> filterValid(List<HouseInfoCrawl> list){
        List<HouseInfoCrawl> newList = new ArrayList<>();
        //过滤得到审核成功数据
        for(HouseInfoCrawl house :list){

            if ("成功".equals(house.getStatus())){
                newList.add(house);
            }
        }
        return newList;
    }

    public List<HouseInfoCrawl> filterInValid(List<HouseInfoCrawl> list){
        List<HouseInfoCrawl> newList = new ArrayList<>();
        //过滤得到审核成功数据
        for(HouseInfoCrawl house :list){
            if ("成功".equals(house.getStatus())){
                continue;
            }
            newList.add(house);
        }
        return newList;
    }

    /**
     * 判断房子是否存在数据库中
     * @param id
     * @return
     */
    public boolean isExitHouse(int id){
        if (id==0)
            return false;
        HouseInfoCrawlExample example = new HouseInfoCrawlExample();
        example.or().andOidEqualTo(id);
        List<HouseInfoCrawl> houseInfoCrawls = houseInfoCrawlMapper.selectByExample(example);
        if (houseInfoCrawls!=null&&houseInfoCrawls.size()!=0)
            return true;
        return false;
    }

    public List<HouseInfoCrawl> changeToAreaId(List<HouseInfoCrawl> list){
        for(HouseInfoCrawl house :list){
            String areaname = house.getAreaname();
            //获取前2个字符串
            String city = areaname.substring(0,2);
            String district = areaname.substring(2,4);
            String left = areaname.substring(4);
            if(district.equals("浦东")){
                String newArea = "上海市浦东新区"+left;
                house.setAreaname(newArea);
            }else{
                String newArea = city+"市"+district+"区"+left;
                house.setAreaname(newArea);
            }
            //根据区域名称查询区域对应的id

            List<Area> areas = areaExtendMapper.getByFullName(house.getAreaname());
            if (areas!=null&&areas.size()>0){
                house.setAreaId(areas.get(0).getId().intValue());
            }

        }
        return list;
    }

    @Test
    public void test1()  {
        System.out.print(isExitHouse(1250106));
    }


}

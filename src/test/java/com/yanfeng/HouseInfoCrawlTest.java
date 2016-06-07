package com.yanfeng;


import com.yanfeng.crawl.DagongpanPageProcessor;
import com.yanfeng.dao.extend.HouseInfoCrawlExtendMapper;
import com.yanfeng.dao.mbg.HouseInfoCrawlMapper;
import com.yanfeng.entity.HouseInfoCrawl;
import com.yanfeng.entity.HouseInfoCrawlExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    public void crawlData()  {

        int totalPager=2;
        List<HouseInfoCrawl> list = null;

        String baseUrl="http://dagongpan.cn/yjbadmin/auth/houseInfo/list?&areaId=792&areaId_select=792&pageSize=100&orderBy=createDate&orderType=desc&pageNumber=";
        for (int i=1;i<=totalPager;i++){
            list = dagongpanPageProcessor.begin(baseUrl+i);
            //过滤数据
            List<HouseInfoCrawl> filterList = filter(list);
            //保存数据
            if (filterList!=null&&filterList.size()!=0)
                houseInfoCrawlMapper.batchInsert(filterList);
            dagongpanPageProcessor.clearList();
        }
        System.out.print(list.size());

    }

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

    public List<HouseInfoCrawl> filter(List<HouseInfoCrawl> list){
        List<HouseInfoCrawl> newList = new ArrayList<>();
        for(HouseInfoCrawl house :list){
            if (!isExitHouse(house.getOid())){
                newList.add(house);
            }
        }
        return newList;
    }

    @Test
    public void test1()  {
        System.out.print(isExitHouse(1250106));
    }


}

package com.yanfeng.dao.extend;

import com.yanfeng.dao.mbg.HouseInfoCrawlMapper;
import com.yanfeng.entity.HouseInfoCrawl;
import com.yanfeng.entity.HouseInfoCrawlExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseInfoCrawlExtendMapper extends HouseInfoCrawlMapper{

   void batchInsert(List<HouseInfoCrawl> list);

}
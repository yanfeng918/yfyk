package com.yanfeng.dao.extend;


import com.yanfeng.dao.mbg.HouseInfoNewMapper;
import com.yanfeng.dao.mbg.HouseInfoValidMapper;
import com.yanfeng.entity.HouseInfoCrawl;

import java.util.List;

public interface HouseInfoValidExtendMapper extends HouseInfoValidMapper{
    void batchInsert(List<HouseInfoCrawl> list);
}
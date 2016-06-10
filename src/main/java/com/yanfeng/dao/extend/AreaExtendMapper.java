package com.yanfeng.dao.extend;

import com.yanfeng.dao.mbg.AreaMapper;
import com.yanfeng.dao.mbg.HouseInfoCrawlMapper;
import com.yanfeng.entity.Area;
import com.yanfeng.entity.HouseInfoCrawl;

import java.util.List;

public interface AreaExtendMapper extends AreaMapper {

      List<Area> getByFullName(String fullName);
}
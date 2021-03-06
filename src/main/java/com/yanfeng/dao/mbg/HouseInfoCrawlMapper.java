package com.yanfeng.dao.mbg;

import com.yanfeng.entity.HouseInfoCrawl;
import com.yanfeng.entity.HouseInfoCrawlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseInfoCrawlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int countByExample(HouseInfoCrawlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int deleteByExample(HouseInfoCrawlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int insert(HouseInfoCrawl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int insertSelective(HouseInfoCrawl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    List<HouseInfoCrawl> selectByExample(HouseInfoCrawlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    HouseInfoCrawl selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") HouseInfoCrawl record, @Param("example") HouseInfoCrawlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") HouseInfoCrawl record, @Param("example") HouseInfoCrawlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HouseInfoCrawl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_crawl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HouseInfoCrawl record);
}
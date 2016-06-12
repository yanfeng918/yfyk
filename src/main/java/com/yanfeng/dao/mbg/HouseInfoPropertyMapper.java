package com.yanfeng.dao.mbg;

import com.yanfeng.entity.HouseInfoProperty;
import com.yanfeng.entity.HouseInfoPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseInfoPropertyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int countByExample(HouseInfoPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int deleteByExample(HouseInfoPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int insert(HouseInfoProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int insertSelective(HouseInfoProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    List<HouseInfoProperty> selectByExample(HouseInfoPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    HouseInfoProperty selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") HouseInfoProperty record, @Param("example") HouseInfoPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") HouseInfoProperty record, @Param("example") HouseInfoPropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HouseInfoProperty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_property
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HouseInfoProperty record);
}
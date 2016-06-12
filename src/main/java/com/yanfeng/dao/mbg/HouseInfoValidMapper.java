package com.yanfeng.dao.mbg;

import com.yanfeng.entity.HouseInfoValid;
import com.yanfeng.entity.HouseInfoValidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseInfoValidMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int countByExample(HouseInfoValidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int deleteByExample(HouseInfoValidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int insert(HouseInfoValid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int insertSelective(HouseInfoValid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    List<HouseInfoValid> selectByExample(HouseInfoValidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    HouseInfoValid selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") HouseInfoValid record, @Param("example") HouseInfoValidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") HouseInfoValid record, @Param("example") HouseInfoValidExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HouseInfoValid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_house_info_valid
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HouseInfoValid record);
}
/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月11日
 * 修改历史 : 
 *     1. [2017年4月11日]创建文件 by gehanbiao
 */
package com.personalitytest.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.personalitytest.entity.HR_CandiDateBO;

/**
 * 消息接口
 * @author gehanbiao
 * @version 2017年4月11日
 */
public interface IMessageDAO {
    /**
     * @description： 根据当前主管查询应试者信息
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月11日下午2:40:46
     */
    @Select(" SELECT "
            + " T.CANDIDATE_ID AS candidateId,"
            + " T.NAME AS name,"
            + " T.GENDER AS gender,"
            + " T.DAY_OF_BIRTH AS dayOfBirth,"
            + " T.POSITION_ID AS positionId,"
            + " T.MOBILE AS mobile,"
            + " T.PHONE AS phone,"
            + " T.EMAIL AS email,"
            + " T.EDUCATION AS education,"
            + " T.COLLAGE AS collage,"
            + " T.SCHOOL AS school,"
            + " T.MAJOR AS major,"
            + " T.GRADUATION AS graduation,"
            + " T.QQ AS qq,"
            + " T.SOURCE_ID AS sourceId,"
            + " T.STATE_ID AS stateId,"
            + " T.USER_ID AS userId,"
            + " T.CITY_ID AS cityId "
          + " FROM HR_CANDIDATE T WHERE  T.USER_ID = #{userId }")
    List<HR_CandiDateBO> findUserIdMessage(@Param("userId")String userId);
    /**
     * @description： 根据条件查找应试者信息
     * @param candiDateBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月12日上午8:42:30
     */
    List<HR_CandiDateBO> findCandiDateMessage(HR_CandiDateBO candiDateBO);
    /**
     * @description： 添加应试者信息
     * @param candiDateBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月12日下午1:45:14
     */
    int insertCandiDateMessage(HR_CandiDateBO candiDateBO);
}

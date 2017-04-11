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
    @Select("SELECT T.NAME as NAME,T.GENDER as GENDER FROM HR_CANDIDATE T, (SELECT user_id FROM HR_user WHERE USER_NAME = #{userName } ) T2  where  T.user_id = T2.user_id")
    List<HR_CandiDateBO> findCandiDateMessage(@Param("userName")String userName);
    
}

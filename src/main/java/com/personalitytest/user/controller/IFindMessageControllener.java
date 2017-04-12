/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller;

import java.util.List;

import com.personalitytest.entity.HR_CandiDateBO;
import com.personalitytest.utils.JsonResult;

/**
 * 信息接口
 * @author gehanbiao
 * @version 2017年4月10日
 */
public interface IFindMessageControllener {
    
    /**
     * @description： 根据当前主管查询应试者信息
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月10日下午1:58:34
     */
    JsonResult<List<HR_CandiDateBO>> findUserIdMessage(String userId);
    
    /**
     * @description：  根据条件查找应试者信息
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月12日上午9:58:59
     */
    JsonResult<List<HR_CandiDateBO>> findCandiDateMessage(String userId,String name,String mobile,String stateId);
    
    JsonResult<Boolean> insertCandiDateMessage(List<HR_CandiDateBO> candiDateList);
    /**
     * String name, String gender, String dayOfBirth, String positionId, String mobile, String phone,
                   String email, String education, String collage, String school, String major, String graduation, String qq, String sourceId,
                   String stateId, String userId, String cityId
     */
}

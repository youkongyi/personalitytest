/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller;

import java.util.List;
import java.util.Map;

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
    JsonResult<List<HR_CandiDateBO>> findCandiDateMessage(Map<String,Object> name);
    
    /**
     * @description： 添加应试者信息
     * @param params
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日上午9:00:18
     */
    JsonResult<Boolean> insertCandiDateMessage(HR_CandiDateBO candiDateList);
}

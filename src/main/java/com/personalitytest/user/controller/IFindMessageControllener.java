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
 * 消息接口
 * @author gehanbiao
 * @version 2017年4月10日
 */
public interface IFindMessageControllener {
    
    /**
     * @description： 添加方法功能描述
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月10日下午1:58:34
     */
    JsonResult<List<HR_CandiDateBO>> findCandiDateMessage(String userName);

}

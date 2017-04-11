/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller.impl;

import java.util.List;

import com.personalitytest.entity.HR_CandiDateBO;
import com.personalitytest.user.controller.IFindMessageControllener;
import com.personalitytest.utils.JsonResult;

/**
 * 消息接口
 * @author gehanbiao
 * @version 2017年4月10日
 */
public class FindMessageControllenerImpl implements IFindMessageControllener {

    /**
     * @description： 候选人信息查询
     * @see com.personalitytest.user.controller.IFindMessageControllener#findCandiDateMessage(java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月10日下午1:57:12
     */
    @Override
    public JsonResult<List<HR_CandiDateBO>> findCandiDateMessage(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

}

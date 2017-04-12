/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月11日
 * 修改历史 : 
 *     1. [2017年4月11日]创建文件 by gehanbiao
 */
package com.personalitytest.user.service;

import java.util.List;

import com.personalitytest.entity.HR_CandiDateBO;

/**
 * 应试者信息Service
 * @author gehanbiao
 * @version 2017年4月11日
 */
public interface ICandiDateService {
    /**
     * @description： 根据当前主管查询应试者信息
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月11日上午11:46:58
     */
    List<HR_CandiDateBO> findUserIdMessage(String userId);
    /**
     * @description： 根据条件查找应试者信息
     * @param candiDateBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月12日上午10:40:45
     */
    List<HR_CandiDateBO> findCandiDateMessage(HR_CandiDateBO candiDateBO);
    /**
     * @description： 添加应试者信息
     * @param candiDateBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月12日下午2:30:05
     */
    boolean insertCandiDateMessage(HR_CandiDateBO candiDateBO);
}

/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月11日
 * 修改历史 : 
 *     1. [2017年4月11日]创建文件 by gehanbiao
 */
package com.personalitytest.user.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personalitytest.entity.HR_CandiDateBO;
import com.personalitytest.user.dao.IMessageDAO;
import com.personalitytest.user.service.ICandiDateService;

/**
 * 信息类
 * @author gehanbiao
 * @version 2017年4月11日
 */
@Service("candiDateService")
public class CandiDateServiceImpl implements ICandiDateService {
    @Autowired
    private IMessageDAO messageDAO;
    /**
     * @description：根据当前主管查询应试者信息
     * @see com.personalitytest.user.service.ICandiDateService#findCandiDateMessage(java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月11日上午11:50:04
     */
    @Override
    @Transactional
    public List<HR_CandiDateBO> findCandiDateMessage(String userName) {
        return messageDAO.findCandiDateMessage(userName);
    }

}

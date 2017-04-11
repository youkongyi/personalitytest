/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.dao;

import java.util.List;

import com.personalitytest.entity.HR_DistrictBO;
import com.personalitytest.entity.HR_UserBO;

/**
 * 用户操作接口
 * @author gehanbiao
 * @version 2017年4月5日
 */
public interface IUserDAO {
    /**
     * 
     * @description： 根据账号查找用户信息
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月5日上午10:43:35
     */
    HR_UserBO findUserByName(String userName);
    
    
    List<HR_DistrictBO> selectAll();
}

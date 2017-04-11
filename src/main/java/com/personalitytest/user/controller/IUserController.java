/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller;

import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.utils.JsonResult;

/**
 * 用户操作接口
 * @author gehanbiao
 * @version 2017年4月5日
 */
public interface IUserController {
    
    JsonResult<HR_UserBO> userLogin(String userName, String password);
    
    
    
}

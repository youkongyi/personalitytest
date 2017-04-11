/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.user.controller.IUserController;
import com.personalitytest.user.service.IUserService;
import com.personalitytest.utils.JsonResult;
import com.personalitytest.utils.StateInforMation;
import com.personalitytest.utils.StringUtils;

/**
 * 接收用户操作
 * @author gehanbiao
 * @version 2017年4月5日
 */
@Controller
@RequestMapping("/user")
public class UserControllerImpl implements IUserController {
  
    @Resource
    private IUserService userService;

    /**
     * @description： 用户登录
     * @see com.erp.user.controller.IUserWeb#userLogin(java.lang.String, java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月5日上午10:03:39
     */
    @Override
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult<HR_UserBO> userLogin(String userName, String password) {
        JsonResult<HR_UserBO> jsonResult = new JsonResult<HR_UserBO>();
        if(StringUtils.isNull(userName) || StringUtils.isNull(password)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try {
            jsonResult = userService.userLogin(userName, password);
        } catch(Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
        }
        return jsonResult;
    }

}

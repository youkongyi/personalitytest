/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller.impl;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.user.controller.IUserController;
import com.personalitytest.user.service.IUserService;
import com.personalitytest.utils.JsonResult;
import com.personalitytest.utils.StateInforMation;
import com.personalitytest.utils.StringUtils;

/**
 * 接受HR管理员操作
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
    @RequestMapping("/userLogin.do")
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

    /**
     * @description：添加HR管理员
     * @see com.personalitytest.user.controller.IUserController#inertUser(java.util.Map)
     * @author：gehanbiao
     * @crateDate：2017年4月13日上午10:25:43
     */
    @Override
    @RequestMapping("/insertUser.do")
    @ResponseBody
    public JsonResult<Boolean> insertUser(@RequestParam Map<String, Object> paramMap) {
        JsonResult<Boolean> jsonResult = new JsonResult<Boolean>();
        String userId = String.valueOf(paramMap.get("userId"));
        String userSureName = String.valueOf(paramMap.get("userSureName"));
        String userMobile = String.valueOf(paramMap.get("userMobile"));
        String roleId = String.valueOf(paramMap.get("roleId"));
        if(StringUtils.isNull(userId)||StringUtils.isNull(userSureName)||StringUtils.isNull(userMobile)||StringUtils.isNull(roleId)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try {
            HR_UserBO userBO = new HR_UserBO();
            BeanUtils.copyProperties(userBO, paramMap);
            boolean flag = userService.insertUser(userBO);
            jsonResult.setData(flag);
            jsonResult.setState(StateInforMation.STATUS_SUCCESS);
            jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
        } catch(Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return jsonResult;
    }

    /**
     * @description：  查找当前HR管理员下所有HR管理员
     * @see com.personalitytest.user.controller.IUserController#findRoleId(java.util.Map)
     * @author：gehanbiao
     * @crateDate：2017年4月13日下午4:22:20
     */
    @Override
    @RequestMapping("/findHRUser.do")
    @ResponseBody
    public JsonResult<List<HR_UserBO>> findHRUser(@RequestParam Map<String, Object> paramMap) {
        JsonResult<List<HR_UserBO>> jsonResult = new JsonResult<List<HR_UserBO>>();
        String userId = String.valueOf(paramMap.get("userId"));
        if(StringUtils.isNull(userId)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try {
            List<HR_UserBO> userList = userService.findHRUser(userId);
            jsonResult.setData(userList);
            jsonResult.setState(StateInforMation.STATUS_SUCCESS);
            jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
        } catch(Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return jsonResult;
    }

    /**
     * @description： 更新当前HR管理员信息
     * @see com.personalitytest.user.controller.IUserController#updateUser(java.util.Map)
     * @author：gehanbiao
     * @crateDate：2017年4月14日上午9:11:52
     */
    @Override
    public JsonResult<Boolean> updateUser(Map<String, Object> paramMap) {
        JsonResult<Boolean> jsonResult = new JsonResult<Boolean>();
        String userId = String.valueOf(paramMap.get("userId"));
        if(StringUtils.isNull(userId)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try {
            HR_UserBO userBO = new HR_UserBO();
            BeanUtils.copyProperties(userBO, paramMap);
            boolean flag = userService.insertUser(userBO);
            jsonResult.setData(flag);
            jsonResult.setState(StateInforMation.STATUS_SUCCESS);
            jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
        } catch(Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return jsonResult;
    }

    
    
}

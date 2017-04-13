/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.personalitytest.entity.HR_CandiDateBO;
import com.personalitytest.user.controller.IFindMessageControllener;
import com.personalitytest.user.service.ICandiDateService;
import com.personalitytest.utils.JsonResult;
import com.personalitytest.utils.StateInforMation;
import com.personalitytest.utils.StringUtils;

/**
 * 信息接口
 * @author gehanbiao
 * @version 2017年4月10日
 */
@Controller
@RequestMapping("/message")
public class FindMessageControllenerImpl implements IFindMessageControllener {
     @Resource
     private ICandiDateService candiDateService;
    /**
     * @description： 根据当前主管查询应试者信息
     * @see com.personalitytest.user.controller.IFindMessageControllener#findCandiDateMessage(java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月10日下午1:57:12
     */
    @Override
    @RequestMapping("/findUserIdMessage.do")
    @ResponseBody
    public JsonResult<List<HR_CandiDateBO>> findUserIdMessage(String userId) {
        JsonResult<List<HR_CandiDateBO>> jsonResult = new JsonResult<List<HR_CandiDateBO>>();
        if(StringUtils.isNull(userId)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try{
            List<HR_CandiDateBO> candiDateList = candiDateService.findUserIdMessage(userId);
            jsonResult.setData(candiDateList);
            jsonResult.setState(StateInforMation.STATUS_SUCCESS);
            jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
        } catch (Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
        }
        return jsonResult;
    }
    /**
     * @description： 根据条件查找应试者信息
     * @see com.personalitytest.user.controller.IFindMessageControllener#findCandiDateMessage(java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月12日上午9:59:08
     */
    @Override
    @RequestMapping("/findCandiDateMessage.do")
    @ResponseBody
    public JsonResult<List<HR_CandiDateBO>> findCandiDateMessage(@RequestParam Map<String,Object> paramMap) {
        JsonResult<List<HR_CandiDateBO>> jsonResult = new JsonResult<List<HR_CandiDateBO>>();
        String userId = String.valueOf(paramMap.get("userId"));
        if(StringUtils.isNull(userId)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try{
            HR_CandiDateBO candiDateBO = new HR_CandiDateBO();
            BeanUtils.copyProperties(candiDateBO, paramMap);
            List<HR_CandiDateBO> candiDateList = candiDateService.findCandiDateMessage(candiDateBO);
            jsonResult.setData(candiDateList);
            jsonResult.setState(StateInforMation.STATUS_SUCCESS);
            jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
        } catch (Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
        }
        return jsonResult;
    }
    /**
     * @description： 添加应试者信息
     * @see com.personalitytest.user.controller.IFindMessageControllener#insertCandiDateMessage(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月12日下午2:35:29
     */
    @Override
    @RequestMapping("/insertCandiDate.do")
    @ResponseBody
    public JsonResult<Boolean> insertCandiDateMessage(@RequestBody HR_CandiDateBO candiDateBO) {
        JsonResult<Boolean> jsonResult =new JsonResult<Boolean>();
        if(StringUtils.isNull(candiDateBO)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try{
            /* 改进 */
//            candiDateBO.setGraduation("2012-02-14");
            boolean falg = candiDateService.insertCandiDateMessage(candiDateBO);
            jsonResult.setData(falg);
            jsonResult.setState(StateInforMation.STATUS_SUCCESS);
            jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
        } catch (Exception e){
            e.printStackTrace();
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_ERROR_MESSAGE);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        
        return jsonResult;
    }

 
    
    
    
    
    
    
    
    
    
}

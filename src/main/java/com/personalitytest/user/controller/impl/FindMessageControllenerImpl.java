/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public JsonResult<List<HR_CandiDateBO>> findCandiDateMessage(String userId,String name,String mobile,String stateId) {
        JsonResult<List<HR_CandiDateBO>> jsonResult = new JsonResult<List<HR_CandiDateBO>>();
        if(StringUtils.isNull(userId)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try{
            HR_CandiDateBO candiDateBO = new HR_CandiDateBO();
            candiDateBO.setUserId(userId);
            if(StringUtils.isNotNull(name)){
                candiDateBO.setName(name);
            }
            if(StringUtils.isNotNull(stateId)){
                candiDateBO.setStateId(stateId);
            }
            if(StringUtils.isNotNull(mobile)){
                candiDateBO.setStateId(mobile);
            }
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
    public JsonResult<Boolean> insertCandiDateMessage(@RequestBody List<HR_CandiDateBO> candiDateList) {
        JsonResult<Boolean> jsonResult =new JsonResult<Boolean>();
        if(StringUtils.isNull(candiDateList)){
            jsonResult.setState(StateInforMation.STATUS_PARAMETER_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PARAMETER_ERROR_MESSAGE);
            return jsonResult;
        }
        try{
            boolean falg = false;
             for(HR_CandiDateBO candiDateBO : candiDateList){
                 candiDateBO.setGraduation("2017-06-08"); 
                 falg = candiDateService.insertCandiDateMessage(candiDateBO);
             }
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

    public static void main(String[] args) {
        HR_CandiDateBO candiDateBO = new HR_CandiDateBO();
//      BeanUtils.copyProperties(candiDateBO, candiDateBO);
        candiDateBO.setName("天天");
        candiDateBO.setGender("女");
        candiDateBO.setDayOfBirth("2017-01-02");
        candiDateBO.setPositionId("30");
        candiDateBO.setMobile("1554485521");
        candiDateBO.setPhone("1554412541");
        candiDateBO.setEmail("1335322520@qq.com");
        candiDateBO.setEducation("硕士");
        candiDateBO.setCollage("文学院");
        candiDateBO.setSchool("清华北大");
        candiDateBO.setMajor("园林园艺");
        candiDateBO.setGraduation("2017-06-08");
        candiDateBO.setQq("1335322520");
        candiDateBO.setSourceId("4");
        candiDateBO.setStateId("4");
        candiDateBO.setUserId("1");
        candiDateBO.setCityId("86");
        Map<String, Object> map = beanToMap(candiDateBO);
        System.out.println(map);
        try {
            HR_CandiDateBO candiDate = (HR_CandiDateBO) mapToBean(map,HR_CandiDateBO.class);
            System.out.println(candiDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //将javaBean转为Map
    public static Map<String, Object> beanToMap(Object obj) { 
        Map<String, Object> params = new HashMap<String, Object>(0); 
        try { 
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) { 
                String name = descriptors[i].getName(); 
                if (!"class".equals(name)) { 
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return params; 
}
    
    
    //将Map转为对象
    public static Object mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {    
        Object obj = clazz.newInstance();    
        if(map != null && map.size() > 0) {    
            for(Map.Entry<String, Object> entry : map.entrySet()) {    
                String propertyName = entry.getKey();       //属性名  
                Object value = entry.getValue();    
                String setMethodName = "set"    
                        + propertyName.substring(0, 1).toUpperCase()  
                        + propertyName.substring(1);    
                Field field = getClassField(clazz, propertyName);    
                if(field==null)  
                    continue;  
                Class<?> fieldTypeClass = field.getType();    
                value = convertValType(value, fieldTypeClass);   
                try{  
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);   
                }catch(NoSuchMethodException e){  
                    e.printStackTrace();  
                }  
            }    
        }    
        return obj;    
    }  
    
    private static Field getClassField(Class<?> clazz, String fieldName) {    
        if( Object.class.getName().equals(clazz.getName())) {    
            return null;    
        }    
        Field []declaredFields = clazz.getDeclaredFields();    
        for (Field field : declaredFields) {    
            if (field.getName().equals(fieldName)) {    
                return field;    
            }    
        }    
    
        Class<?> superClass = clazz.getSuperclass();    
        if(superClass != null) {// 简单的递归一下    
            return getClassField(superClass, fieldName);    
        }    
        return null;    
    }   
    private static Object convertValType(Object value, Class<?> fieldTypeClass) {    
        Object retVal = null;    
        if(Long.class.getName().equals(fieldTypeClass.getName())    
                || long.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Long.parseLong(value.toString());    
        } else if(Integer.class.getName().equals(fieldTypeClass.getName())    
                || int.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Integer.parseInt(value.toString());    
        } else if(Float.class.getName().equals(fieldTypeClass.getName())    
                || float.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Float.parseFloat(value.toString());    
        } else if(Double.class.getName().equals(fieldTypeClass.getName())    
                || double.class.getName().equals(fieldTypeClass.getName())) {    
            retVal = Double.parseDouble(value.toString());    
        } else {    
            retVal = value;    
        }    
        return retVal;    
    } 
    
    
    
    
    
    
    
    
    
}

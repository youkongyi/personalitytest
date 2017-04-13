/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月13日
 * 修改历史 : 
 *     1. [2017年4月13日]创建文件 by gehanbiao
 */
package com.personalitytest.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;

import com.personalitytest.entity.HR_CandiDateBO;

/**
 * 添加类/接口功能描述
 * @author gehanbiao
 * @version 2017年4月13日
 */
public class JavaBeanTransitionMapUtils {

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
    
}

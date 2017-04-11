/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.utils;

import java.io.Serializable;

/**
 * 状态值信息
 * @author gehanbiao
 * @version 2017年4月5日
 */
public class StateInforMation implements Serializable{
    /**
     * @author：gehanbiao
     * @crateDate：2017年4月5日上午10:10:11
     */
    private static final long serialVersionUID = 1L;
    /**
     * 成功
     */
    public static final int STATUS_SUCCESS = 0;
    /**
     * 消息：成功
     */
    public static final String STATUS_SUCCESS_MESSAGE = "成功 ";
    /**
     * 参数错误
     */
    public static final int STATUS_PARAMETER_ERROR = 1;
    /**
     * 消息：参数错误
     */
    public static final String STATUS_PARAMETER_ERROR_MESSAGE = "参数错误";
    /**
     * 失败
     */
    public static final int STATUS_ERROR = 2;
    /**
     * 消息：失败
     */
    public static final String STATUS_ERROR_MESSAGE = "失败";
    
    
    /**
     * 消息：账号不存在或密码错误
     */
    public static final String STATUS_PASSPORT_PASSWORD_MESSAGE = "账号不存在或密码错误";
    
    /**
     * 消息：密码或账号错误
     */
    public static final String STATUS_PASSWORD_MESSAGE = "密码或账号错误";
    
    
    
}

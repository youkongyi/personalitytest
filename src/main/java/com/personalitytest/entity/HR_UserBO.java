/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 *  HR管理员信息表
 * @author gehanbiao
 * @version 2017年4月5日
 */
@Accessors(chain = true)
@Getter
@Setter
public class HR_UserBO {
    /**
     * ID
     */
    private String userId;
    /**
     * 名称
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 昵称
     */
    private String userSureName;
    /**
     * 电话
     */
    private String userMobile;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 备注
     */
    private String column;
    /**
     * 当前页的页号
     */
    private int pageNum = 1;
    /**
     * 当前页显示条目数
     */
    private int pageSize = 5;
    
   
    
}

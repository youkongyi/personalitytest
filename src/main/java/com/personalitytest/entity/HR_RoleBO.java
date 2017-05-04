/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 角色表
 * @author gehanbiao
 * @version 2017年4月10日
 */
@Accessors(chain = true)
@Getter
@Setter
public class HR_RoleBO {
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    
}

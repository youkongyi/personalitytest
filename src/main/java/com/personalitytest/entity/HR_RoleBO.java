/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

/**
 * 角色表
 * @author gehanbiao
 * @version 2017年4月10日
 */
public class HR_RoleBO {
    /**
     * 角色ID
     */
    private int roleId;
    /**
     * 角色名称
     */
    private String roleName;
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}

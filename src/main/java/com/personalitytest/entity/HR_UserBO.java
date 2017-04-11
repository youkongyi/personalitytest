/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

/**
 *  用户信息表
 * @author gehanbiao
 * @version 2017年4月5日
 */
public class HR_UserBO {
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
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
    private int roleId;
    /**
     * 备注
     */
    private String column;
    
    /**
     * @return Returns the userId.
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId The userId to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return Returns the userPassword.
     */
    public String getUserPassword() {
        return userPassword;
    }
    /**
     * @param userPassword The userPassword to set.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    /**
     * @return Returns the userSureName.
     */
    public String getUserSureName() {
        return userSureName;
    }
    /**
     * @param userSureName The userSureName to set.
     */
    public void setUserSureName(String userSureName) {
        this.userSureName = userSureName;
    }
    /**
     * @return Returns the userMobile.
     */
    public String getUserMobile() {
        return userMobile;
    }
    /**
     * @param userMobile The userMobile to set.
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    /**
     * @return Returns the userEmail.
     */
    public String getUserEmail() {
        return userEmail;
    }
    /**
     * @param userEmail The userEmail to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    /**
     * @return Returns the roleId.
     */
    public int getRoleId() {
        return roleId;
    }
    /**
     * @param roleId The roleId to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    /**
     * @return Returns the column.
     */
    public String getColumn() {
        return column;
    }
    /**
     * @param column The column to set.
     */
    public void setColumn(String column) {
        this.column = column;
    }
    
    
}

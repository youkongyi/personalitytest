/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月10日
 * 修改历史 : 
 *     1. [2017年4月10日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

/**
 * 状态信息表BO
 * @author gehanbiao
 * @version 2017年4月10日
 */
public class HR_StateBO {
    /**
     * 状态ID
     */
    private int stateId;
    /**
     * 状态信息
     */
    private String stateName;
    public int getStateId() {
        return stateId;
    }
    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
}

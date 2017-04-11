/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月11日
 * 修改历史 : 
 *     1. [2017年4月11日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

/**
 * 城市地区信息表BO
 * @author gehanbiao
 * @version 2017年4月11日
 */
public class HR_DistrictBO {
    /**
     * 城市ID
     */
    private int districtId;
    /**
     * 城市名称
     */
    private String districtName;
    /**
     * 地区分级
     */
    private int level;
    /**
     * 地区父级
     */
    private int parentId;
    /**
     * list
     */
    private int list;
    
    public int getDistrictId() {
        return districtId;
    }
    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public int getList() {
        return list;
    }
    public void setList(int list) {
        this.list = list;
    }
    /**
     * @description： 添加方法功能描述
     * @see java.lang.Object#toString()
     * @author：gehanbiao
     * @crateDate：2017年4月11日上午10:54:33
     */
    @Override
    public String toString() {
        return "HR_DistrictBO [districtId=" + districtId + ", districtName=" + districtName + ", level=" + level + ", parentId=" + parentId
                + ", list=" + list + "]";
    }
    
}

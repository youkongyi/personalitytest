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
    private String districtId;
    /**
     * 城市名称
     */
    private String districtName;
    /**
     * 地区分级
     */
    private String level;
    /**
     * 地区父级
     */
    private String parentId;
    /**
     * list
     */
    private String list;

    public String getDistrictId() {
        return districtId;
    }
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getList() {
        return list;
    }
    public void setList(String list) {
        this.list = list;
    }
    
   
}

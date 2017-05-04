/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月11日
 * 修改历史 : 
 *     1. [2017年4月11日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 城市地区信息表BO
 * @author gehanbiao
 * @version 2017年4月11日
 */
@Accessors(chain = true)
@Setter
@Getter
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
    
}

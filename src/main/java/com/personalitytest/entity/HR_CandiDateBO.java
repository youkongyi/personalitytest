/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月7日
 * 修改历史 : 
 *     1. [2017年4月7日]创建文件 by gehanbiao
 */
package com.personalitytest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 应试者信息表
 * @author gehanbiao
 * @version 2017年4月7日
 */
@Accessors(chain = true)
@Getter
@Setter
public class HR_CandiDateBO {
    /**
     * 应试者信息表id
     */
    private String candidateId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生年份 date
     */
    private String dayOfBirth;
    /**
     * 职位id
     */
    private String positionId;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 备用电话
     */
    private String phone;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 最高学历
     */
    private String education;
    /**
     * 毕业学校
     */
    private String collage;
    /**
     * 毕业学院
     */
    private String school;
    /**
     * 所学专业
     */
    private String major;
    /**
     * 毕业时间 date
     */
    private String graduation;
    /**
     * QQ
     */
    private String qq;
    /**
     * 信息来源id
     */
    private String sourceId;
    /**
     * 目前状态id
     */
    private String stateId;
    /**
     * 录入主管id
     */
    private String userId;
    /**
     * 所在城市id
     */
    private String cityId;
    
    
}

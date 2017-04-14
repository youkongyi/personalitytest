/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.personalitytest.entity.HR_DistrictBO;
import com.personalitytest.entity.HR_UserBO;

/**
 * 用户操作接口
 * @author gehanbiao
 * @version 2017年4月5日
 */
public interface IUserDAO {
    /**
     * @description： 测试: PageHelper分页工具
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月11日上午11:38:49
     */
    List<HR_DistrictBO> selectAll();
    
    /**
     * @description： 根据账号查找用户信息
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月5日上午10:43:35
     */
    HR_UserBO findUserByName(String userName);
    /**
     * @description：测试: 不用Mapper.xml映射文件用例
     * @param userName
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月11日下午2:14:53
     */
    @Select("SELECT USER_ID AS userid FROM HR_USER WHERE USER_ID = #{userId }")
    HR_UserBO findUserByNames(@Param("userId")String userId);
    /**
     * @description： 添加HR管理员
     * @param userBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日上午10:44:33
     */
    int insertUser(HR_UserBO userBO);
    /**
     * @description：根据当前HR管理员ID查找角色roleid
     * @param userId
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日下午4:32:12
     */
    @Select("SELECT ROLE_ID AS roleId FROM HR_USER WHERE USER_ID = #{userId }")
    String findRoleId(String userId);
    /**
     * @description：根据角色ID查找相应的HR管理员
     * @param roleId
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日下午4:05:47
     */
    @Select(" SELECT "
            + " USER_ID AS userid,"
            + " USER_NAME AS userName,"
            + " USER_SURE_NAME AS userSureName,"
            + " USER_MOBILE AS userMobile,"
            + " USER_EMAIL AS userEmail,"
            + " ROLE_ID AS roleId,"
            + " `COLUMN_` AS `column` "
           + " FROM HR_USER WHERE ROLE_ID >= #{roleId }")
    List<HR_UserBO> findHRUser(@Param("roleId")String roleId);
    /**
     * @description： 更新当前HR管理员信息
     * @param userBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月14日上午9:23:06
     */
    int updateUser(HR_UserBO userBO); 
    
    
    
    
    
    
    
    
    
    
}

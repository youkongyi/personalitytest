/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.controller;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.PageInfo;
import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.utils.JsonResult;

/**
 *  HR管理员操作接口
 * @author gehanbiao
 * @version 2017年4月5日
 */
public interface IUserController {
    /**
     * @description： HR管理员登录
     * @param userName
     * @param password
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日上午10:24:54
     */
    JsonResult<HR_UserBO> userLogin(String userName, String password,HttpServletRequest req);
    /**
     * @description： 添加HR管理员
     * @param paramMap
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日上午10:25:29
     */
    JsonResult<Boolean> insertUser(Map<String,Object> paramMap);
    /**
     * @description： 根据角色ID查找相应的HR管理员
     * @param paramMap
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月13日下午4:22:34
     */
    JsonResult<PageInfo<HR_UserBO>> findRoleIdHRUser(Map<String,Object> paramMap);
    /**
     * @description： 更新当前HR管理员信息
     * @param paramMap
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月14日上午9:11:18
     */
    JsonResult<Boolean> updateUser(Map<String,Object> paramMap);
    /**
     * @description： 根据相关条件查找相应的HR管理员
     * @param userBO
     * @return
     * @author：gehanbiao
     * @crateDate：2017年4月20日上午9:00:30
     */
    JsonResult<PageInfo<HR_UserBO>> findHRUser(Map<String,Object> paramMap);
}

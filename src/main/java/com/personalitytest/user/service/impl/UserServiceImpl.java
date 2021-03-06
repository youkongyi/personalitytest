/*
 * 鼎方公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2017年4月5日
 * 修改历史 : 
 *     1. [2017年4月5日]创建文件 by gehanbiao
 */
package com.personalitytest.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.user.dao.IUserDAO;
import com.personalitytest.user.service.IUserService;
import com.personalitytest.utils.JsonResult;
import com.personalitytest.utils.Pinyin4jUtil;
import com.personalitytest.utils.StateInforMation;
import com.personalitytest.utils.StringUtils;
    
/**
 * 用户操作
 * @author gehanbiao
 * @version 2017年4月5日
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO userDAO;
    
    /**
     * @description： 用户登录
     * @see com.personalitytest.user.service.IUserService#userLogin(java.lang.String, java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月5日上午9:48:20
     */
    @Override
    public JsonResult<HR_UserBO> userLogin(String userName, String password) {
        JsonResult<HR_UserBO> jsonResult = new JsonResult<HR_UserBO>();
        HR_UserBO userBO = userDAO.findUserByName(userName);
        if(StringUtils.isNull(userBO)){
            jsonResult.setState(StateInforMation.STATUS_ERROR);
            jsonResult.setMessage(StateInforMation.STATUS_PASSPORT_PASSWORD_MESSAGE);
        } else {
            if(password.equals(userBO.getUserPassword())){
                jsonResult.setData(userBO);
                jsonResult.setState(StateInforMation.STATUS_SUCCESS);
                jsonResult.setMessage(StateInforMation.STATUS_SUCCESS_MESSAGE);
            } else {
                jsonResult.setState(StateInforMation.STATUS_ERROR);
                jsonResult.setMessage(StateInforMation.STATUS_PASSWORD_MESSAGE); 
            }
        }
        return jsonResult;
    }

    /**
     * @description： 添加HR管理员
     * @see com.personalitytest.user.service.IUserService#insertUser(com.personalitytest.entity.HR_UserBO)
     * @author：gehanbiao
     * @crateDate：2017年4月13日上午10:41:34
     */
    @Override
    public boolean insertUser(HR_UserBO userBO) {
        String userName = userBO.getUserSureName();
        String pinyin = Pinyin4jUtil.converterToSpell(userName);
        pinyin = pinyin.substring(pinyin.lastIndexOf(",")+1);
        userBO.setUserName(pinyin);
        userBO.setUserPassword(pinyin);
        int num = userDAO.insertUser(userBO);
        if(num > 0){
            return true;    
        }
        return false;
    }

    /**
     * @description：  根据角色ID查找相应的HR管理员
     * @see com.personalitytest.user.service.IUserService#findHRUser(java.lang.String)
     * @author：gehanbiao
     * @crateDate：2017年4月13日下午4:36:51
     */
    @Override
    public PageInfo<HR_UserBO> findRoleIdHRUser(String userId,int pageNum,int pageSize) {
        String roleId = userDAO.findRoleId(userId);
        if(StringUtils.isNotNull(roleId)){
            PageHelper.startPage(pageNum, pageSize);
            List<HR_UserBO> list = userDAO.findRoleIdHRUser(roleId);
            return new PageInfo<HR_UserBO>(list); 
        }
        return new PageInfo<HR_UserBO>();
    }

    /**
     * @description：  更新当前HR管理员信息
     * @see com.personalitytest.user.service.IUserService#updateUser(com.personalitytest.entity.HR_UserBO)
     * @author：gehanbiao
     * @crateDate：2017年4月14日上午9:14:35
     */
    @Override
    public boolean updateUser(HR_UserBO userBO) {
        int num = userDAO.updateUser(userBO);
        if(num > 0 ){
           return true;    
        }
        return false;
    }

    /**
     * @description：  根据相关条件查找相应的HR管理员
     * @see com.personalitytest.user.service.IUserService#findHRUser(com.personalitytest.entity.HR_UserBO)
     * @author：gehanbiao
     * @crateDate：2017年4月20日上午9:01:15
     */
    @Override
    public PageInfo<HR_UserBO> findHRUser(HR_UserBO userBO) {
        String roleId = userDAO.findRoleId(userBO.getUserId());
        if(StringUtils.isNotNull(roleId)){
            userBO.setRoleId(roleId);
            PageHelper.startPage(userBO.getPageNum(), userBO.getPageSize());
            List<HR_UserBO> list = userDAO.findHRUser(userBO);
            return new PageInfo<HR_UserBO>(list);
        }
        return new PageInfo<HR_UserBO>();
    }

}

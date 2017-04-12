package com.personalitytest.test;


import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.personalitytest.entity.HR_CandiDateBO;
import com.personalitytest.entity.HR_DistrictBO;
import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.user.dao.IMessageDAO;
import com.personalitytest.user.dao.IUserDAO;
import com.personalitytest.user.service.ICandiDateService;
import com.personalitytest.user.service.IUserService;
import com.personalitytest.utils.JsonResult;



public class MyBatisTestCase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
	    /* 只测试mybatis/SQL语句 */
//	    ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ctx = new ClassPathXmlApplicationContext("spring-web.xml","spring-service.xml","spring-mybatis.xml");
	}
	
	@Test
	public void test1(){
		DataSource ds = ctx.getBean("dataSource",DataSource.class);
		System.out.println(ds);
	}
	
	@Test
	public void test2(){
		SqlSessionFactory ssf = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(ssf);
	}
	
	@Test
	public void test3(){
		MapperScannerConfigurer msc = ctx.getBean("mapperScanner",MapperScannerConfigurer.class);
		System.out.println(msc);
	}
	
	@Test
    public void test4(){
        IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
        HR_UserBO userbo = dao.findUserByName("gehanbiao");
        System.out.println(userbo);
    }
	
	@Test
    public void test5(){
	    IUserService userService = ctx.getBean("userService",IUserService.class);
	    String userName = "gehanbiao";
	    String password = "gehanbiao";
	    JsonResult<HR_UserBO> userBO = userService.userLogin(userName, password);
	    System.out.println(userBO.getMessage());
	}
	@Test
	public void test6(){
	    /* 测试分页 */
	    IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
        PageHelper.startPage(2, 16);
        List<HR_DistrictBO> list = dao.selectAll();
        assertEquals("湖北省", list.get(0).getDistrictName());
	}
	@Test
	public void test7(){
	    /* 测试用Mapper接口写入 */
	    IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
        HR_UserBO userbo = dao.findUserByNames(1);
        System.out.println(userbo);
	}
	
	@Test
	public void test8(){
	    IMessageDAO dao = ctx.getBean("IMessageDAO",IMessageDAO.class); 
	    List<HR_CandiDateBO> list = dao.findUserIdMessage("1");
	    System.out.println(list.get(0).getEmail());
	}
	
	@Test
	public void test9(){
	    ICandiDateService service = ctx.getBean("candiDateService",ICandiDateService.class);
	    List<HR_CandiDateBO> json = service.findUserIdMessage("1");
	    System.out.println(json);
	}
	
	@Test
	public void test10(){
	    IMessageDAO dao = ctx.getBean("IMessageDAO",IMessageDAO.class); 
	    HR_CandiDateBO candiDateBO = new HR_CandiDateBO();
	    candiDateBO.setUserId("1");
	    List<HR_CandiDateBO> list = dao.findCandiDateMessage(candiDateBO);
	    System.out.println(list);
	}
	
	@Test
    public void test11(){
        ICandiDateService service = ctx.getBean("candiDateService",ICandiDateService.class);
        HR_CandiDateBO candiDateBO = new HR_CandiDateBO();
        candiDateBO.setUserId("1");
        candiDateBO.setStateId("1");
        List<HR_CandiDateBO> json = service.findCandiDateMessage(candiDateBO);
        System.out.println(json);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

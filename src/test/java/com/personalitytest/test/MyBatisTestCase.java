package com.personalitytest.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personalitytest.entity.HR_CandiDateBO;
import com.personalitytest.entity.HR_DistrictBO;
import com.personalitytest.entity.HR_UserBO;
import com.personalitytest.user.dao.IMessageDAO;
import com.personalitytest.user.dao.IUserDAO;
import com.personalitytest.user.service.ICandiDateService;
import com.personalitytest.user.service.IUserService;
import com.personalitytest.utils.JsonResult;
import com.personalitytest.utils.Pinyin4jUtil;
import com.personalitytest.utils.StringUtils;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;



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
        PageInfo<HR_DistrictBO> page = new PageInfo<HR_DistrictBO>(list);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(page);
        System.out.println(page.getList().get(0));
	}
	@Test
	public void test7(){
	    /* 测试用Mapper接口写入 */
	    IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
        HR_UserBO userbo = dao.findUserByNames("1");
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
	    PageInfo<HR_CandiDateBO> json = service.findUserIdMessage("1");
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
        candiDateBO.setName("戈汉彪");
        PageInfo<HR_CandiDateBO> json = service.findCandiDateMessage(candiDateBO);
        System.out.println(json);
    }
	@Test
    public void test12(){
	    IMessageDAO dao = ctx.getBean("IMessageDAO",IMessageDAO.class); 
        HR_CandiDateBO candiDateBO = new HR_CandiDateBO();
        candiDateBO.setName("天天");
        candiDateBO.setGender("女");
        candiDateBO.setDayOfBirth("2017-01-02");
        candiDateBO.setPositionId("30");
        candiDateBO.setMobile("1554485521");
        candiDateBO.setPhone("1554412541");
        candiDateBO.setEmail("1335322520@qq.com");
        candiDateBO.setEducation("硕士");
        candiDateBO.setCollage("文学院");
        candiDateBO.setSchool("清华北大");
        candiDateBO.setMajor("园林园艺");
        candiDateBO.setGraduation("2017-06-08");
        candiDateBO.setQq("1335322520");
        candiDateBO.setSourceId("4");
        candiDateBO.setStateId("4");
        candiDateBO.setUserId("1");
        candiDateBO.setCityId("86");
        int i = dao.insertCandiDateMessage(candiDateBO);
        System.out.println(i);
    }
	
	@Test
	public void test13(){
	    IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
	    HR_UserBO userBO = new HR_UserBO();
	    userBO.setUserName("xiaoyuekexin");
	    userBO.setUserPassword("xiaoyuekexin");
	    userBO.setUserSureName("舒服");
	    userBO.setUserMobile("15548544854");
	    userBO.setUserEmail("askjhdsf@fsd.com");
	    userBO.setRoleId("2");
	    userBO.setColumn("阿斯顿");
	    int num = dao.insertUser(userBO);
	    System.out.println(num);
	}
	
	@Test
    public void test14(){
	    IUserService userService = ctx.getBean("userService",IUserService.class);
	    HR_UserBO userBO = new HR_UserBO();
        userBO.setUserName("xiaoyuekexin");
        userBO.setUserPassword("xiaoyuekexin");
        userBO.setUserSureName("舒服");
        userBO.setUserMobile("15548544854");
        userBO.setUserEmail("askjhdsf@fsd.com");
        userBO.setRoleId("2");
        userBO.setColumn("阿斯顿");
       boolean flag = userService.insertUser(userBO);
       System.out.println(flag);
	}
	
	@Test
    public void test15(){
	    IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
	    String roleId = dao.findRoleId("1");
	    System.out.println(roleId);
	}
	
	@Test
    public void test16(){
	   IUserService userService = ctx.getBean("userService",IUserService.class); 
	   PageInfo<HR_UserBO> list = userService.findRoleIdHRUser("1",1,2);
	   System.out.println(list);
	}
	//测试字符串转换拼音jar包
	@Test
    public void test17() throws BadHanyuPinyinOutputFormatCombination{
	    String str = "纪晓岚";  
	    String pinyin = Pinyin4jUtil.converterToSpell(str);
	    System.out.println(pinyin);
	    pinyin = pinyin.substring(pinyin.lastIndexOf(",")+1);
        System.out.println(pinyin);
	}
	
	@Test
    public void test18(){
	    IUserDAO dao = ctx.getBean("IUserDAO",IUserDAO.class);
	    HR_UserBO userBO = new HR_UserBO();
	    userBO.setUserId("3");
        userBO.setUserPassword("liuluoguo");
        userBO.setUserSureName("刘罗锅");
        userBO.setUserEmail("a87988235@qq.com");
        userBO.setUserMobile("15527204233");
	    int num = dao.updateUser(userBO);
	    System.out.println(num);
	}

   @Test
    public void test19(){
       IUserService userService = ctx.getBean("userService",IUserService.class); 
       HR_UserBO userBO = new HR_UserBO();
       userBO.setUserId("3");
       userBO.setUserPassword("liuluoguo");
       userBO.setUserSureName("刘罗锅");
       userBO.setUserEmail("a87988235@qq.com");
       userBO.setUserMobile("15527204233");
       userService.updateUser(userBO);
   }
	
	
   @Test
   public void test20(){
      IUserService userService = ctx.getBean("userService",IUserService.class);
      HR_UserBO userBO = new HR_UserBO();
      userBO.setUserId("1");
      PageInfo<HR_UserBO> list = userService.findHRUser(userBO);
      System.out.println(list);
   }
	
	
	
	
   @Test
   public void test21(){
       String str = "$.ajax({asdasd asdasd ,url:'/index/list',type:'json',success:function(){console.log('OK');}});";
       String pattern = "url:\'(.*?)\'";
       Matcher matcher = Pattern.compile(pattern).matcher(str);
       String openid = "";
       while (matcher.find()) {
           openid = matcher.group(1);
       }
       String http = "http";
       System.out.println(openid);
       if(StringUtils.isNotNull(openid)){
           String sql = "url:'"+http+openid+"'";
           str = str.replaceAll(pattern, sql);
       }
       System.out.println(str);
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

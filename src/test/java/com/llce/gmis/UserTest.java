package com.llce.gmis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.llce.gmis.service.GmisService;

public class UserTest {

private GmisService gmisService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-servlet.xml"
        		,"classpath:spring-mybatis.xml"
                ,"classpath:mapping/user-mapper.xml"});
		gmisService = (GmisService) context.getBean("gmisService");
	}
	
	@Test
    public void getUser(){
        System.out.println(gmisService.getUserById(1000).getRole());
    }
}

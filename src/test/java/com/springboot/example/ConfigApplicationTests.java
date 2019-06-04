package com.springboot.example;

import com.springboot.example.service.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//SpringBoot1.4版本之前用的是SpringJUnit4ClassRunner.class
@RunWith(SpringRunner.class)
//SpringBoot1.4版本之前用的是@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ConfigApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void getHello() throws Exception {
		Assert.assertEquals(blogProperties.getName(), "Programmer AA");
		Assert.assertEquals(blogProperties.getTitle(), "Spring Boot Demo");
	}

	@Test
	public void test() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}
}

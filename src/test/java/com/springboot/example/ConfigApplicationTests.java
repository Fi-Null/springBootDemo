package com.springboot.example;

import com.springboot.example.service.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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


	@Test
	public void getHello() throws Exception {
		Assert.assertEquals(blogProperties.getName(), "Programmer AA");
		Assert.assertEquals(blogProperties.getTitle(), "Spring Boot Demo");
	}
}

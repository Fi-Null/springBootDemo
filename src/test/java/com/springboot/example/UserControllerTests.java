package com.springboot.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author null
 * @version 1.0
 * @title
 * @description
 * @createDate 6/3/19 2:12 PM
 */
//SpringBoot1.4版本之前用的是SpringJUnit4ClassRunner.class
@RunWith(SpringRunner.class)
//SpringBoot1.4版本之前用的是@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
public class UserControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种

       /* mockMvc = MockMvcBuilders.standaloneSetup(
                new HelloController(),
                new UserController()).build();*/
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void testUserController() throws Exception {
//  	测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/users/");
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        // 2、post提交一个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mockMvc.perform(request)
				.andDo(MockMvcResultHandlers.print())
                .andExpect(content().string("success"));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]"));

        // 4、put修改id为1的user
        request = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mockMvc.perform(request)
                .andExpect(content().string("success"));

        // 5、get一个id为1的user
        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}"));

        // 6、del删除id为1的user
        request = delete("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string("success"));

        // 7、get查一下user列表，应该为空
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

    }




}

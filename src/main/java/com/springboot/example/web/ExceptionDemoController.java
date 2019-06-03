package com.springboot.example.web;

import com.springboot.example.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author null
 * @version 1.0
 * @title
 * @description
 * @createDate 6/3/19 3:51 PM
 */
@Controller
public class ExceptionDemoController {

    @RequestMapping("/helloException")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/jsonException")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
}

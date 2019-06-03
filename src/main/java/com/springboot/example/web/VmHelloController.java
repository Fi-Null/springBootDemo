package com.springboot.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author null
 * @version 1.0
 * @title
 * @description
 * @createDate 6/3/19 2:33 PM
 */
@Controller
public class VmHelloController {

    @RequestMapping("/helloVm")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    //@RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
}

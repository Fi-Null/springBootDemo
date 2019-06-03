package com.springboot.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author null
 * @version 1.0
 * @title
 * @description
 * @createDate 6/3/19
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}

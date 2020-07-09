package com.al.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world 样板
 * @version 1.0
 * @author guo.baorong
 * @date 2020/07/07
 */
@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @GetMapping("/helloString")
    public String helloString() {
        return "Hello from Spring Boot";
    }
}

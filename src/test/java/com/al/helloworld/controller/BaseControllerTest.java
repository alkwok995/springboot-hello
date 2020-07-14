package com.al.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Controller测试基类
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-14
 */
@WebMvcTest
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;
}

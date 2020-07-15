package com.al.helloworld.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * 集成测试基类
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-15
 */
@SpringBootTest
@TestPropertySource(properties = {"spring.profiles.active:test"})
public class BaseIntegrationTest {
}

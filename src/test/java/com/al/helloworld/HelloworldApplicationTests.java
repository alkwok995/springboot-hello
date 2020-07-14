package com.al.helloworld;

import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.repository.SystemUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(properties = {"spring.profiles.active:test"})
class HelloworldApplicationTests {

    @Autowired
    private SystemUserRepository userRepository;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.datasource.data}")
    private String data;

    @Test
    void contextLoads() {
        System.out.println(ddlAuto);
        System.out.println(data);
        List<SystemUser> users = userRepository.findByLastName("Zhang");
        System.out.println(users.get(0));
        Assertions.assertFalse(users.isEmpty());
    }

}

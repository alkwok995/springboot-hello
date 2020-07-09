package com.al.helloworld.service;

import com.al.helloworld.HelloWorldApplication;
import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.repository.SystemUserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 用户Service测试类
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-09
 */
@SpringBootTest
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SystemUserServiceTest {
    @Autowired
    private SystemUserRepository userRepository;
    @Autowired
    private SystemUserService userService;

    private static SystemUser originalUser;
    static {
        originalUser = new SystemUser();
        originalUser.setUserId(1L);
        originalUser.setFirstName("San");
        originalUser.setLastName("Zhang");
    }

    @Test
    @Order(1)
    public void testFindAll() {
        List<SystemUser> expectedList = new ArrayList<>();
        expectedList.add(originalUser);

        List<SystemUser> testList = userService.findAllUser();
        Assertions.assertIterableEquals(expectedList, testList);
    }

    @Test
    @Order(2)
    public void testFindUserByLastName() {
        List<SystemUser> expectedList = new ArrayList<>();
        expectedList.add(originalUser);

        List<SystemUser> testList = userService.findUserByLastName("Zhang");
        Assertions.assertIterableEquals(expectedList, testList);

        List<SystemUser> testList1 = userService.findUserByLastName("Wang");
        Assertions.assertTrue(testList1.isEmpty());
    }

    @Test
    @Order(3)
    public void testAddUser() {
        SystemUser user = new SystemUser();
        user.setFirstName("Wu");
        user.setLastName("Wang");

        SystemUser savedUser = userService.saveSystemUser(user);
        Optional<SystemUser> expected = userRepository.findById(savedUser.getUserId());
        Assertions.assertTrue(expected.isPresent());
    }

    @Test
    @Order(4)
    public void testUpdateUser() {
        SystemUser user = new SystemUser();
        user.setFirstName("Si");
        user.setUserId(originalUser.getUserId());

        SystemUser savedUser = userService.saveSystemUser(user);
        Optional<SystemUser> expected = userRepository.findById(originalUser.getUserId());
        Assertions.assertTrue(expected.isPresent() && "Si".equals(expected.get().getFirstName()));
    }
}

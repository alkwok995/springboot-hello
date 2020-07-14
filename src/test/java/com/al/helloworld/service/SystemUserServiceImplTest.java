package com.al.helloworld.service;

import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.repository.SystemUserRepository;
import com.al.helloworld.service.impl.SystemUserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * 用户Service Test
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-14
 */
@SpringBootTest
public class SystemUserServiceImplTest {

    @Configuration
    static class SystemUserServiceConfiguration {
        @Bean
        public SystemUserService systemUserService() {
            return new SystemUserServiceImpl();
        }
    }

    @Autowired
    private SystemUserService systemUserService;

    @MockBean
    private SystemUserRepository systemUserRepository;

    @Test
    public void testDoLogin() {
        SystemUser sampleUser = new SystemUser();
        sampleUser.setUserId(1L);
        sampleUser.setFirstName("San");
        sampleUser.setLastName("Zhang");
        sampleUser.setPassword("123456");
        Mockito.when(systemUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sampleUser));
        Assertions.assertFalse(systemUserService.doLogin(1L, "654321"));
        Assertions.assertTrue(systemUserService.doLogin(1L, "123456"));
    }
}

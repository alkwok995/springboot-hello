package com.al.helloworld.controller;

import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.service.SystemUserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 用户Controller Test
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-14
 */
public class SystemUserControllerTest extends BaseControllerTest {

    @MockBean
    private SystemUserService systemUserService;

    @Test
    public void testSaveUser() throws Exception {
        SystemUser sampleUser = new SystemUser();
        sampleUser.setUserId(1L);
        sampleUser.setFirstName("San");
        sampleUser.setLastName("Zhang");
        sampleUser.setPassword("123456");

        String jsonStr = "{firstName: 'San', lastName: 'Zhang', password: '123456'}";

        Mockito.when(systemUserService.saveSystemUser(Mockito.any())).thenReturn(sampleUser);
        String result = mockMvc.perform(
                MockMvcRequestBuilders.post("/systemUser/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonStr)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println("===========================");
        System.out.println(result);

    }
}

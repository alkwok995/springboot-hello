package com.al.helloworld.integration;

import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.repository.SystemUserRepository;
import com.alibaba.fastjson.JSON;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 用户模块集成测试
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-15
 */
@AutoConfigureMockMvc
public class SystemUserIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SystemUserRepository userRepository;

    @Test
    @Transactional
    public void testSaveUser() throws Exception {
        SystemUser testUser = new SystemUser();
        testUser.setFirstName("Si");
        testUser.setLastName("Li");
        testUser.setPassword("123456");
        String jsonStr = JSON.toJSONString(testUser);

        String resultJson = mockMvc.perform(
                MockMvcRequestBuilders.post("/systemUser/user")
                        .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonStr))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId", Matchers.notNullValue()))
                .andReturn().getResponse().getContentAsString();

        SystemUser test = JSON.parseObject(resultJson, SystemUser.class);
        Optional<SystemUser> expected = userRepository.findById(test.getUserId());

        Assertions.assertTrue(expected.isPresent());
        Assertions.assertEquals(test, expected.get());
    }

}

package com.al.helloworld.repository;

import com.al.helloworld.domain.SystemUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collections;
import java.util.List;

/**
 * 用户Repository Test
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-14
 */
public class SystemUserRepositoryTest extends BaseRepositoryTest{

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void beforeEach() {
        SystemUser user1 = new SystemUser();
        user1.setFirstName("San");
        user1.setLastName("Zhang");
        SystemUser user2 = new SystemUser();
        user2.setFirstName("Si");
        user2.setLastName("Li");

        entityManager.persist(user1);
        entityManager.persist(user2);
    }

    @Test
    public void testFindByLastName() {
        SystemUser user1 = new SystemUser();
        user1.setUserId(1L);
        user1.setFirstName("San");
        user1.setLastName("Zhang");
        List<SystemUser> expected = Collections.singletonList(user1);
        List<SystemUser> test = systemUserRepository.findByLastName("Zhang");

        Assertions.assertIterableEquals(expected, test);
    }
}

package com.al.helloworld.repository;

import com.al.helloworld.domain.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Repository
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-09
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
    List<SystemUser> findByLastName(String lastName);
}

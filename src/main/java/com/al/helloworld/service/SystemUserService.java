package com.al.helloworld.service;

import com.al.helloworld.domain.SystemUser;

import java.util.List;

/**
 * 用户Service
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-09
 */
public interface SystemUserService {
    List<SystemUser> findAllUser();
    List<SystemUser> findUserByLastName(String lastName);
    SystemUser saveSystemUser(SystemUser systemUser);
    boolean doLogin(Long userId, String password);
}

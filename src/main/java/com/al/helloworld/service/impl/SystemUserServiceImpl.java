package com.al.helloworld.service.impl;

import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.repository.SystemUserRepository;
import com.al.helloworld.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 用户Service实现类
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-09
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public List<SystemUser> findAllUser() {
        return systemUserRepository.findAll();
    }

    @Override
    public List<SystemUser> findUserByLastName(String lastName) {
        return systemUserRepository.findByLastName(lastName);
    }

    @Override
    public SystemUser saveSystemUser(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    @Override
    public boolean doLogin(Long userId, String password) {
        Optional<SystemUser> user = systemUserRepository.findById(userId);
        if(user.isPresent()) {
            return user.get().getPassword().equals(password);
        } else {
            return false;
        }
    }
}

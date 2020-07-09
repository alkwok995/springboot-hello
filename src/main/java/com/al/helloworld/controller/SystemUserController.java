package com.al.helloworld.controller;

import com.al.helloworld.domain.SystemUser;
import com.al.helloworld.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户Controller
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-09
 */
@RestController
@RequestMapping("/systemUser")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @GetMapping("/allUser")
    public List<SystemUser> getAllUser() {
        return systemUserService.findAllUser();
    }

    @GetMapping("/userWithLastName")
    public List<SystemUser> getUser(String lastName) {
        /*if(StringUtils.isEmpty(lastName)) {

        }*/
        return systemUserService.findUserByLastName(lastName);
    }

    @PostMapping("/user")
    public SystemUser saveUser(SystemUser user) {
        return systemUserService.saveSystemUser(user);
    }
}

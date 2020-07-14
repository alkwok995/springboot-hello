package com.al.helloworld.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户实体类
 * @author guo.baorong
 * @version v1.0
 * @date 2020-07-09
 */
@Data
@NoArgsConstructor
@Entity
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String password;

    @Override
    public String toString() {
        return String.format(
                "System User[id=%d, firstName='%s', lastName='%s']",
                userId, firstName, lastName);
    }
}

package com.langg.service;

import com.langg.domain.User;

/**
 * userService
 *
 * @author zh
 * @date 2019/11/13 17:39
 * @since 1.0.0
 */
public interface IUserService {

    User login(String name, String password);

    User findById(Long name);
}

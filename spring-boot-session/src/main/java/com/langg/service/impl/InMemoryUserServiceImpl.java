package com.langg.service.impl;

import com.langg.domain.User;
import com.langg.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * userService实现
 *
 * @author zh
 * @date 2019/11/13 17:41
 * @since 1.0.0
 */
@Service
public class InMemoryUserServiceImpl implements IUserService {

    private static Map<Long, User> repository = new ConcurrentHashMap<>();

    static {
        repository.put(1L, User.builder().id(1L).name("test_1").password("135790").desc("测试1").build());
        repository.put(2L, User.builder().id(2L).name("test_2").password("246880").desc("测试2").build());
        repository.put(3L, User.builder().id(3L).name("test_3").password("123456").desc("测试3").build());
    }

    @Override
    public User login(String name, String password) {
        final User[] users = new User[1];
        repository.forEach((id, user) -> {
            if (name.equals(user.getName())) {
                if (password.equals(user.getPassword())) {
                    users[0] = user;
                }
            }
        });

        return users[0];
    }

    @Override
    public User findById(Long id) {
        return repository.get(id);
    }
}

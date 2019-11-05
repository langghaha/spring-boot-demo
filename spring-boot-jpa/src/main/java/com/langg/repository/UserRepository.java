package com.langg.repository;

import com.langg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * UserDao
 *
 * @author zh
 * @date 2019/11/5 11:52
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);
}

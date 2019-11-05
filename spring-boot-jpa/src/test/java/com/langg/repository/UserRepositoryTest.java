package com.langg.repository;

import com.langg.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试类
 *
 * @author zh
 * @date 2019/11/5 16:47
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增
     */
    @Test
    public void saveTest() {
        User user1 = User.builder().name("user2").password("13579").build();

        User saveUser = userRepository.save(user1);

        Assert.assertNotNull(saveUser);

        //执行成功:save user id = 3
        log.debug("save user id = {}", saveUser.getId());
    }

    /**
     * 删除
     */
    @Test
    public void deleteTest() {
        userRepository.deleteById(2L);

        Assert.assertEquals(userRepository.findById(2L).isPresent(), false);
    }

    /**
     * 修改
     */
    @Test
    public void updateTest() {
        User user = User.builder().id(1L).name("修改了id=1的user").password("123456").build();

        User save = userRepository.save(user);

        //执行成功:update name by id name = 修改了id=1的user
        log.debug("update name by id name = {}", save.getName());
    }

    /**
     * 查询所有
     */
    @Test
    public void findAllTest() {
        List<User> all = userRepository.findAll();

        //执行成功:userList = [User(id=1, name=zhuhao, password=123456), User(id=2, name=cyc, password=654321)]
        log.debug("userList = {}", all);
    }

    /**
     * 根据用户名条件查询
     */
    @Test
    public void findByNameTest() {
        List<User> zhuhao = userRepository.findAllByName("zhuhao");

        //执行成功:userList = [User(id=1, name=zhuhao, password=123456)]
        log.debug("userList = {}", zhuhao);
    }
}

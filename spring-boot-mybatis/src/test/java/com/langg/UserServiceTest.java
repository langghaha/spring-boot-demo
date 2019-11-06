package com.langg;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.langg.entity.User;
import com.langg.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService测试
 *
 * @author zh
 * @date 2019/11/6 14:49
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    /**
     * 新增
     */
    @Test
    public void saveTest() {
        boolean user_test = userService.save(User.builder().name("user_test").password("520110").build());

        Assert.assertTrue(user_test);
    }

    /**
     * 删除
     */
    @Test
    public void deleteTest() {
        boolean byId = userService.removeById(2L);

        Assert.assertTrue(byId);
    }

    /**
     * 更新
     */
    @Test
    public void updateTest() {
        log.debug("修改前 user  {}", userService.getById(1L));
        userService.updateById(User.builder().id(1L).name("update_user").password("548458").build());
        log.debug("修改后 user : {}", userService.getById(1L));
    }

    /**
     * 查询所有
     */
    @Test
    public void findAllTest() {
        List<User> list = userService.list();

        log.debug("查询所有 list = {}", list);
    }

    /**
     * 批量添加
     */
    @Test
    public void batchSaveTest() {
        int count = userService.count();
        log.debug("批量添加前的总数:{}", userService.count());
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            userList.add(User.builder().name("user_test_no" + i).password("12345").build());
        }
        userService.saveBatch(userList);
        Assert.assertEquals(userList.size() + count, userService.count());
        log.debug("批量添加后的总数:{}", userService.count());
    }

    /**
     * 条件查询
     */
    @Test
    public void findByConditionTest() {
        List<User> list = userService.list(new QueryWrapper<User>().like("name", "hu"));

        Assert.assertEquals(1, list.size());

        log.debug("查询结果 list = {}", list);
    }

    /**
     * 分页查询
     * 注:mybatis-plus默认单页最多查询500条数据,修改:PaginationInterceptor#setLimit(){@link PaginationInterceptor}
     */
    @Test
    public void findByPageTest() {
        userService.save(User.builder().name("user_test01").password("123456").build());
        userService.save(User.builder().name("user_test02").password("123456").build());
        userService.save(User.builder().name("03user_test").password("123456").build());

        IPage<User> page = userService.page(new Page<>(1, 2),
                new QueryWrapper<User>().likeRight("name", "user_test").or().eq("password", "123456"));

        Assert.assertEquals(2, page.getSize());
        log.debug("total = {}, records = {}", page.getTotal(), page.getRecords());
    }
}

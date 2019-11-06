package com.langg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.langg.entity.User;
import com.langg.mapper.UserMapper;
import com.langg.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author zh
 * @date 2019/11/6 14:46
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

package com.langg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.langg.entity.User;
import org.springframework.stereotype.Component;

/**
 * UserMapper
 *
 * @author zh
 * @date 2019/11/6 14:09
 * @since 1.0.0
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}

package com.changes.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.changes.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiuJunJie
 * @since 2019/7/1 15:37
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}

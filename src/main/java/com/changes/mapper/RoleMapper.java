package com.changes.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.changes.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiuJunJie
 * @since 2019/6/28 16:31
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
}

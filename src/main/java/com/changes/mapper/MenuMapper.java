package com.changes.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.changes.bean.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiuJunJie
 * @since 2019/6/28 14:34
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
}

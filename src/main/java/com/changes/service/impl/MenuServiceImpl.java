package com.changes.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.changes.bean.Menu;
import com.changes.mapper.MenuMapper;
import com.changes.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuJunJie
 * @since 2019/6/28 15:10
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectList() {
        return menuMapper.selectList(new EntityWrapper<>());
    }
}

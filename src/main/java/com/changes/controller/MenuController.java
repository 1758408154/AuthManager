package com.changes.controller;

import com.changes.bean.Menu;
import com.changes.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiuJunJie
 * @since 2019/6/28 15:10
 */
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "getMenuList")
    public List<Menu> getMenuList(){
        return menuService.selectList();
    }
}

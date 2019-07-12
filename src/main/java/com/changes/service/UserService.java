package com.changes.service;

import com.changes.bean.User;

/**
 * @author LiuJunJie
 * @since 2019/7/1 15:37
 */
public interface UserService {

    /**
     * 根据username 查询用户信息
     * @param  userName
     * @return java.util.List<com.changes.bean.User>
     * @author LiuJunJie
     */
    User getUser(String userName);
}

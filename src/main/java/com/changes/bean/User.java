package com.changes.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import javax.persistence.*;

/**
 * @author LiuJunJie
 * @since 2019/6/28 16:18
 */
@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    @TableId
    private Integer id;

    @Column(name = "username")
    @TableField(value = "username")
    private String userName;

    @Column(name = "password")
    @TableField(value = "password")
    private String passWord;

    @Column(name = "email")
    @TableField(value = "email")
    private String email;

    @Column(name = "creator")
    @TableField(value = "creator")
    private Integer creator;

    @Column(name = "flag")
    @TableField(value = "flag")
    private Integer flag;

    @Column(name = "last_login_name")
    @TableField(value = "last_login_name")
    private String lastLoginTime;

    @Column(name = "update_user")
    @TableField(value = "update_user")
    private Integer updateUser;

    @Column(name = "update_time")
    @TableField(value = "update_time")
    private String updateTime;

    @Column(name = "depart_id")
    @TableField(value = "depart_id")
    private Integer departmentId;
}

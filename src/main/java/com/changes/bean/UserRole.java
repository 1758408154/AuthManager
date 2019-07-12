package com.changes.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * @author LiuJunJie
 * @since 2019/6/28 16:53
 */
@Entity
@Table(name = "user_role")
@Data
@TableName(value = "user_role")
public class UserRole {

    @Id
    @GeneratedValue
    @TableId
    private Integer id;

    @Column(name = "user_id")
    @TableField(value = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    @TableField(value = "role_id")
    private Integer roleId;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "create_time")
    @TableField(value = "create_time")
    private String creatTime;
}

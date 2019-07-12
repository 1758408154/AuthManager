package com.changes.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * @author LiuJunJie
 * @since 2019/6/28 16:57
 */
@Entity
@Table(name = "role_menu")
@Data
@TableName(value = "role_menu")
public class RoleMenu {


    @Id
    @GeneratedValue
    @TableId
    private Integer id;


    @Column(name = "role_id")
    @TableField(value = "role_id")
    private Integer roleId;

    @Column(name = "menu_id")
    @TableField(value = "menu_id")
    private Integer menuId;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "create_time")
    @TableField(value = "create_time")
    private String creatTime;
}

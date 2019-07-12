package com.changes.bean;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import javax.persistence.*;

/**
 * @author LiuJunJie
 * @since 2019/6/28 10:07
 */
@Data
@Entity
@Table(name = "menu")
public class Menu{

    @Id
    @TableId
    @GeneratedValue
    private Integer id;

    @Column(name="title",length = 32)
    private String title;

    @Column(name="url")
    private String url;

    @Column(name = "icon",length = 20)
    private String icon;

    @TableField(value = "menu_type")
    @Column(name = "menu_type")
    private String menuType;

    @Column(name="display")
    private Integer display;

    @TableField(value = "parent_id")
    @Column(name = "parent_id")
    private Integer parentId;

    @TableField(value = "create_time")
    @Column(name = "create_time")
    private String createTime;

    @TableField(value = "update_user_id")
    @Column(name = "update_user_id")
    private String updateUserId;

    @TableField(value = "update_time")
    @Column(name = "update_time")
    private String updateTime;

    @Column(name = "status")
    private Integer status;

}

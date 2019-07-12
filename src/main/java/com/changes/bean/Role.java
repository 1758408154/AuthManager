package com.changes.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import javax.persistence.*;

/**
 * @author LiuJunJie
 * @since 2019/6/28 16:06
 */
@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @TableId
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    @TableField(value = "create_time")
    private String createTime;

    @Column(name = "creator")
    @TableField(value = "creator")
    private Integer creator;

    @Column(name = "description")
    @TableField(value = "description")
    private String description;

    @Column(name = "update_user_id")
    @TableField(value = "update_user_id")
    private Integer updateUserId;

    @Column(name = "update_time")
    @TableField(value = "update_time")
    private String updateTime;

}

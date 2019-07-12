package com.changes.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import javax.persistence.*;

/**
 * @author LiuJunJie
 * @since 2019/6/28 17:00
 */
@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @TableId
    @GeneratedValue
    private Integer id;

    @Column(name = "depart_name")
    @TableField(value = "depart_name")
    private String departmentName;


    @Column(name = "create_time")
    @TableField(value = "create_time")
    private String createTime;

    @Column(name = "creator")
    @TableField(value = "creator")
    private Integer creator;

}

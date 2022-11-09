package com.example.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class PersonEntity {

    @TableId(value = "id")
    private String id;

    @TableField("user_name")
    private String userName;

    @TableField("user_password")
    private String userPassword;


    @TableField("age")
    private int age;

    @TableField("sex")
    private String sex;

    @TableField("create_time")
    private String createTime;

}

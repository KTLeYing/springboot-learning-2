package com.mzl.mybatisdemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * @ClassName :   Student
 * @Description: 学生实体类
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:47
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private int departmentId;
    private String name;
    private String sex;
    private int age;
    private String clazz;
    private String phone;
    private String address;

    //一对一
    private Department department;

}

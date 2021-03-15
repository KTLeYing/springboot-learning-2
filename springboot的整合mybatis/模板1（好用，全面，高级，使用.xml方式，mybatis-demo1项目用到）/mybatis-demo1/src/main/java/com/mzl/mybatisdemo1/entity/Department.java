package com.mzl.mybatisdemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.List;

/**
 * @ClassName :   Department
 * @Description: 学院实体类
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:48
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int id;
    private String departmentName;
    private String dean;
    private int hasYears;
    private String location;

    //一对多或多对多
    private List<Student> student;

}

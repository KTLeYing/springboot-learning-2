package com.mzl.mybatisdemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName :   Course
 * @Description: 课程实体类
 * @Author: mzl
 * @CreateDate: 2020/11/18 22:05
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer id;
    private String courseName;
    private int classHour;
    private int courseNum;
    private String teacherName;

    //多对多
    private List<Student> studentList;
}

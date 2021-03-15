package com.mzl.mybatisdemo1.service;

import com.mzl.mybatisdemo1.entity.Course;

import java.util.List;

/**
 * @InterfaceName :   CourseService
 * @Description: 课程业务逻辑类
 * @Author: mzl
 * @CreateDate: 2020/11/18 22:14
 * @Version: 1.0
 */
public interface CourseService {

    /**
     * 查询所有课程对应的所有的学生(多对多，其实就是和一对多实现是一样的，只是它有两个一对多而已)
     * @return
     */
    List<Course> findAllStuInCourse();
}

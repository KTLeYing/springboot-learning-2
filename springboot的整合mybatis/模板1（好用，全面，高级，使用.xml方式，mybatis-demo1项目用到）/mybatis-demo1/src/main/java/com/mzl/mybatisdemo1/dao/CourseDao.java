package com.mzl.mybatisdemo1.dao;

import com.mzl.mybatisdemo1.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName :   CourseDao
 * @Description: a课程dao
 * @Author: mzl
 * @CreateDate: 2020/11/18 22:16
 * @Version: 1.0
 */
@Mapper
public interface CourseDao {

    /**
     * 查询所有课程对应的所有的学生(多对多，其实就是和一对多实现是一样的，只是它有两个一对多而已)
     * @return
     */
    List<Course> findAllStuInCourse();
}

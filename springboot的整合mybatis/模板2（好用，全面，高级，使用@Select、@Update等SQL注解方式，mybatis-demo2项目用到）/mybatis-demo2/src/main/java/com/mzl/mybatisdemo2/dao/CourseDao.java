package com.mzl.mybatisdemo2.dao;

import com.mzl.mybatisdemo2.entity.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Select("select * from course")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),   //可以不配置这个，系统自动使用下划线驼峰式方式来映射
            //一对多（多对多）
            @Result(property = "studentList", column = "id", many = @Many(select = "com.mzl.mybatisdemo2.dao.StudentDao.findStuByCourseId", fetchType = FetchType.EAGER))
    })
    List<Course> findAllStuInCourse();
}

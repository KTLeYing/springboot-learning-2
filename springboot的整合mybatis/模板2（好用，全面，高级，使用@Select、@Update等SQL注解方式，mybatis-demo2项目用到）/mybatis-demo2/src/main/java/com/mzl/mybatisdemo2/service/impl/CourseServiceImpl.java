package com.mzl.mybatisdemo2.service.impl;

import com.mzl.mybatisdemo2.dao.CourseDao;
import com.mzl.mybatisdemo2.entity.Course;
import com.mzl.mybatisdemo2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName :   CourseServiceImpl
 * @Description: 课程业务逻辑实现类
 * @Author: mzl
 * @CreateDate: 2020/11/18 22:15
 * @Version: 1.0
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    /**
     * 查询所有课程对应的所有的学生(多对多，其实就是和一对多实现是一样的，只是它有两个一对多而已)
     * @return
     */
    @Override
    public List<Course> findAllStuInCourse() {
        return courseDao.findAllStuInCourse();
    }
}

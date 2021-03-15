package com.mzl.mybatisdemo2.service.impl;

import com.mzl.mybatisdemo2.dao.DepartmentDao;
import com.mzl.mybatisdemo2.entity.Department;
import com.mzl.mybatisdemo2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName :   DepatmentServiceImpl
 * @Description: 学院业务逻辑层
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:55
 * @Version: 1.0
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询某个学院的所有学生(一对多)
     * @param department
     * @return
     */
    @Override
    public Department findStuInDepartment(String department) {
        return departmentDao.findStuInDepartment(department);
    }


    /**
     * 查询所有学院的所有学生(一对多)
     * @return
     */
    @Override
    public List<Department> findAllStuInDepartment() {
        return departmentDao.findAllStuInDepartment();
    }
}

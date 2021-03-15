package com.mzl.mybatisdemo2.service;

import com.mzl.mybatisdemo2.entity.Department;

import java.util.List;

/**
 * @InterfaceName :   DepartmentService
 * @Description: 学院业务逻辑接口
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:54
 * @Version: 1.0
 */
public interface DepartmentService {

    /**
     * 查询某个学院的所有学生(一对多)
     * @param department
     * @return
     */
    Department findStuInDepartment(String department);

    /**
     * 查询所有学院的所有学生(一对多)
     * @return
     */
    List<Department> findAllStuInDepartment();
}

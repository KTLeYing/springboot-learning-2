package com.mzl.mybatisdemo1.dao;

import com.mzl.mybatisdemo1.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName :   DepartmentDao
 * @Description: 学院dao
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:54
 * @Version: 1.0
 */
@Mapper
public interface DepartmentDao {

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

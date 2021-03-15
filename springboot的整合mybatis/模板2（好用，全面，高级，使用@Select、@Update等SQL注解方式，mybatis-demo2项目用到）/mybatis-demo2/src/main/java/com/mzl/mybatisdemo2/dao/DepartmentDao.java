package com.mzl.mybatisdemo2.dao;

import com.mzl.mybatisdemo2.entity.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.omg.PortableInterceptor.INACTIVE;

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
    @Select("select * from department where department_name = #{department}")
    @Results({
            @Result(id= true, property = "id", column = "id"),
            @Result(property = "department_name", column = "departmentName"),
            @Result(property = "student", column = "id", many = @Many(select = "com.mzl.mybatisdemo2.dao.StudentDao.findStuByDeptId", fetchType = FetchType.EAGER))
    })
    Department findStuInDepartment(String department);

    /**
     * 查询所有学院的所有学生(一对多)
     * @return
     */
    @Select("select * from department")
    @Results({
            @Result(id= true, property = "id", column = "id"),
            @Result(property = "department_name", column = "departmentName"),
            //一对多（多对多）
            @Result(property = "student", column = "id", many = @Many(select = "com.mzl.mybatisdemo2.dao.StudentDao.findStuByDeptId", fetchType = FetchType.EAGER))
    })
    List<Department> findAllStuInDepartment();

    /**
     * 通过id来查询某个学院信息
     * @param
     * @return
     */
    @Select("select * from department where id = #{department_id}")
    @Results({
            @Result(property = "departmentName", column = "department_name"),
            @Result(property = "hasYears", column = "has_years")
    })
    Department findDeptById(Integer department_id);
}

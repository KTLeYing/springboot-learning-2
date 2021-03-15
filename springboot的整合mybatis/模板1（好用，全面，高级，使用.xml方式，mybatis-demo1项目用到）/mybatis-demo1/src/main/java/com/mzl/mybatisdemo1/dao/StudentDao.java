package com.mzl.mybatisdemo1.dao;

import com.mzl.mybatisdemo1.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName :   StudentDao
 * @Description: 学生dao
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:50
 * @Version: 1.0
 */
@Mapper
public interface StudentDao {

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    Student findById(Integer id);

    /**
     * 通过班级查询学生
     * @param clazz
     * @return
     */
    List<Student> findStuByClazz(String clazz);

    /**
     * 查询所有学生信息及其对应的学院信息（一对一）
     * @return
     */
    List<Student> findStuInfo();

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（where-if）
     * @param name
     * @param clazz
     * @return
     */
    List<Student> findStuByNameAndClass(String name, String clazz);

    /**
     * 更新学生信息（set-if）
     * @param student1
     * @return
     */
    Integer updateStu(Student student1);

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    Integer deleteStu(Integer id);

    /**
     * 根据id删除多个学生，批量删除（where-foreach）,前端的多个值用逗号隔开，表示一个数组
     * mybatis的collection也可以用list，但dao层要传list，这里是array，前端传一个a[]数组
     * @param ids
     * @return
     */
    Integer deleteMoreStu(Integer[] ids);

    /**
     * 添加学生
     * @param student
     * @return
     */
    Integer addStu(Student student);

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（trim代替where-if）
     * @param name
     * @param clazz
     * @return
     */
    List<Student> findStuByNameAndClass1(String name, String clazz);

    /**
     * 更新学生信息（trim代替set-if）
     * @param student1
     * @return
     */
    Integer updateStu1(Student student1);

}

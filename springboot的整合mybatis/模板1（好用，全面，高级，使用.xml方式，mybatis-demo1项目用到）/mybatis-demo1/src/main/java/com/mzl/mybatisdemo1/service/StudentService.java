package com.mzl.mybatisdemo1.service;

import com.mzl.mybatisdemo1.entity.Student;

import java.util.List;

/**
 * @InterfaceName :   StudentService
 * @Description: TODO
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:52
 * @Version: 1.0
 */
public interface StudentService {

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
     * @return
     */
    String updateStu(Student student);

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    String deleteStu(Integer id);

    /**
     * 根据id删除多个学生，批量删除（where-foreach）,前端的多个值用逗号隔开，表示一个数组
     * @param ids
     * @return
     */
    String deleteMoreStu(Integer[] ids);

    /**
     * 添加学生
     * @param student
     * @return
     */
    String addStu(Student student);

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（trim代替where-if）
     * @param name
     * @param clazz
     * @return
     */
    List<Student> findStuByNameAndClass1(String name, String clazz);

    /**
     * 更新学生信息（trim代替set-if）
     * @param student
     * @return
     */
    String updateStu1(Student student);


}

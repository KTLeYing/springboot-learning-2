package com.mzl.mybatisdemo1.service.impl;

import com.mzl.mybatisdemo1.dao.StudentDao;
import com.mzl.mybatisdemo1.entity.Student;
import com.mzl.mybatisdemo1.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName :   StudentServiceImpl
 * @Description: 学生业务逻辑实现类
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:52
 * @Version: 1.0
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    /**
     * 通过班级查询学生
     * @param clazz
     * @return
     */
    @Override
    public List<Student> findStuByClazz(String clazz) {
        return studentDao.findStuByClazz(clazz);
    }

    /**
     * 查询所有学生信息及其对应的学院信息（一对一）
     * @return
     */
    @Override
    public List<Student> findStuInfo() {
        return studentDao.findStuInfo();
    }

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（where-if）
     * @param name
     * @param clazz
     * @return
     */
    @Override
    public List<Student> findStuByNameAndClass(String name, String clazz) {
        return studentDao.findStuByNameAndClass(name, clazz);
    }

    /**
     * 更新学生信息（set-if）
     * @return
     */
    @Override
    public String updateStu(Student student) {
        //先使用id查询出学生
        Student student1 = studentDao.findById(student.getId());
        //把要改变的部门属性赋值给原来的对象对应的属性(student的属性赋值给student1对象)
        BeanUtils.copyProperties(student, student1);
        Integer num = studentDao.updateStu(student1);
        if(num > 0){
            return "更新学生成功";
        }else {
            return "更新学生信息失败";
        }
    }

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    @Override
    public String deleteStu(Integer id) {
        Integer num = studentDao.deleteStu(id);
        if (num > 0){
            return "删除学生成功";
        }else {
            return "删除学生失败";
        }
    }

    /**
     * 根据id删除多个学生，批量删除（where-foreach）,前端的多个值用逗号隔开，表示一个数组
     * mybatis的collection也可以用list，但dao层要传list，这里是array，前端传一个a[]数组
     * @param ids
     * @return
     */
    @Override
    public String deleteMoreStu(Integer[] ids) {
        Integer num = studentDao.deleteMoreStu(ids);
        if (num > 0){
            return "删除学生成功";
        }else {
            return "删除学生失败";
        }
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public String addStu(Student student) {
        Integer num = studentDao.addStu(student);
        if(num > 0){
            return "添加学生成功";
        }else {
            return "添加学生失败";
        }
    }

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（trim代替where-if）
     * @param name
     * @param clazz
     * @return
     */
    @Override
    public List<Student> findStuByNameAndClass1(String name, String clazz) {
        return studentDao.findStuByNameAndClass1(name, clazz);
    }

    /**
     * 更新学生信息（trim代替set-if）
     * @param student
     * @return
     */
    @Override
    public String updateStu1(Student student) {
        //先使用id查询出学生
        Student student1 = studentDao.findById(student.getId());
        //把要改变的部门属性赋值给原来的对象对应的属性(student的属性赋值给student1对象)
        BeanUtils.copyProperties(student, student1);
        Integer num = studentDao.updateStu1(student1);
        if(num > 0){
            return "更新学生成功";
        }else {
            return "更新学生信息失败";
        }
    }


}

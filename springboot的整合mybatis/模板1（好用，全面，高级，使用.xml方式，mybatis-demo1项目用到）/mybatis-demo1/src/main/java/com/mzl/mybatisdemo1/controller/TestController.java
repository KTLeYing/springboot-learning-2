package com.mzl.mybatisdemo1.controller;

import com.mzl.mybatisdemo1.entity.Course;
import com.mzl.mybatisdemo1.entity.Department;
import com.mzl.mybatisdemo1.entity.Student;
import com.mzl.mybatisdemo1.service.CourseService;
import com.mzl.mybatisdemo1.service.DepartmentService;
import com.mzl.mybatisdemo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName :   TestController
 * @Description: mybatis测试控制器
 * @Author: mzl
 * @CreateDate: 2020/11/17 21:47
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CourseService courseService;

    /**
     * 通过id查询学生
     * @param
     * @return
     */
    @RequestMapping("findStuById")
    public Student findStuById(Integer id){
        System.out.println(id);
        return studentService.findById(id);
    }

    /**
     * 通过班级查询学生
     * @param clazz
     * @return
     */
    @RequestMapping("findStuByClazz")
    public List<Student> findStuByClazz(String clazz){
        return studentService.findStuByClazz(clazz);
    }

    /**
     * 查询所有学生信息及其对应的学院信息（一对一）
     * @return
     */
    @RequestMapping("findStuInfo")
    public List<Student> findStuInfo(){
        return studentService.findStuInfo();
    }

    /**
     * 查询某个学院的所有学生(一对多)
     * @return
     */
    @RequestMapping("findStuInDepartment")
    public Department findStuInDepartment(String department){
        return departmentService.findStuInDepartment(department);
    }

    /**
     * 查询所有学院的所有学生(一对多)
     * @return
     */
    @RequestMapping("findAllStuInDepartment")
    public List<Department> findAllStuInDepartment(){
        return departmentService.findAllStuInDepartment();
    }

    /**
     * 查询所有课程对应的所有的学生(多对多，其实就是和一对多实现是一样的，只是它有两个一对多而已，双向的一对多)
     * @return
     */
    @RequestMapping("findStuInCourse")
    public List<Course> findAllStuInCourse(){
        return courseService.findAllStuInCourse();
    }

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（where-if）
     */
    @RequestMapping("findStuByNameAndClass")
    public List<Student> findStuByNameAndClass(String name, String clazz){
        return studentService.findStuByNameAndClass(name, clazz);
    }

    /**
     * 更新学生信息（set-if）
     * @return
     */
    @RequestMapping("updateStu")
    public String updateStu(Student student){
        return studentService.updateStu(student);
    }

    /**
     * 根据id删除多个学生，批量删除（where-foreach）,前端的多个值用逗号隔开，表示一个数组
     * mybatis的collection也可以用list，但dao层要传list，这里是array，前端传一个a[]数组
     */
    @RequestMapping("deleteMoreStu")
    public String deleteMoreStu(Integer[] ids){
        return studentService.deleteMoreStu(ids);
    }

    /**
     * 根据id删除学生
     */
    @RequestMapping("deleteStu")
    public String deleteStu(Integer id){
        return studentService.deleteStu(id);
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping("addStu")
    public String addStu(Student student){
        return studentService.addStu(student);
    }

    /**
     * 模糊查询，根据学生姓名和班级模糊查询（trim代替where-if）
     * @param name
     * @param clazz
     * @return
     */
    @RequestMapping("findStuByNameAndClass1")
    public List<Student> findStuByNameAndClass1(String name, String clazz){
        return studentService.findStuByNameAndClass1(name, clazz);
    }

    /**
     * 更新学生信息（trim代替set-if）
     * @return
     */
    @RequestMapping("updateStu1")
    public String updateStu1(Student student){
        return studentService.updateStu1(student);
    }


}

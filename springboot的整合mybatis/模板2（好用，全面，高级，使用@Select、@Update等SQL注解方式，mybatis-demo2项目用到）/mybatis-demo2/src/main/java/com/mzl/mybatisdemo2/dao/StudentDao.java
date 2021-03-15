package com.mzl.mybatisdemo2.dao;

import com.mzl.mybatisdemo2.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Select("select * from student where id = #{id}")
    @Results({   //mybatis已经开启了下划线驼峰式命名，不设置@Result的属性则会默认使用同名映射或者下划线驼峰式映射
            @Result(property = "clazz", column = "class"),
            @Result(property = "departmentId", column = "department_id")
    })
    //或（只对于一个映射）
//    @Result(property = "clazz", column = "class")
    Student findById(Integer id);

    /**
     * 通过班级查询学生
     * @param clazz
     * @return
     */
    @Select("select * from student where class = #{clazz}")
    @Results({
            @Result(property = "clazz", column = "class"),
            @Result(property = "departmentId", column = "department_id")
    })
    List<Student> findStuByClazz(String clazz);

    /**
     * 查询所有学生信息及其对应的学院信息(一对一)
     * @return
     */
    @Select("select * from student s")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "departmentId", column = "department_id"),
            @Result(property = "clazz", column = "class"),
            @Result(property = "address", column = "address"),
            //一对一关联,这个的column = "department_id"是作为findDeptById方法的实参，自动把column得到的department_id传给方法的里参数，参数名可以和department_id不一样
            @Result(property = "department", column = "department_id", one=@One(select = "com.mzl.mybatisdemo2.dao.DepartmentDao.findDeptById", fetchType = FetchType.EAGER))
    })
    List<Student> findStuInfo();


    /**
     * 模糊查询，根据学生姓名和班级模糊查询
     * @param name
     * @param clazz
     * @return
     */
    @Select("select * from student where name like concat('%', #{name}, '%') and class like concat('%', #{clazz}, '%')")
    @Results({
            @Result(property = "clazz", column = "class"),
            @Result(property = "departmentId", column = "department_id")
    })
    List<Student> findStuByNameAndClass(String name, String clazz);

    /**
     * 通过学院id来查询该学院所有的学生信息
     * @param id
     * @return
     */
    @Select("select * from student where department_id = #{id}")
    @Results({
            @Result(property = "clazz", column = "class"),
            @Result(property = "departmentId", column = "department_id")
    })
    List<Student> findStuByDeptId(Integer id);

    /**
     * 通过课程id来查询学习该课程所有的学生信息
     * @param id
     * @return
     */
    @Select("select s.* from student s, student_course sc where s.id = sc.student_id and sc.course_id = #{id}")
    @Results({
            @Result(property = "clazz", column = "class"),
            @Result(property = "departmentId", column = "department_id")
    })
    List<Student> findStuByCourseId(Integer id);


    /**
     * 更新学生信息
     * @param student1
     * @return
     */
    @Update("update student set department_id = #{departmentId}, name = #{name}, sex = #{sex}, age = #{age}, " +
            "class = #{clazz}, phone = #{phone}, address = #{address} where id = #{id}")
    Integer updateStu(Student student1);


    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    @Delete("delete from student where id = #{id}")
    Integer deleteStu(Integer id);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Insert("insert into student(department_id, name, sex, age, class, phone, address)" +
            " values(#{departmentId}, #{name}, #{sex}, #{age}, #{clazz}, #{phone}, #{address})")
    Integer addStu(Student student);

}

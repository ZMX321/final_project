package com.example.testspringhibernate.repository;

import com.example.testspringhibernate.pojo.dto.TeacherDTO;
import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.pojo.entity.Student_Teacher;
import com.example.testspringhibernate.pojo.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {

    List<Student> getAll();

    Student getStuById(String id);

    String insertStu(Student stu);

    void updateStu(Student stu);

    void deleteById(String id);

    List<Teacher> getTeaByStuId(String id);

    String insertStuAndTea(String sId, String tId);
}

package com.example.testspringhibernate.service;

import com.example.testspringhibernate.pojo.dto.StudentDTO;
import com.example.testspringhibernate.pojo.dto.TeacherDTO;
import com.example.testspringhibernate.pojo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    List<StudentDTO> getAllStu();

    StudentDTO getStuById(String id);

    String createNewStudent(Student s);

    void updateStuInfo(String id, Student s);

    void deleteStuById(String id);

    List<TeacherDTO> getTeaByStuId(String id);

    String insertStuAndTea(String s_id, String t_id);
}

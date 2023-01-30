package com.example.testspringhibernate.service.impl;

import com.example.testspringhibernate.exception.BusinessException;
import com.example.testspringhibernate.pojo.dto.StudentDTO;
import com.example.testspringhibernate.pojo.dto.TeacherDTO;
import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.pojo.entity.Student_Teacher;
import com.example.testspringhibernate.pojo.entity.Teacher;
import com.example.testspringhibernate.repository.StudentRepository;
import com.example.testspringhibernate.service.StudentService;

import com.example.testspringhibernate.utils.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStu() {
        List<StudentDTO> list = studentRepository.getAll().stream().map(stu -> new StudentDTO(stu)).collect(Collectors.toList());
        return list;
    }



    @Override
    public StudentDTO getStuById(String id) {
        return new StudentDTO(studentRepository.getStuById(id));
    }

//    public Student getByName(String firstName, String lastName){
//        Query query = entityManager.createQuery("select s from Student s where s.firstName = ?1 AND s.lastName = ?2");
//        query.setParameter(1, firstName);
//        query.setParameter(2, lastName);
//        Student e = (Student) query.getSingleResult();
//
//        return e;
//    }


    @Override
    public String createNewStudent(Student stu) {
        if(stu.getFirstName() == null || stu.getLastName() == null){
            throw new BusinessException(ErrorCode.WRONG_TYPE);
        }

        if(stu.getGender() == null){
            stu.setGender(0);
        }

        stu.setIsActive("1");
        stu.setIsDelete("0");
        stu.setCreateTime(new Date());
        stu.setUpdateTime(new Date());

        String newId = studentRepository.insertStu(stu);
        return newId;
    }

    @Override
    public void updateStuInfo(String id, Student stu) {
        Student toBeUpdate;
        try{
            toBeUpdate = studentRepository.getStuById(id);
        }catch(NoResultException e){
            log.error(e.fillInStackTrace().getMessage());
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        if(toBeUpdate.getIsDelete().equals("1")){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        //check which field is needed to be updated
        //otherwise keep the previous record
        if(stu.getFirstName() != null){
            toBeUpdate.setFirstName(stu.getFirstName());
        }

        if(stu.getLastName() != null){
            toBeUpdate.setLastName(stu.getLastName());
        }

        if(stu.getGender() != null){
            toBeUpdate.setGender(stu.getGender());
        }

        if(stu.getIsActive() != null){
            toBeUpdate.setIsActive(stu.getIsActive());
        }

        if(stu.getIsDelete() != null){
            toBeUpdate.setIsDelete(stu.getIsDelete());
        }

        toBeUpdate.setUpdateTime(new Date());

        studentRepository.updateStu(toBeUpdate);
    }

    @Override
    public void deleteStuById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<TeacherDTO> getTeaByStuId(String id) {

        List<TeacherDTO> list = studentRepository.getTeaByStuId(id).stream().map(tea -> new TeacherDTO(tea)).collect(Collectors.toList());
        return list;
    }

    @Override
    public String insertStuAndTea(String s_id, String t_id) {


        String newId = studentRepository.insertStuAndTea(s_id, t_id);

        return newId;
    }
}

package com.example.testspringhibernate.repository.impl;

import com.example.testspringhibernate.exception.BusinessException;
import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.pojo.entity.Student_Teacher;
import com.example.testspringhibernate.pojo.entity.Teacher;
import com.example.testspringhibernate.repository.StudentRepository;
import com.example.testspringhibernate.utils.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAll() {
        Query query = entityManager.createQuery("select s from Student s");
        List<Student> list = (List<Student>)query.getResultList();

        return list;
    }

    @Override
    public Student getStuById(String id) {
        Query query = entityManager.createQuery("select s from Student s where s.id = ?1");
        query.setParameter(1, id);

        Student s;
        try {
            s = (Student)query.getSingleResult();
        }catch (NoResultException e){
            log.error(e.fillInStackTrace().getMessage());
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        return s;
    }


    @Override
    @Transactional
    public String insertStu(Student stu){
        entityManager.persist(stu);
        return stu.getId();
    }

    @Override
    @Transactional
    public void updateStu(Student toBeUpdate) {
        entityManager.persist(toBeUpdate);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Student s;
        try{
            s = getStuById(id);
        }catch(NoResultException e){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        s.setIsDelete("1");
        entityManager.persist(s);
    }

    @Override
    public List<Teacher> getTeaByStuId(String id) {
        Query query = entityManager.createQuery("select s from Student s join fetch s.student_teacherList ts where s.id = ?1");
        query.setParameter(1, id);
        Student stu = (Student) query.getSingleResult();

        List<Student_Teacher> stList = stu.getStudent_teacherList();

        List<Teacher> list = new ArrayList<>();
        for(Student_Teacher st : stList){
            list.add(st.getTea());
        }

        return list;
    }

    @Override
    @Transactional
    public String insertStuAndTea(String sId, String tId) {
        Student stu = entityManager.find(Student.class, sId);
        Teacher tea = entityManager.find(Teacher.class, tId);


        Student_Teacher st = new Student_Teacher();
        st.setStu(stu);
        st.setTea(tea);

        entityManager.persist(st);

        return st.getId();
    }
}

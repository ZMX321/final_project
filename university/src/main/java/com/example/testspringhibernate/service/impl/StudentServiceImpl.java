package com.example.testspringhibernate.service.impl;

import com.example.testspringhibernate.exception.BusinessException;
import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.service.StudentService;

import com.example.testspringhibernate.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStu() {
        Query query = entityManager.createQuery("select s from Student s");
        List<Student> list = (List<Student>)query.getResultList();
        return list;
    }



    @Override
    public Student getStuById(String id) {
        Query query = entityManager.createQuery("select s from Student s where s.id = ?1");
        query.setParameter(1, id);

        //If no user get,
        // throw business exception with the null user code to the controller layer
        Student s;
        try{
            s = (Student)query.getSingleResult();
        }catch(NoResultException e){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        return s;
    }

    public Student getByName(String firstName, String lastName){
        Query query = entityManager.createQuery("select s from Student s where s.firstName = ?1 AND s.lastName = ?2");
        query.setParameter(1, firstName);
        query.setParameter(2, lastName);
        Student e = (Student) query.getSingleResult();

        return e;
    }


    @Override
    @Transactional
    public String createNewStudent(Student e) {

        Student toBeInsert = new Student();

        toBeInsert.setFirstName(e.getFirstName());
        toBeInsert.setLastName(e.getLastName());
        toBeInsert.setGender(e.getGender());
        toBeInsert.setIsActive("1");
        toBeInsert.setIsDelete("0");
        toBeInsert.setCreateTime(new Date());
        toBeInsert.setUpdateTime(new Date());


        entityManager.persist(toBeInsert);



        return toBeInsert.getId();
    }

    @Override
    @Transactional
    public void updateStuInfo(Student s) {


        //If no user get or user has been logic deleted,
        // throw business exception with the null user code to the controller layer
        Student toBeUpdate;
        try{
            toBeUpdate = getStuById(s.getId());
        }catch(NoResultException e){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        if(toBeUpdate.getIsDelete().equals("1")){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        //check which field is needed to be updated
        //otherwise keep the previous record
        if(s.getFirstName() != null){
            toBeUpdate.setFirstName(s.getFirstName());
        }

        if(s.getLastName() != null){
            toBeUpdate.setLastName(s.getLastName());
        }

        if(s.getGender() != null){
            toBeUpdate.setGender(s.getGender());
        }

        if(s.getIsActive() != null){
            toBeUpdate.setIsActive(s.getIsActive());
        }

        if(s.getIsDelete() != null){
            toBeUpdate.setIsDelete(s.getIsDelete());
        }

        toBeUpdate.setUpdateTime(new Date());

        entityManager.persist(toBeUpdate);
    }

    @Override
    @Transactional
    public void deleteStuById(String id) {
        Student s;
        try{
            s = getStuById(id);
        }catch(NoResultException e){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        //Logic delete,
        // only mark isDelete as 1 to show the user has been deleted
        s.setIsDelete("1");
        entityManager.persist(s);

        //physical delete
//        entityManager.remove(s);
    }
}

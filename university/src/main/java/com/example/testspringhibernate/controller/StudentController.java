package com.example.testspringhibernate.controller;


import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.service.StudentService;
import com.example.testspringhibernate.pojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity getAllStu(){
        return new ResponseEntity(new BaseResponse(studentService.getAllStu()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStuById(@PathVariable String id){
        return new ResponseEntity(new BaseResponse(studentService.getStuById(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity getTeaByStuId(@PathVariable String id){
        return new ResponseEntity(new BaseResponse(studentService.getTeaByStuId(id)), HttpStatus.OK);
    }

    @PostMapping("/{s_id}/teacher/{t_id}")
    public ResponseEntity insertStuAndTea(@PathVariable String s_id, @PathVariable String t_id){
        String newId = studentService.insertStuAndTea(s_id, t_id);
        return new ResponseEntity<>(new BaseResponse(newId), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity createNewStu(@RequestBody Student s){
        log.info(s.toString());
        String newId = studentService.createNewStudent(s);
        log.info("New User created with Id :" + newId);
        return new ResponseEntity(new BaseResponse(newId), HttpStatus.CREATED);
    }

    @PostMapping({"/{id}"})
    public ResponseEntity udpateStuInfo(@PathVariable String id, @RequestBody Student s){
        studentService.updateStuInfo(id, s);
        return new ResponseEntity(new BaseResponse(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStu(@PathVariable String id){
        studentService.deleteStuById(id);
        return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
    }





}

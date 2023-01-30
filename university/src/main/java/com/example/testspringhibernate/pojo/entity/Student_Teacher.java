package com.example.testspringhibernate.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "student_teacher")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student_Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @JoinColumn(name = "s_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Student stu;


    @JoinColumn(name = "t_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher tea;
}

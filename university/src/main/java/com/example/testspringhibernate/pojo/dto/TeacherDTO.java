package com.example.testspringhibernate.pojo.dto;

import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.pojo.entity.Teacher;
import lombok.Data;

@Data
public class TeacherDTO {

    private String id;

    private String fistName;

    private String lastName;

    public TeacherDTO(Teacher t) {
        this.id = t.getId();
        this.fistName = t.getFirstName();
        this.lastName = t.getLastName();
    }

}

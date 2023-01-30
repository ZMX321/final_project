package com.example.testspringhibernate.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_admin")
    private String isAdmin;

    @Column(name = "is_deleted")
    private String isDelete;

    @OneToMany(mappedBy = "tea", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Student_Teacher> student_teacherList;

    public List<Student_Teacher> getStudent_teacherList() {
        return student_teacherList;
    }

    public void setStudent_teacherList(List<Student_Teacher> student_teacherList) {
        this.student_teacherList = student_teacherList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isAdmin='" + isAdmin + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}

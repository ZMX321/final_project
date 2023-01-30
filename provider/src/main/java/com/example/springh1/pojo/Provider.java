package com.example.springh1.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Data
@Entity
@Table(name = "provider")
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotBlank(message = "first_name may not be blank")
    private String first_name;

    @Column
    @NotBlank(message = "last_name may not be blank")
    private String last_name;

    @Column
    private String middle_name;

    @Column
    private Date dob;

}

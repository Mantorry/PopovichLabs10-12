package com.example.posts.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Employee extends RepresentationModel<Employee> implements Serializable {
    private String emp_id;
    private String post_id;
    private String fio;
    private String birth_date;
    private String phone;
    private String email;
}


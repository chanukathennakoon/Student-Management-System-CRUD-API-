package com.example.studentmanagementsystem.Application.dto.request;


import lombok.Data;
@Data
public class CreateStudentDto {

    private String name;
    private String address;
    private String email;
    private Integer age;
}


package com.example.studentmanagementsystem.Application.dto.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}

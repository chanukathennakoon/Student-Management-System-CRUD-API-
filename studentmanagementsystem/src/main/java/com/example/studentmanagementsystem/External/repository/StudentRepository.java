package com.example.studentmanagementsystem.External.repository;

import com.example.studentmanagementsystem.Domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {
    Optional<Student> findByName(String name);
}
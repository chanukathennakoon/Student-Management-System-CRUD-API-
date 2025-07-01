package com.example.studentmanagementsystem.Application.controllers;

import com.example.studentmanagementsystem.Application.dto.request.CreateStudentDto;
import com.example.studentmanagementsystem.Application.dto.response.StudentGeneralDto;
import com.example.studentmanagementsystem.Domain.entity.Student;
import com.example.studentmanagementsystem.Domain.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@AllArgsConstructor

public class StudentController {

    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentGeneralDto> getStudent(@RequestParam Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentDto createStudentDto) {
       return studentService.addStudent(createStudentDto);
    }

    //@DeleteMapping("/students/{id}")
    //public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        //studentService.deleteStudent(id);
      //  return ResponseEntity.noContent().build();
   //

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam Integer id, @RequestParam String newName) {
        return studentService.updateStudent(id,newName);
    }

}

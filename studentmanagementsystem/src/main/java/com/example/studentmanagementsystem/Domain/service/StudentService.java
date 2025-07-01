package com.example.studentmanagementsystem.Domain.service;

import com.example.studentmanagementsystem.Application.dto.request.CreateStudentDto;
import com.example.studentmanagementsystem.Application.dto.response.StudentGeneralDto;
import com.example.studentmanagementsystem.Domain.entity.Student;
import com.example.studentmanagementsystem.Domain.exception.StudentNotFoundException;
import com.example.studentmanagementsystem.External.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<StudentGeneralDto> getStudent(Integer id) {
      StudentGeneralDto studentGeneralDto = new StudentGeneralDto();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = (Student) optionalStudent.get();
            studentGeneralDto.setId(student.getId());
            studentGeneralDto.setName(student.getName());
            studentGeneralDto.setAge(student.getAge());
            return ResponseEntity.ok(studentGeneralDto);
        } else {
            throw new StudentNotFoundException("Student not found");  // Not Found
        }
    }

    public ResponseEntity<Student> addStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setAddress(createStudentDto.getAddress());
        student.setEmail(createStudentDto.getEmail());
        student.setAge(createStudentDto.getAge());
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            throw new StudentNotFoundException("Student not found");  // Not Found
        }
    }

    public ResponseEntity<String> updateStudent(Integer id, String newName) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            log.info(" student found and the id is "+ id);
            Student student = optionalStudent.get();
            student.setName(newName);
            studentRepository.save(student);
            return ResponseEntity.ok("Student updated successfully");
        } else {
            throw new StudentNotFoundException("Student not found"); // Not Found
        }
    }
}

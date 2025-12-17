package com.example.demo.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImple implements StudentService  {
 

    // private final StudentRepository studentRepository;
    // public StudentServiceImple(StudentRepository studentRepository) {
    //     this.studentRepository = studentRepository;
    // }
 
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);// Saving student details using repository save method/ Ins
    

    }
}
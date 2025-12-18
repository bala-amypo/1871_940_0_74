package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Student;

public interface StudentService {

    Student save(Student student);

    List<Student> getAll();

    Student getById(Long id);

    void deletedata(Long id);
}

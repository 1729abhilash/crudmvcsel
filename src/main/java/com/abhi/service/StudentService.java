package com.abhi.service;

import com.abhi.api.Student;
import com.abhi.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<Student> loadStudent();
    void saveStudent(StudentDTO studentDTO);
    Student getStudentById(int id);
    void update(StudentDTO studentDTO);

    void deleteStudentById(int id);
}

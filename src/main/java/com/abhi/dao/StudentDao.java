package com.abhi.dao;

import com.abhi.api.Student;
import com.abhi.dto.StudentDTO;

import java.util.List;

public interface StudentDao {
    List<Student> loadStudents();
    void saveStudent(StudentDTO studentDTO);
    Student getStudentById(int id);
    void update(StudentDTO studentDTO);

    void deleteStudentById(int id);
}

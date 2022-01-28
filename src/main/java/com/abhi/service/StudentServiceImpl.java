package com.abhi.service;

import com.abhi.api.Student;
import com.abhi.dao.StudentDao;
import com.abhi.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> loadStudent() {
        List<Student> list=studentDao.loadStudents();
        return list;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        studentDao.saveStudent(studentDTO);
    }

    @Override
    public Student getStudentById(int id) {
        Student student=studentDao.getStudentById(id);
        return student;
    }

    @Override
    public void update(StudentDTO studentDTO) {
        studentDao.update(studentDTO);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
    }


}

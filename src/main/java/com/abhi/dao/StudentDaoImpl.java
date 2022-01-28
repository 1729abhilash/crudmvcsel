package com.abhi.dao;

import com.abhi.api.Student;
import com.abhi.dao.mapper.StudentRowMapper;
import com.abhi.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> loadStudents() {

        String sql="select * from Students";
       List<Student> studentList=jdbcTemplate.query(sql,new StudentRowMapper());
        return studentList;

    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
      //write the logic to storre hte student object into the database
      String query="insert into students (name,mobile,country)values(?,?,?)";
      Object[] sqlParameters=  {studentDTO.getName(),studentDTO.getMobile(),studentDTO.getCountry()};

       jdbcTemplate.update(query,sqlParameters);
        System.out.println("1 record got inserted");
    }

    @Override
    public Student getStudentById(int id) {
        String query="select * from Students where id=?";
        Student student=jdbcTemplate.queryForObject(query,new StudentRowMapper(),id);
        return student;
    }

    @Override
    public void update(StudentDTO studentDTO) {
      String sql="UPDATE STUDENTS SET name=?,mobile=?,country=? where id=?";
       jdbcTemplate.update(sql,studentDTO.getName(),studentDTO.getMobile(),studentDTO.getCountry(),studentDTO.getId());
        System.out.println("1 record updated");
    }

    @Override
    public void deleteStudentById(int id) {
        String sql="delete from students where id=?";
    jdbcTemplate.update(sql,id);
    }
}

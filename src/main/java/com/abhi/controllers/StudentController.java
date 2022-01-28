package com.abhi.controllers;

import com.abhi.api.Student;
import com.abhi.dao.StudentDao;
import com.abhi.dto.StudentDTO;
import com.abhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;
    //@RequestMapping(value="/showStudent",method= RequestMethod.GET)
   //or
    @GetMapping("/showStudents")
    public String showStudentsList(Model model){

     //   call the dao method the get the data
        List<Student> studentList=studentService.loadStudent();
      model.addAttribute("studentList", studentList);
          for(Student s:studentList)
              System.out.println(s);
      return "students-list";
    }

    @GetMapping("/showAddStudentPage")
    public String addStudent(Model model){
        StudentDTO studentDTO=new StudentDTO();
        model.addAttribute("student", studentDTO);
        return "add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(StudentDTO studentDTO){
        System.out.println(studentDTO.getId());
        //do a condition check
        //if the user doesn't have an id
        //if the user does have a id--> do a update
     if(studentDTO.getId()==null){
         //insert a new record
         studentService.saveStudent(studentDTO);

     }
     else{
         studentService.update(studentDTO);
     }
        //do a DAO call to save the students
       // studentDao.saveStudent(studentDTO);

        return "redirect:/showStudents";
    }

   @ResponseBody
    @GetMapping("/thankYou")
    public String thankYou(){
        return"Thank you.. your record has been added";
    }


    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("userId") int id,Model model){

     Student theStudent=studentService.getStudentById(id);
     model.addAttribute("student",theStudent);
     return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("userId") int id,Model model){
       studentService.deleteStudentById(id);
        return "redirect:/showStudents";
    }

}

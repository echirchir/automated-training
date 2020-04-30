package com.automated.training.controller;

import com.automated.training.model.Student;
import com.automated.training.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model){

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "students";
    }

    @GetMapping("/{id}")
    public String studentById(@PathVariable("id") Long id, Model model){
        Optional<Student> student = studentService.findById(id);

        model.addAttribute("student", student.get());

        return "student";
    }

    @PostMapping("/add")
    public String create(@Valid Student student){

        Student  saved = studentService.save(student);
        return "home";
    }
    //HTTP: GET, POST, PUT, PATCH, DELETE, UPDATE
}

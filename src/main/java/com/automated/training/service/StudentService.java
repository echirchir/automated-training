package com.automated.training.service;

import com.automated.training.model.Student;
import com.automated.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Optional<Student> findById(Long id){

        return repository.findById(id);
    }

    public Student save(Student student){

        return repository.save(student);
    }

    public void delete(Long id){

        repository.deleteById(id);
    }

    public List<Student> findAll(){

        return repository.findAll();
    }

    public Optional<Student> findByAge(int age){

        return repository.findByAge(age);
    }

}

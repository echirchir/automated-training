package com.automated.training.repository;

import com.automated.training.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByFeeBalance(double balance);
    Optional<Student> findByAge(int age);
    List<Student> findAllByIdDesc();
}

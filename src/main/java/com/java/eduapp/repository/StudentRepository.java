package com.java.eduapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.java.eduapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}

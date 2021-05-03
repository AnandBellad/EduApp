package com.java.eduapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.eduapp.entity.Student;
import com.java.eduapp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public Student addStudent(Student student) {
		return repository.save(student);
	}
	
	public List<Student> addStudents(List<Student> students) {
		return repository.saveAll(students);
	}

	public Student getStudentById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	/*
	 * public Student getStudentBySchoolName(String name) { return
	 * repository.findByName(name); }
	 */
	
	public Student updateStudent(Student student) {
		System.out.print("student:::" + student);
		Student existingStudent = repository.findById(student.getId()).orElse(null);
		existingStudent.setId(student.getId());
		existingStudent.setEmailId(student.getEmailId());
		existingStudent.setSchoolName(student.getSchoolName());
		existingStudent.setPhoneNo(student.getPhoneNo());
		return repository.save(student);
	}
	
	public String deleteStudent(int id) {
	 repository.deleteById(id);
	 return "Entry deleted for rollNum :" + id;
	}
}

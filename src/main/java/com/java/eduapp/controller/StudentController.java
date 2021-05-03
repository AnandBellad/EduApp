package com.java.eduapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.eduapp.entity.Student;
import com.java.eduapp.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@PostMapping("/addStudents")
	public  List<Student> addStudent(@RequestBody List<Student> students) {
		return service.addStudents(students);
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return service.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	/*
	 * @GetMapping("/getStudentsBySchoolName") public List<Student>
	 * getStudentBySchoolName(String name){ return
	 * service.getStudentBySchoolName(name); }
	 */
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		System.out.print("updateStudent::::" + student.getId());
		return service.updateStudent(student);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
}

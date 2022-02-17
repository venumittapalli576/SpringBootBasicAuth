package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> students = Arrays.asList(
			new Student(1, "venu"), new Student(2, "Mittapalli")
			);
	
	@GetMapping(path = "/{StudentId}")
	public Student getStudent(@PathVariable Integer StudentId) {
		return students.stream()
				.filter(student -> StudentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Student" + StudentId+ " does not exists"));
	}
}

package com.github.nodji.msstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.nodji.msstudents.model.entity.StudentEntity;
import com.github.nodji.msstudents.model.request.StudentRequest;
import com.github.nodji.msstudents.service.StudentService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("students")
@Slf4j
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public String status() {
		log.info("Status verify of Students microservices.");
		return "Ok";
	}

	@PostMapping("/create")
	public ResponseEntity<StudentEntity> create(@RequestBody StudentRequest request) {
		StudentEntity entity = StudentEntity.builder().name(request.name()).code(request.code()).email(request.email()).age(request.age()).build(); 
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(entity));
	}
	
	@GetMapping(params = "code")
	public ResponseEntity<StudentEntity> getByCode(@RequestParam String code) {
		var student = studentService.findByCode(code);
		if (student.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student.get());
	}
	
}

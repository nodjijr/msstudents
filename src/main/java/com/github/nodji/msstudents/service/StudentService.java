package com.github.nodji.msstudents.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nodji.msstudents.model.entity.StudentEntity;
import com.github.nodji.msstudents.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Transactional
	public StudentEntity save(StudentEntity student) {
		return repository.save(student);
	}
	
	public Optional<StudentEntity> findByCode(String code) {
		return repository.findByCode(code);
	}	
}

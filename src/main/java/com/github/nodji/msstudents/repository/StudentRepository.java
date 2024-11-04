package com.github.nodji.msstudents.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.nodji.msstudents.model.entity.StudentEntity;

public interface StudentRepository extends  JpaRepository<StudentEntity, UUID>{

	Optional<StudentEntity> findByCode(String code);
	

}

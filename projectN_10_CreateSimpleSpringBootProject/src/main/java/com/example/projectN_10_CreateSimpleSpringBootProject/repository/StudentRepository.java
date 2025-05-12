package com.example.projectN_10_CreateSimpleSpringBootProject.repository;

import com.example.projectN_10_CreateSimpleSpringBootProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

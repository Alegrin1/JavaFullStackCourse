package com.example.projectN_11_BuildASpringBootAPIForATaskManagementSystem.repository;

import com.example.projectN_11_BuildASpringBootAPIForATaskManagementSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}

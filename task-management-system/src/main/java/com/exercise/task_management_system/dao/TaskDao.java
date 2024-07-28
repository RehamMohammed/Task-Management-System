package com.exercise.task_management_system.dao;

import com.exercise.task_management_system.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {

}

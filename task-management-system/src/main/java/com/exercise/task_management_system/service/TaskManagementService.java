package com.exercise.task_management_system.service;

import com.exercise.task_management_system.dao.TaskDao;
import com.exercise.task_management_system.entity.Task;
import com.exercise.task_management_system.model.TaskModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TaskManagementService {

    private TaskDao taskDao;
    public TaskManagementService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public Task createTask (TaskModel taskModel){
        Task task = constructTaskEntity(taskModel);
        return taskDao.save(task);
    }

    private Task constructTaskEntity(TaskModel taskModel){
        Task task = new Task();
        task.setTitle(taskModel.getTitle());
        task.setDescription(taskModel.getDescription());
        task.setStatus(taskModel.getStatus());
        task.setPriority(taskModel.getPriority());
        task.setDueDate(LocalDate.parse(taskModel.getDueDate()));
        return task;
    }

    public Task getTaskById(Integer id){
        return taskDao.findById(id).orElseThrow();
    }

    public Task updateTask(Integer id, TaskModel taskModel){
       Task task = taskDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Task Not fount with id "+ id));
        task.setTitle(taskModel.getTitle());
        task.setDescription(taskModel.getDescription());
        task.setStatus(taskModel.getStatus());
        task.setPriority(taskModel.getPriority());
        task.setDueDate(LocalDate.parse(taskModel.getDueDate()));
       return taskDao.save(task);
    }

    public void deleteTaskById(Integer id){
        Task task = taskDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Task Not fount with id "+ id));
        taskDao.delete(task);
    }
}

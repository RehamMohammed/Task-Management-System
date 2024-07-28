package com.exercise.task_management_system.controller;
import com.exercise.task_management_system.entity.Task;
import com.exercise.task_management_system.model.TaskModel;
import com.exercise.task_management_system.service.TaskManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskManagementController {
    private final TaskManagementService taskManagementService;
    public TaskManagementController(TaskManagementService taskManagementService) {
        this.taskManagementService = taskManagementService;
    }
    @PostMapping("/create")
    ResponseEntity<Task> createTask(@RequestBody TaskModel taskModel){
        return ResponseEntity.ok(taskManagementService.createTask(taskModel));
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Integer id){
        return ResponseEntity.ok(taskManagementService.getTaskById(id));
    }

    @PostMapping("/update/{id}")
    ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody TaskModel taskModel){
        return ResponseEntity.ok(taskManagementService.updateTask(id, taskModel));
    }

    @DeleteMapping("/delete/{id}")
    void deleteTaskById(@PathVariable Integer id){
        taskManagementService.deleteTaskById(id);
    }
}

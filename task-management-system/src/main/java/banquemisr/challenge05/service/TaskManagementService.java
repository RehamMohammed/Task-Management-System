package banquemisr.challenge05.service;

import banquemisr.challenge05.entity.Task;
import banquemisr.challenge05.model.TaskModel;
import banquemisr.challenge05.dao.TaskDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

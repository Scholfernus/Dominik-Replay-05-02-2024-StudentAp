package com.example.student.service;

import com.example.student.model.TaskModel;
import com.example.student.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(TaskModel taskModel) {
        taskRepository.save(taskModel);
    }

    public List<TaskModel> getTaskList() {
        return taskRepository.findAll();
    }

    public TaskModel getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<TaskModel> findByColor(String name) {
        List<TaskModel> color = taskRepository.findByColor(name);
        log.info("color {}", color);
        return color;
    }
    public void updateTaskDescription(Long id, String description){
         taskRepository.updateDescriptionById(id, description);
    }
}

package com.example.student.controller;

import com.example.student.model.StudentModel;
import com.example.student.model.TaskModel;
import com.example.student.service.StudentService;
import com.example.student.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {


    private final StudentService studentService;
    private final TaskService taskService;


    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        List<TaskModel> list = taskService.getTaskList();
        model.addAttribute("taskModel", list);
        return "tasks/tasks";
    }


    @GetMapping("/addTask")
    public String getAddTask(Model model) {
        List<StudentModel> list = studentService.getStudentList();
        model.addAttribute("studentModel", list);
        return "tasks/addTask";
    }


    @PostMapping("/addTask")
    public RedirectView postAddTask(TaskModel task) {
        taskService.saveTask(task);
        return new RedirectView("/tasks");
    }


    @GetMapping("/editTask/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        List<StudentModel> list = studentService.getStudentList();
        TaskModel task = taskService.getTaskById(id);
        model.addAttribute("studentModel", list);
        model.addAttribute("taskModel", task);
        return "tasks/editTask";
    }


    @GetMapping("/byColor/{name}")
    public String getColor(@PathVariable String name) {
        taskService.findByColor(name);
        return "tasks/editTask";
    }


    @PatchMapping("/editDescription/{id}")
    public RedirectView patchDescription(@PathVariable("id") Long id,
                                         @RequestParam String description) {
        taskService.updateTaskDescription(id, description);
        return new RedirectView("/tasks");
    }


}

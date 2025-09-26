package br.com.lucas.service.tasks.controller;

import br.com.lucas.service.tasks.model.Task;
import br.com.lucas.service.tasks.model.TaskRequest;
import br.com.lucas.service.tasks.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }


}

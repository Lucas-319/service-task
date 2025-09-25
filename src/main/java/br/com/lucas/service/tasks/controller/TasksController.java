package br.com.lucas.service.tasks.controller;

import br.com.lucas.service.tasks.model.Tasks;
import br.com.lucas.service.tasks.model.TasksDto;
import br.com.lucas.service.tasks.repository.TasksRepository;
import br.com.lucas.service.tasks.service.TasksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody TasksDto task) {
        return ResponseEntity.ok(tasksService.createTask(task));
    }


}

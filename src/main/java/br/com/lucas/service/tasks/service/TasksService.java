package br.com.lucas.service.tasks.service;

import br.com.lucas.service.tasks.model.Tasks;
import br.com.lucas.service.tasks.model.TasksDto;
import br.com.lucas.service.tasks.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Tasks createTask(TasksDto dto) {
        Tasks taskToSave = new Tasks(dto.title(), dto.dueDate());
        return tasksRepository.save(taskToSave);
    }
}

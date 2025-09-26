package br.com.lucas.service.tasks.service;

import br.com.lucas.service.tasks.model.Tasks;
import br.com.lucas.service.tasks.model.TasksDto;
import br.com.lucas.service.tasks.repository.TasksRepository;
import br.com.lucas.service.tasks.util.NotificationClient;
import br.com.lucas.service.tasks.util.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;
    private final NotificationClient notificationClient;

    public TasksService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public Tasks createTask(TasksDto dto) {
        Tasks taskToSave = new Tasks(dto.title(), dto.email(), dto.dueDate());
        return tasksRepository.save(taskToSave);
    }

    public void sendNotificationForDueTasks() {
        LocalDate deadLine = LocalDate.now().plusDays(1);
        List<Tasks> tasks = tasksRepository.findTasksDueWithinDeadLine(deadLine);
        tasks.forEach(task -> {
            NotificationRequest request = new NotificationRequest("Sua tarefa: " + task.getTitle() + " está prestes a vencer!", task.getEmail());
            notificationClient.sendNotification(request);
            task.setNotified(true);
            tasksRepository.save(task);
        });
    }
}

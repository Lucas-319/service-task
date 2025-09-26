package br.com.lucas.service.tasks.service;

import br.com.lucas.service.tasks.model.Task;
import br.com.lucas.service.tasks.model.TaskRequest;
import br.com.lucas.service.tasks.repository.TasksRepository;
import br.com.lucas.service.tasks.util.NotificationClient;
import br.com.lucas.service.tasks.util.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TasksRepository tasksRepository;
    private final NotificationClient notificationClient;

    public TaskService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public Task createTask(TaskRequest taskRequest) {
        Task taskToSave = new Task(taskRequest);
        return tasksRepository.save(taskToSave);
    }

    public void sendNotificationForDueTasks() {
        LocalDate deadLine = LocalDate.now().plusDays(1);
        List<Task> tasks = tasksRepository.findTasksDueWithinDeadLine(deadLine);
        tasks.forEach(task -> {
            NotificationRequest request = new NotificationRequest("Sua tarefa: " + task.getTitle() + " está prestes a vencer!", task.getEmail());
            notificationClient.sendNotification(request);
            task.setNotified(true);
            tasksRepository.save(task);
        });
    }
}

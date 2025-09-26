package br.com.lucas.service.tasks.scheduling;

import br.com.lucas.service.tasks.service.TasksService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskNotificationSchedule {

    private final TasksService tasksService;

    public TaskNotificationSchedule(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Scheduled(fixedRate = 60000)
    public void checkAndNotityTasks() {
        log.info("Verificar tarefas próximas do vencimento e enviar notificação caso alguma seja encontrada.");
        this.tasksService.sendNotificationForDueTasks();
    }
}

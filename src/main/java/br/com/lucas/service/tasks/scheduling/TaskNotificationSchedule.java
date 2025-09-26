package br.com.lucas.service.tasks.scheduling;

import br.com.lucas.service.tasks.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskNotificationSchedule {

    private final TaskService taskService;

    public TaskNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 60000)
    public void checkAndNotityTasks() {
        log.info("Verificar tarefas próximas do vencimento e enviar notificação caso alguma seja encontrada.");
        this.taskService.sendNotificationForDueTasks();
    }
}

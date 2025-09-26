package br.com.lucas.service.tasks.repository;

import br.com.lucas.service.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Tasks t WHERE t.dueDate <= :deadLine AND t.notified = false")
    List<Task> findTasksDueWithinDeadLine(LocalDate deadLine);
}

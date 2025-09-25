package br.com.lucas.service.tasks.repository;

import br.com.lucas.service.tasks.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

    @Query("SELECT t FROM Tasks t WHERE t.dueDate <= :deadLine AND t.notified = false")
    List<Tasks> findTasksDueWithinDeadLine(LocalDate deadLine);
}

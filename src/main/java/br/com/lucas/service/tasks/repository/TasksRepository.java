package br.com.lucas.service.tasks.repository;

import br.com.lucas.service.tasks.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
}

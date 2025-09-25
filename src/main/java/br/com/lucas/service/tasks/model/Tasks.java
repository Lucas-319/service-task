package br.com.lucas.service.tasks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Tasks")
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String email;
    private LocalDate dueDate;
    private boolean notified = false;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Tasks(String title, String email, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }
}
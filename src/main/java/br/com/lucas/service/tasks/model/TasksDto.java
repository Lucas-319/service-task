package br.com.lucas.service.tasks.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TasksDto(String title, String email, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dueDate) {
}
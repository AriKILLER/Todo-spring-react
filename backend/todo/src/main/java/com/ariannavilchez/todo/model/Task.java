package com.ariannavilchez.todo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type")
    private TaskType type; //Note, Reminder, List

    private Integer priority;
    private Boolean completed=false;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @ManyToOne
    private User user;

}

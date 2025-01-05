package com.example.Taskslist.Tasks;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Taskentity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "task_name",nullable = false)
    private String Taskname;

    @Column(name = "task_progress",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status Tasksprogress;

    @Column(name = "Created_at",updatable = false)
    private LocalDateTime createdat;

    @Column(name = "Updated_at")
    private LocalDateTime updatedat;


    // when the entity is getting saved in a database this below function will called
    @PrePersist
    protected void Addcreate(){
        this.createdat = LocalDateTime.now();
        this.updatedat = LocalDateTime.now();
    }

    // whenever the entity is updating when ever the newdata is getting added or some data modiefied
    @PreUpdate
    protected void Updatingdata(){
        this.updatedat = LocalDateTime.now();
    }


}

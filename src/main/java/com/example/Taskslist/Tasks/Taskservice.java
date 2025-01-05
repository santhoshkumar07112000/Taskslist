package com.example.Taskslist.Tasks;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface Taskservice{

    List<Taskentity> getTasks();

    ResponseEntity<String> addTasks(TaskDTO taskDTO);

    ResponseEntity<String> deleteTasks(Long Id);

    ResponseEntity<String> updateTasks(Long Id,TaskDTO taskDTO);
}

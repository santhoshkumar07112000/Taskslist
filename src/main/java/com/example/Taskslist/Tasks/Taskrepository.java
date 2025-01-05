package com.example.Taskslist.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepository extends JpaRepository<Taskentity,Long>{
    
}

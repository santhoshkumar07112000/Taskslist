package com.example.Taskslist.Tasks;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Taskserviceimpl implements Taskservice {

    public final Taskrepository taskrepository;
    
    public Taskserviceimpl(Taskrepository taskrepository){
        this.taskrepository = taskrepository;
    }

    @Override
    public List<Taskentity> getTasks(){
        return taskrepository.findAll();
    }
    

    @Override
    public ResponseEntity<String> addTasks(TaskDTO taskDTO){

        try {

            if (taskDTO.getTaskname() == null || taskDTO.getTaskname().isEmpty()) {
                return ResponseEntity.badRequest().body("Task name cannot be null or empty");
            }
            if (taskDTO.getTasksprogress() == null) {
                return ResponseEntity.badRequest().body("Task progress cannot be null");
            }

            Taskentity taskentity = new Taskentity();

            taskentity.setTaskname(taskDTO.getTaskname());
            taskentity.setTasksprogress(taskDTO.getTasksprogress());

            taskrepository.save(taskentity);

            return ResponseEntity.ok().body("Task created successfully");
            
        } catch (Exception e) {
            
            return ResponseEntity.badRequest().body(e+"");
        }

    }


    @Override
    public ResponseEntity<String> deleteTasks(Long Id){
        try {
            
            taskrepository.deleteById(Id);

            return ResponseEntity.ok().body("data deleted successfully");

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(e+"");
        }
    }


    @Override
    public ResponseEntity<String> updateTasks(Long Id,TaskDTO taskDTO){
        try {

         Optional<Taskentity> taskentity = taskrepository.findById(Id);

         if(taskentity.isPresent()){

            Taskentity existingTasks = taskentity.get();

            existingTasks.setTaskname(taskDTO.getTaskname());
            existingTasks.setTasksprogress(taskDTO.getTasksprogress());


            taskrepository.save(existingTasks);

            return ResponseEntity.ok().body("data updated successfully");

         } else {
            return ResponseEntity.badRequest().body("invalid id");
         }

            
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(e+"");
        }
    }
   
}

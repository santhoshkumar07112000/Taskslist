package com.example.Taskslist.Tasks;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Taskslist.Response.Errorresponse;
import com.example.Taskslist.Response.Successresponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class Taskcontroller {

    public final Taskservice taskservice;

    public Taskcontroller(Taskservice taskservice) {
        this.taskservice = taskservice;
    }

    @GetMapping("/getTasks")
    public ResponseEntity<Object> getTasks() {
        // Fetch the list of tasks from the service

        try {

            List<Taskentity> responseData = taskservice.getTasks();

            if (responseData.size() > 0) {

                // Create a success response object
                Successresponse success = new Successresponse("Data fetched successfully", 200, responseData);

                // Return the success response
                return ResponseEntity.ok().body(success);
            } else {

                Errorresponse error = new Errorresponse("There is no data available", 404);

                return ResponseEntity.status(404).body(error);

            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e + "");
        }

    }

    @PostMapping("/addTasks")
    public ResponseEntity<String> addTasks(@RequestBody TaskDTO taskDTO) {
       try {

        // System.out.println(taskDTO.values());
        return taskservice.addTasks(taskDTO);
            
       } catch (Exception e) {
       
        return ResponseEntity.badRequest().body(e+"");
       }
    }
    


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTasks(@PathVariable Long id){
        return taskservice.deleteTasks(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTasks(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        //TODO: process PUT request
        return taskservice.updateTasks(id,taskDTO);
    }

}

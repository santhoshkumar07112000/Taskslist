package com.example.Taskslist.Response;

import java.util.List;

import com.example.Taskslist.Tasks.Taskentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Successresponse {

    private String message;
    private int status;
    private Object data;

    // Constructor with message, status, and data
    // public Successresponse(String message, int status, List<Taskentity> data) {
    //     this.message = message;
    //     this.status = status;
    //     this.data = data;
    // }


}

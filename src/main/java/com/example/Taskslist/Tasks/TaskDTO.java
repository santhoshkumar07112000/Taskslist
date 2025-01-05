package com.example.Taskslist.Tasks;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private String taskname;
    private Status tasksprogress;

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public Status getTasksprogress() {
        return tasksprogress;
    }

    public void setTasksprogress(Status tasksprogress) {
        this.tasksprogress = tasksprogress;
    }
}

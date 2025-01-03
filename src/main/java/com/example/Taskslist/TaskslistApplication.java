package com.example.Taskslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskslistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskslistApplication.class, args);
		System.out.println("*****************************");
		System.out.println("server running on the port 8470");
		System.out.println("*****************************");
	}

}

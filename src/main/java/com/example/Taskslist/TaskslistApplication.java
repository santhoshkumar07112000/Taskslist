package com.example.Taskslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
@RestController
public class TaskslistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskslistApplication.class, args);
		System.out.println("*****************************");
		System.out.println("server running on the port 8470");
		System.out.println("*****************************");
	}


	@GetMapping("/")
	public String Welcome() {
		return "welcome to our application";
	}
	
	
}

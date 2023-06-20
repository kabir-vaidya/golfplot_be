package com.golfplot.api;

import com.golfplot.api.exception.CustomExceptionHandler;
import com.golfplot.api.level.LevelController;
import com.golfplot.api.student.Student;
import com.golfplot.api.student.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.golfplot.api")
@ComponentScan(basePackageClasses = {
		StudentController.class,
		CustomExceptionHandler.class,
		LevelController.class
})
public class GolfplotApplication {
	public static void main(String[] args) {
		SpringApplication.run(GolfplotApplication.class, args);
	}

}

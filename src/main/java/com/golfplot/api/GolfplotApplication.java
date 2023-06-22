package com.golfplot.api;

import com.golfplot.api.exception.CustomExceptionHandler;
import com.golfplot.api.level.LevelController;
import com.golfplot.api.score.Score;
import com.golfplot.api.score.ScoreController;
import com.golfplot.api.student.Student;
import com.golfplot.api.student.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.golfplot.api")
@ComponentScan(basePackageClasses = {
		StudentController.class,
		ScoreController.class,
		CustomExceptionHandler.class,
		LevelController.class
})
public class GolfplotApplication {
	public static void main(String[] args) {
		try{
			SpringApplication.run(GolfplotApplication.class, args);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}

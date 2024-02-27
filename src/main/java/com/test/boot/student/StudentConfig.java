package com.test.boot.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repo) {
		return args -> {
			Student yazan = new Student(
					"yazan",
					"yazan@gmail.com",
					LocalDate.of(2002, 3, 20)
			);
			
			Student ahmed = new Student(
					"ahmed",
					"ahmed@gmail.com",
					LocalDate.of(2001, 3, 20)
			);
			
			repo.saveAll( List.of(yazan, ahmed) );
		};
	}
	
}

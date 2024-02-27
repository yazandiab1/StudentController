package com.test.boot.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepo;
	
	@Autowired
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public List<Student> getStudents() {
		return studentRepo.findAll(); 
	}
	
	public void addNewStudent(Student student) {
		 Optional<Student> studentByEmail = studentRepo.findStudentByEmail( student.getEmail() );
		if ( studentByEmail.isPresent() ) {
			throw new IllegalStateException("this email was taken");
		}
		
		studentRepo.save( student );
		
	}
	
	public void deleteStudent(Long studentId) {
		boolean exists = studentRepo.existsById( studentId );
		
		if ( !exists ) {
			throw new IllegalStateException("there is no student has id:" + studentId);
		}
		
		studentRepo.deleteById( studentId );
	}
	
}

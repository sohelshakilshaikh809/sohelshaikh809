package com.ATDevTechnologies.AtDeveTechnologies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ATDevTechnologies.AtDeveTechnologies.Entity.Student;
import com.ATDevTechnologies.AtDeveTechnologies.Repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/student")
	public String insertStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "Your Records Save Successfully";
	}
	
	
	@GetMapping("/getById/{studentId}")
	public Student getStudent(@PathVariable("studentId") long id){
		return studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found with Id: "+id));
	}
	
	@PutMapping("/updateStudent/{studentId}")
	public Student UpdateProduct(@RequestBody Student student,@PathVariable("studentId") long id) {
		Student studentexist = studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found with Id: "+id));
		studentexist.setName(student.getName());
		studentexist.setStd(student.getStd());
		studentexist.setDiv(student.getDiv());
		return studentRepo.save(studentexist);
			}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<Student> DeleteStudent(@RequestBody Student student,@PathVariable("studentId") long id) {
		Student studentexist = studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found with Id: "+id));
		studentRepo.delete(studentexist);
	    return ResponseEntity.ok().build();
	}
}

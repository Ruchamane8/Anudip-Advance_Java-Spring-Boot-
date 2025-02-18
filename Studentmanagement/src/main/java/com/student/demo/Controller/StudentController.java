package com.student.demo.Controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Student;

@RestController
public class StudentController {
	
	private Map<Long, Student> mystudent = new HashMap<>();
	
	@GetMapping("/getall")
	public List<Student> getAll(){
		return new ArrayList<>(mystudent.values());
	}
	
	@PostMapping("/register")
	public boolean createEntry(@RequestBody Student student) {
		mystudent.put(student.getId(), student);
		return true;
		
	}
	
	@GetMapping("id/{myId}")
	public Student getStudentById(@PathVariable Long myId) {
		return mystudent.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public Student deleteStudentById(@PathVariable Long myId) {
		return mystudent.remove(myId);
	}
	
	@PutMapping("update/{myId}")
	public Student updateStudentById(@PathVariable Long myId, @RequestBody Student student) {
		return mystudent.put(myId, student);
	}
	
	
	@GetMapping
	public String healthCHeck() {
		return "Site Health Ok";
	}
}

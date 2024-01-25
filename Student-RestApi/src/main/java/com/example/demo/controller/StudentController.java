package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.EndPoints;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = EndPoints.STUDENT_ROOT_MAPPING)
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping(value = EndPoints.GET_ALL_STUDENTS)
	public ResponseEntity<Object> getAllStudents()
	{
		List<Student> studentList = service.getAllStudents();
		if (studentList != null)
		{
			return new ResponseEntity<Object>(studentList,HttpStatus.OK);
		} else 
		{
			return new ResponseEntity<Object>("List Is empty",HttpStatus.CONFLICT);
		}
	
		
	}
	
	@PostMapping(value = EndPoints.ADD_STUDENT)
	public ResponseEntity<Object>  addStudent(@RequestBody Student student)
	{
		
		int status = service.addStudent(student);
		 if (status == 1) {
		        return new ResponseEntity<Object>("Student added successfully", HttpStatus.ACCEPTED);
		    } else if (status == 2) {
		        return new ResponseEntity<Object>("Student object is null", HttpStatus.BAD_REQUEST);
		    } else {
		        return new ResponseEntity<Object>("Failed to add student", HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
	
	@PostMapping(value = EndPoints.UPDATE_STUDENT)
	public ResponseEntity<Object>  updateStudent(@PathVariable long studentId,@RequestBody Student student) 
	{
		int status = service.updateStudent(studentId,student);
		
		if (status == 1) 
		{
			return new ResponseEntity<Object>("student updated",HttpStatus.ACCEPTED); 
		} 
		
		else 
		{
			return new ResponseEntity<Object>("student not found with given Id to update",HttpStatus.BAD_GATEWAY);
		}
		
		
	}
	@DeleteMapping(value = EndPoints.DELETE_STUDENT)
	public ResponseEntity<Object>  deleteStudent(@PathVariable long studId)
	{
		int status = service.deleteStudent(studId);
		
		if (status == 1)
		{
		 return new ResponseEntity<Object>("student deleted successfully",HttpStatus.OK);	
		} 
		else 
		{
			return new ResponseEntity<Object>("student not found with given Id to delete",HttpStatus.NOT_FOUND);
		}
		
		
		
	}
}

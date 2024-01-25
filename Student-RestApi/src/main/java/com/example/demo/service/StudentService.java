package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public int addStudent(Student student);
	
	public int deleteStudent(long studentId);
	
	public int updateStudent(long studentId,Student student);
	
	
}

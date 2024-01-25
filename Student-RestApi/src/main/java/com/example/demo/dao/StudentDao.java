package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDao {

	public List<Student> getStudentAllStudents();
	
	public int addStudent(Student student);
	
	public int deleteStudent(long studentId);
	
	public int updateStudent(long studentId,Student student);
}

package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;
	
	@Override
	public List<Student> getAllStudents() {
		return dao.getStudentAllStudents();
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.addStudent(student);
	}

	@Override
	public int deleteStudent(long studentId) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(studentId);
	}

	@Override
	public int updateStudent(long studentId,Student student) {
		// TODO Auto-generated method stub
		return dao.updateStudent(studentId,student);
	}

	
}

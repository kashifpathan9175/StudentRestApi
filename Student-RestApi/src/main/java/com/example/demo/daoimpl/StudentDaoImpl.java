package com.example.demo.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

import jakarta.persistence.criteria.Root;
import jakarta.validation.UnexpectedTypeException;
import java.util.Collections;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	SessionFactory factory;

	@Override
	public List<Student> getStudentAllStudents() {
		
		try (Session session=factory.openSession())
		{
			 HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

	            JpaCriteriaQuery<Student> createQuery = criteriaBuilder.createQuery(Student.class);

	            Root<Student> from = createQuery.from(Student.class);

	            List<Student> resultList = session.createQuery(createQuery.select(from)).getResultList();

	            return resultList;
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public int addStudent(Student student) {
	    int status = 0;
	    try (Session session = factory.openSession()) {
	        if (student != null) {
	            Transaction tx = session.beginTransaction();
	            session.save(student);
	            tx.commit();
	            status = 1;
	        } else {
	            status = 2;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        status = 3;
	    }
	    return status;
	}
	@Override
	public int deleteStudent(long studentId) {
		int status = 0;
		 try (Session session = factory.openSession()) {

	            final Student employeeFromDB = session.get(Student.class, studentId);
	            if (employeeFromDB != null) {
	                session.delete(employeeFromDB);
	                Transaction tx = session.beginTransaction();
					tx.commit();
	                status = 1;
	            } else {
	            	status= 2;
	            }
	        }
	        return status;
	}

	@Override
	public int updateStudent(long studentId, Student student) {
	int status = 0;
	try (Session session = factory.openSession())
	{
		Student studentFromDB = session.get(Student.class, studentId);
		
		if (studentFromDB != null)
		{
		session.saveOrUpdate(student);
		Transaction tx = session.beginTransaction();
		tx.commit();
		status = 1;
		} 
		else {
			status =2;
		}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
		return status;
	}



}

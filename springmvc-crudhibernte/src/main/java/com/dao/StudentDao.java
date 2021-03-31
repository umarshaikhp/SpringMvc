package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.model.Student;

@Component
public class StudentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Student> getAllStudent() {
		List<Student> getall = this.hibernateTemplate.loadAll(Student.class);
		return getall;
	}
	
	@Transactional
	public void createStudent(Student student) {
		this.hibernateTemplate.saveOrUpdate(student);
	}

	@Transactional
	public void delStudent(int id) {
		Student loadStudent = this.hibernateTemplate.load(Student.class, id);
		this.hibernateTemplate.delete(loadStudent);
		// TODO Auto-generated method stub
		
	}

	public Student getSingleStudent(int id) {
		return this.hibernateTemplate.get(Student.class, id);
		// TODO Auto-generated method stub

	}
}



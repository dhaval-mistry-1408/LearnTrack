package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {

	private List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public void updateStudent(Student student) {

	}

	public void removeStudent(int studentId) throws EntityNotFoundException {

		Student student = findStudent(studentId);
		student.setActive(false);
	}

	public Student findStudent(int id) throws EntityNotFoundException {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}

		throw new EntityNotFoundException("Student not found with ID: " + id);
	}

	public List<Student> listStudent() {
		return students;
	}

}

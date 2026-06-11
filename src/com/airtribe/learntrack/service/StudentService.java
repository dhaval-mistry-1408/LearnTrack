package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class StudentService {

	private static List<Student> students = new ArrayList<>();

	private void addStudent(Student student) {
		students.add(student);
	}

	public void scanAddStudentData(Scanner scanner) {
		System.out.println("Add Student Selected");

		System.out.print("First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();

		System.out.print("Email: ");
		String email = scanner.nextLine();

		System.out.print("Batch: ");
		String batch = scanner.nextLine();

		Student student = new Student(IdGenerator.getNextStudentId(), firstName, lastName, email, batch, true);

		addStudent(student);

		System.out.println("Student added successfully.");
		System.out.println("_____________________________________");
	}

	public void updateStudent(Student student) {

	}

	public void removeStudent(int studentId) throws EntityNotFoundException {

		Student student = findStudent(studentId);
		student.setActive(false);
	}

	public void scanStudentIdRemove(Scanner scanner) {
		System.out.print("Enter Student ID: ");
		int studentId = Integer.parseInt(scanner.nextLine());

		try {
			removeStudent(studentId);
			System.out.println("Student removed");
			System.out.println("_____________________________________");
		} catch (EntityNotFoundException e) {
			System.out.println("Student not found with ID: " + studentId);
			System.out.println("_____________________________________");
		}
	}

	public static Student findStudent(int id) throws EntityNotFoundException {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}

		throw new EntityNotFoundException("Student not found with ID: " + id);
	}

	public void scanStudentIdFind(Scanner scanner) {
		System.out.print("Enter Student ID: ");
		int id = Integer.parseInt(scanner.nextLine());

		try {
			Student foundStudent = findStudent(id);
			System.out.println(foundStudent);
			System.out.println("_____________________________________");
		} catch (EntityNotFoundException e) {
			System.out.println("Student not found.");
			System.out.println("_____________________________________");
		}

	}

	public void getAllStudents() {

		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			for (Student s : students) {
				System.out.println(s);
			}
		}
		System.out.println("_____________________________________");
	}

}

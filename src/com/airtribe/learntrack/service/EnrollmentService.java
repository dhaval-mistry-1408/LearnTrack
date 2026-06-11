package com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Enrollment.Status;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {

	private List<Enrollment> enrollments = new ArrayList<>();

	private void enrollStudent(Enrollment enrollment) {
		enrollments.add(enrollment);
	}

	public void scanEnrollStudentData(Scanner scanner) {

		System.out.print("Student ID: ");
		int studentId = Integer.parseInt(scanner.nextLine());

		System.out.print("Course ID: ");
		int courseId = Integer.parseInt(scanner.nextLine());

		boolean canProceed = true;
		try {
			StudentService.findStudent(studentId);

		} catch (EntityNotFoundException e) {
			canProceed = false;
			System.out.println("Student not found with ID: " + studentId);
		}

		try {
			CourseService.findCourse(courseId);
		} catch (EntityNotFoundException e) {
			canProceed = false;
			System.out.println("Course not found with ID: " + studentId);
		}

		if (canProceed) {
			Enrollment enrollment = new Enrollment(IdGenerator.getNextEnrollmentId(), studentId, courseId,
					LocalDate.now(), Status.ACTIVE);
			enrollStudent(enrollment);

			System.out.println("Enrollment successful.");
		}

	}

	private List<Enrollment> getEnrollmentsByStudent(int studentId) {

		List<Enrollment> result = new ArrayList<>();

		for (Enrollment enrollment : enrollments) {
			if (enrollment.getStudentId() == studentId) {
				result.add(enrollment);
			}
		}

		return result;
	}

	public void scanGetEnrollmentByStudent(Scanner scanner) {
		System.out.print("Student ID: ");
		int studentId = Integer.parseInt(scanner.nextLine());

		List<Enrollment> enrollments = getEnrollmentsByStudent(studentId);

		if (enrollments.isEmpty()) {
			System.out.println("No enrollments found.");
			return;
		}

		for (Enrollment enrollment : enrollments) {

			System.out.println(enrollment.getId() + " | Course ID: " + enrollment.getCourseId() + " | Status: "
					+ enrollment.getStatus());
		}
	}

	private Enrollment findEnrollment(int id) throws EntityNotFoundException {
		for (Enrollment enroll : enrollments) {
			if (enroll.getId() == id) {
				return enroll;
			}
		}

		throw new EntityNotFoundException("Enrollment not found with ID: " + id);
	}

	public void completeEnrollment(Scanner scanner) {

		System.out.print("Enrollment ID: ");
		int enrollmentId = Integer.parseInt(scanner.nextLine());

		try {
			Enrollment enroll = findEnrollment(enrollmentId);
			enroll.setStatus(Status.COMPLETED);
			System.out.println("Enrollment marked as completed.");
		} catch (EntityNotFoundException e) {
			System.out.println("Enrollment not found with ID: " + enrollmentId);
		}

	}

	public void cancelEnrollment(Scanner scanner) {

		System.out.print("Enrollment ID: ");
		int enrollmentId = Integer.parseInt(scanner.nextLine());

		try {
			Enrollment enrollment = findEnrollment(enrollmentId);
			enrollment.setStatus(Status.CANCELLED);
			System.out.println("Enrollment cancelled.");
		} catch (EntityNotFoundException e) {
			System.out.println("Enrollment not found with ID: " + enrollmentId);
		}

	}

}

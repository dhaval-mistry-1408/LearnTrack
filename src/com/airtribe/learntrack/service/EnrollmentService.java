package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Enrollment;

public class EnrollmentService {

	private List<Enrollment> enrollments = new ArrayList<>();

	public void enrollStudent(Enrollment enrollment) {
		enrollments.add(enrollment);
	}

	public List<Enrollment> getEnrollmentsByStudent(int studentId) {

		List<Enrollment> result = new ArrayList<>();

		for (Enrollment enrollment : enrollments) {
			if (enrollment.getStudentId() == studentId) {
				result.add(enrollment);
			}
		}

		return result;
	}

}

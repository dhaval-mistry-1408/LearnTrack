package com.airtribe.learntrack.util;

public class IdGenerator {

	private static int studentId = 1;
	private static int courseId = 1;
	private static int enrollmentId = 1;

	public static String getStudentId() {
		return "S" + studentId++;
	}

	public static String getCourseId() {
		return "C" + courseId++;
	}

	public static String getEnrollmentId() {
		return "E" + enrollmentId++;
	}

}

package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class CourseService {

	private static List<Course> courses = new ArrayList<>();

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void scanAddCourseData(Scanner scanner) {

		System.out.print("Course Name: ");
		String name = scanner.nextLine();

		System.out.print("Description: ");
		String description = scanner.nextLine();

		System.out.print("Duration (weeks): ");
		int duration = Integer.parseInt(scanner.nextLine());

		Course course = new Course(IdGenerator.getNextCourseId(), name, description, duration, true);

		addCourse(course);

		System.out.println("Course added successfully.");
		System.out.println("_____________________________________");

	}

	public void getAllCourses() {

		if (courses.isEmpty()) {
			System.out.println("No courses found.");

		} else {
			for (Course c : courses) {
				System.out.println(c);
			}
		}
		System.out.println("_____________________________________");

	}

	public static Course findCourse(int id) throws EntityNotFoundException {

		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}

		throw new EntityNotFoundException("Course not found");
	}

	public void scanCourseIdFind(Scanner scanner) {
		System.out.print("Enter Course ID: ");
		int id = Integer.parseInt(scanner.nextLine());

		try {
			Course foundCourse = findCourse(id);
			System.out.println(foundCourse);
		} catch (EntityNotFoundException e) {
			System.out.println("Course not found.");
		}
		System.out.println("_____________________________________");

	}

}

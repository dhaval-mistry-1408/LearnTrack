package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

	private List<Course> courses = new ArrayList<>();

	public void addCourse(Course course) {
		courses.add(course);
	}

	public List<Course> getAllCourses() {
		return courses;
	}

	public Course findCourse(int id) throws EntityNotFoundException {

		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}

		throw new EntityNotFoundException("Course not found");
	}

}

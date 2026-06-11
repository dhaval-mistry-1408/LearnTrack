package com.airtribe.learntrack.service;

import java.util.Scanner;

public class MenuService {

	StudentService studentService = new StudentService();
	CourseService courseService = new CourseService();
	EnrollmentService enrollmentService = new EnrollmentService();

	public void showStudentMenu(Scanner scanner) {

		boolean back = false;

		while (!back) {

			System.out.println("\n----- Student Menu -----");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student By ID");
			System.out.println("4. Remove Student");
			System.out.println("0. Back");

			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					studentService.scanAddStudentData(scanner);
					break;

				case 2:
					studentService.getAllStudents();
					break;

				case 3:
					studentService.scanStudentIdFind(scanner);
					break;

				case 4:
					studentService.scanStudentIdRemove(scanner);
					break;

				case 0:
					back = true;
					break;

				default:
					System.out.println("Invalid option");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

	public void showCourseMenu(Scanner scanner) {

		boolean back = false;

		while (!back) {

			System.out.println("\n----- Course Menu -----");
			System.out.println("1. Add Course");
			System.out.println("2. View Course");
			System.out.println("3. List Courses");

			System.out.println("0. Back");

			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					courseService.scanAddCourseData(scanner);
					break;

				case 2:
					courseService.scanCourseIdFind(scanner);
					break;

				case 3:
					courseService.getAllCourses();
					break;

				case 0:
					back = true;
					break;

				default:
					System.out.println("Invalid option");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

	public void showEnrollmentMenu(Scanner scanner) {

		boolean back = false;

		while (!back) {

			System.out.println("\n----- Enrollment Menu -----");
			System.out.println("1. Enroll Student");
			System.out.println("2. View Student Enrollments");
			System.out.println("3. Mark Completed");
			System.out.println("4. Mark Cancelled");
			System.out.println("0. Back");

			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					enrollmentService.scanEnrollStudentData(scanner);
					break;

				case 2:
					enrollmentService.scanGetEnrollmentByStudent(scanner);
					break;

				case 3:
					enrollmentService.completeEnrollment(scanner);
					break;
				case 4:
					enrollmentService.cancelEnrollment(scanner);
					break;

				case 0:
					back = true;
					break;

				default:
					System.out.println("Invalid option");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

}

import java.util.List;
import java.util.Scanner;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		EnrollmentService enrollmentService = new EnrollmentService();

		boolean running = true;

		while (running) {

			System.out.println("\n===== LEARNTRACK =====");
			System.out.println("1. Student Management");
			System.out.println("2. Course Management");
			System.out.println("3. Enrollment Management");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					showStudentMenu(scanner, studentService);
					break;

				case 2:
					showCourseMenu(scanner, courseService);
					break;

				case 3:
					showEnrollmentMenu(scanner, enrollmentService);
					break;

				case 0:
					running = false;
					System.out.println("Thank you for using LearnTrack!");
					break;

				default:
					System.out.println("Invalid option. Try again.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}

		scanner.close();
	}

	private static void showStudentMenu(Scanner scanner, StudentService studentService) {

		boolean back = false;

		while (!back) {

			System.out.println("\n----- Student Menu -----");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student By ID");
			System.out.println("4. Deactivate Student");
			System.out.println("0. Back");

			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					System.out.println("Add Student Selected");

					System.out.print("First Name: ");
					String firstName = scanner.nextLine();

					System.out.print("Last Name: ");
					String lastName = scanner.nextLine();

					System.out.print("Email: ");
					String email = scanner.nextLine();

					System.out.print("Batch: ");
					String batch = scanner.nextLine();

					Student student = new Student(IdGenerator.getNextStudentId(), firstName, lastName, email, batch,
							true);

					studentService.addStudent(student);

					System.out.println("Student added successfully.");

					break;

				case 2:
					System.out.println("View Students Selected");

					List<Student> students = studentService.listStudent();

					if (students.isEmpty()) {
						System.out.println("No students found.");
					} else {
						for (Student s : students) {
							System.out.println(s);
						}
					}
					break;

				case 3:
					System.out.print("Enter Student ID: ");
					int id = Integer.parseInt(scanner.nextLine());

					try {
						Student foundStudent = studentService.findStudent(id);
					} catch (EntityNotFoundException e) {
						System.out.println("Studnet not found.");
						e.printStackTrace();
					}

					System.out.println("Searching Student " + id);
					break;

				case 4:
					System.out.print("Enter Student ID: ");
					int studentId = Integer.parseInt(scanner.nextLine());

					try {
						studentService.removeStudent(studentId);
					} catch (EntityNotFoundException e) {
						System.out.println("Studnet not found with ID: " + studentId);
						e.printStackTrace();
					}

					System.out.println("Student removed");
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

	private static void showCourseMenu(Scanner scanner, CourseService courseService) {

		boolean back = false;

		while (!back) {

			System.out.println("\n----- Course Menu -----");
			System.out.println("1. Add Course");
			System.out.println("2. View Courses");
			System.out.println("3. Activate Course");
			System.out.println("4. Deactivate Course");
			System.out.println("0. Back");

			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					System.out.println("Add Course Selected");
					break;

				case 2:
					System.out.println("View Courses Selected");
					break;

				case 3:
					System.out.println("Activate Course Selected");
					break;

				case 4:
					System.out.println("Deactivate Course Selected");
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

	private static void showEnrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {

		boolean back = false;

		while (!back) {

			System.out.println("\n----- Enrollment Menu -----");
			System.out.println("1. Enroll Student");
			System.out.println("2. View Student Enrollments");
			System.out.println("3. Mark Completed");
			System.out.println("4. Cancel Enrollment");
			System.out.println("0. Back");

			System.out.print("Enter choice: ");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {

				case 1:
					System.out.println("Enroll Student Selected");
					break;

				case 2:
					System.out.println("View Enrollments Selected");
					break;

				case 3:
					System.out.println("Mark Completed Selected");
					break;

				case 4:
					System.out.println("Cancel Enrollment Selected");
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

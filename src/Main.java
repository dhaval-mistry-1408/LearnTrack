import java.util.Scanner;

import com.airtribe.learntrack.service.MenuService;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		MenuService menuService = new MenuService();

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
					menuService.showStudentMenu(scanner);
					break;

				case 2:
					menuService.showCourseMenu(scanner);
					break;

				case 3:
					menuService.showEnrollmentMenu(scanner);
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

}

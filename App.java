import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Single shared Scanner
        try {
            LoginMenu loginMenu = new LoginMenu();
            boolean result = loginMenu.loginMenu(sc);

            if (result) {
                System.out.println("Operation completed successfully.");

                while (true) {
                    System.out.println("\n--- Welcome to the Hospital Management System ---");
                    System.out.println("1: Patient Menu");
                    System.out.println("2: Administrator Menu");
                    System.out.println("3: Pharmacist Menu");
                    System.out.println("4: Doctor Menu");
                    System.out.println("5: Exit");

                    System.out.print("Enter your choice: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                        sc.next(); // Clear the invalid input
                        continue;
                    }

                    int choice = sc.nextInt();
                    sc.nextLine(); // Consume newline character

                    Menu menu = null;

                    switch (choice) {
                        case 1:
                            menu = new PatientMenu();
                            break;
                        case 2:
                            menu = new AdministratorMenu();
                            break;
                        case 3:
                            menu = new PharmacistMenu();
                            break;
                        case 4:
                            menu = new DoctorMenu();
                            break;
                        case 5:
                            System.out.println("Exiting the system. Goodbye!");
                            return; // No need to close Scanner here
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            continue;
                    }

                    if (menu != null) {
                        menu.displayMenu();
                    }
                }
            } else {
                System.out.println("Operation failed. Please try again.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close(); // Close the Scanner once at the end
        }
    }
}
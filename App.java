import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Welcome to the Hospital Management System ---");
            System.out.println("1: Patient Menu");
            System.out.println("2: Administrator Menu");
            System.out.println("3: Pharmacist Menu");
            System.out.println("4: Doctor Menu");
            System.out.println("5: Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

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
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
            if (menu != null) {
                menu.displayMenu();
            }
        }
    }
}
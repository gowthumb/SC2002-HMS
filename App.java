import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ManageStaff manageStaff = new ManageStaff();

        while (true) {
            System.out.println("\nWelcome to the Staff Management System");
            System.out.println("1. Manage Staff");
            System.out.println("2. Exit");

            int choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) {
                case 1:
                    manageStaff.manageStaff();
                    break;
                case 2:
                    System.out.println("Exiting the program...");
                    sc.close();  
                    return;  
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

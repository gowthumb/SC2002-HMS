import java.io.IOException;
import java.util.Scanner;

public class AdministratorMenu implements Menu{
    Scanner sc = new Scanner(System.in);
    ViewStaff view;
    UpdateStaff update;
    ViewAppointment appointment;
    public void displayMenu() throws IOException {
        chooseOption();
    }
    public void chooseOption() throws IOException{
        while (true) {
            System.out.println("\nWelcome to the Staff Management System");
            System.out.println("1. View Staff");
            System.out.println("2. Add New Staff");
            System.out.println("3. Update Staff Information");
            System.out.println("4. Remove Staff");
            System.out.println("5. View Appointment Details");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) {
                case 1:
                    view = new AcessStaff();
                    view.viewStaff();
                    break;
                case 2:
                    update = new AddNewStaff();
                    update.updateStaff();
                    break;
                case 3:
                    update = new ManageStaff();
                    update.updateStaff();
                    break;
                case 4:
                    update = new RemoveStaff();
                    update.updateStaff();
                    break;
                case 5:
                    appointment = new AdminViewAppointment();
                    appointment.viewAppointment();
                    return;
                case 6:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


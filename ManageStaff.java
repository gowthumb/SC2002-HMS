import java.io.IOException;
import java.util.Scanner;

public class ManageStaff {
    Database db = new Database();
    String filePath = "Staff.txt";
    private Scanner sc = new Scanner(System.in);

    public void manageStaff() throws IOException{
        while (true) {
            System.out.println("\nManage Staff Menu:");
            System.out.println("1. View Staff");
            System.out.println("2. Add New Staff");
            System.out.println("3. Update Staff Information");
            System.out.println("4. Remove Staff");
            System.out.println("5. Go Back");
            
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: viewStaff(); break;
                case 2: addNewStaff(); break;
                case 3: updateStaff(); break;
                case 4: removeStaff(); break;
                case 5: return; 
                default: System.out.println("Invalid choice.");
            }
        }
    }
    
    public void viewStaff() throws IOException{
        System.out.println("Search by which field? ");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Role");
        System.out.println("4. Gender");
        System.out.println("5. Age");
        System.out.println("6. View All");
        int choice = sc.nextInt();
        sc.nextLine();
        String search;
        switch (choice) {
            case 1:
                System.out.print("ID: ");
                String id = sc.nextLine();
                search = db.ReadFile(filePath, id, 0);
                System.out.println(search);
                break;
            case 2:
                System.out.print("Name: ");
                String name = sc.nextLine();
                search = db.ReadFile(filePath, name, 1);
                System.out.println(search);
                break;
            case 3:
                System.out.print("Role: ");
                String role = sc.nextLine();
                search = db.ReadFile(filePath, role, 2);
                System.out.println(search);
                break;
            case 4:
                System.out.print("Gender: ");
                String gender = sc.nextLine();
                search = db.ReadFile(filePath, gender, 3);
                System.out.println(search);
                break;
            case 5:
                System.out.print("Age: ");
                String age = sc.nextLine();
                search = db.ReadFile(filePath, age, 4);
                System.out.println(search);
                break;
            case 6:
                search = db.ReadAll(filePath);
                System.out.println(search);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

    }

    public void addNewStaff() {
        System.out.println("Enter Staff Details:");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Role: ");
        String role = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 
    
        String newStaff = id + " " + name + " " + role + " " + gender + " " + age + "\n";
    
        try {
            db.addnew(filePath, newStaff);
            System.out.println("New staff added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding staff: " + e.getMessage());
        }
    }
    
    public void updateStaff() {
        System.out.println("Enter Staff ID to Update: ");
        String id = sc.nextLine();
        System.out.println("Enter the field to update (Name, Role, Gender, Age): ");
        String field = sc.nextLine();
        System.out.println("Enter the old value: ");
        String oldValue = sc.nextLine();
        System.out.println("Enter the new value: ");
        String newValue = sc.nextLine();
    
        try {
            db.UpdateFile(filePath, id, oldValue, newValue);
            System.out.println("Staff updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating staff: " + e.getMessage());
        }
    }
    public void removeStaff() throws IOException{
        System.out.println("Remove by which field? ");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Role");
        System.out.println("4. Gender");
        System.out.println("5. Age");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("ID: ");
                String id = sc.nextLine();
                db.deleteRecord(filePath, id, 0);
                break;
            case 2:
                System.out.print("Name: ");
                String name = sc.nextLine();
                db.deleteRecord(filePath, name, 1);
                break;
            case 3:
                System.out.print("Role: ");
                String role = sc.nextLine();
                db.deleteRecord(filePath, role, 2);
                break;
            case 4:
                System.out.print("Gender: ");
                String gender = sc.nextLine();
                db.deleteRecord(filePath, gender, 3);
                break;
            case 5:
                System.out.print("Age: ");
                String age = sc.nextLine();
                db.deleteRecord(filePath, age, 4);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    }
}

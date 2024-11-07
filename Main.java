import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        ViewInventory viewInventory = new ViewInventory();
        Scanner scanner = new Scanner(System.in);

        String filePath = "Inventory.txt"; 

        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Check Inventory for a Medicine");
            System.out.println("2. Check if Stock is Low");
            System.out.println("3. Display Full Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Medicine Name: ");
                    String medicineName = scanner.nextLine();
                    viewInventory.loadFromDatabase(database, filePath, medicineName);
                    viewInventory.displayInventoryDetails();
                    break;

                case 2:
                    System.out.print("Enter Medicine Name to check stock: ");
                    String medicineToCheck = scanner.nextLine();

                    System.out.print("Enter stock threshold: ");
                    int threshold = scanner.nextInt();
                    viewInventory.loadFromDatabase(database, filePath, medicineToCheck);
                    viewInventory.checkLowStock(threshold);
                    break;

                case 3:
                    viewInventory.displayFullInventory(filePath);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

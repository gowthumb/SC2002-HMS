import java.io.IOException;
import java.util.Scanner;

public class LoginMenu {
    private static final String USERS_FILE = "Allusers.txt";
    private static final String DEFAULT_PASSWORD = "password";

    public boolean loginMenu(Scanner sc) throws IOException {
        System.out.println("Login");
        System.out.print("First Time Login (Y/N): ");
        if (!sc.hasNext()) {
            System.out.println("No input received.");
            return false;
        }
        char firstTimeLogin = Character.toUpperCase(sc.next().charAt(0));
        String id;
        String oldPassword;
        String newPassword;

        Database db = new Database();

        switch (firstTimeLogin) {
            case 'Y':
                System.out.print("Enter your Login Hospital ID: ");
                id = sc.next();

                // Check if the user already exists
                String userLine = db.ReadFile(USERS_FILE, id, 0);

                if (userLine == null || userLine.isEmpty()) {
                    // User does not exist, proceed to register
                    String hashedDefaultPassword = Hash.hashPassword(DEFAULT_PASSWORD);
                    String newUserEntry = id + "|" + hashedDefaultPassword;
                    db.addnew(USERS_FILE, newUserEntry);
                    System.out.println("New user registered with default password 'password'.");
                    System.out.println("Please change your password.");

                    // Prompt to change password
                    System.out.print("Enter new password: ");
                    newPassword = sc.next();
                    Login login = new Login(hashedDefaultPassword, newPassword, id);
                    login.changePassword();
                    System.out.println("Password changed successfully. Please login again.");
                    return true;
                } else {
                    // User exists, proceed with first time login (change default password)
                    oldPassword = DEFAULT_PASSWORD; // Default password is always "password"
                    Authenticate authenticate = new Authenticate(oldPassword, id);

                    if (authenticate.verifyPassword()) {
                        System.out.println("Change password:");
                        System.out.print("Enter new password: ");
                        newPassword = sc.next();
                        String storedPassword = authenticate.getStoredPassword();
                        Login login = new Login(storedPassword, newPassword, id);
                        login.changePassword();
                        // Successful login after password change
                        System.out.println("Password changed successfully. Please login again.");
                        return true;
                    } else {
                        System.out.println("Incorrect Password!");
                        return false;
                    }
                }

            case 'N':
                System.out.print("Enter your Login Hospital ID: ");
                id = sc.next();
                System.out.print("Enter password: ");
                oldPassword = sc.next();
                Authenticate authenticator = new Authenticate(oldPassword, id);

                if (authenticator.verifyPassword()) {
                    // Successful login
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Incorrect Password!");
                    return false;
                }

            default:
                System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
                return false;
        }
    }
}
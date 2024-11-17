import java.io.IOException;
import java.util.Scanner;

public class LoginMenu {
    public boolean Loginmenu() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("First Time Login (Y/N): ");
        char firsttimelogin = sc.next().charAt(0);
        String id;
        String oldpassword;
        String newpassword;
        switch (firsttimelogin) 
        {
            case 'Y': 
                System.out.println("Enter your Login Hospital ID: ");
                id = sc.next();
                System.out.println("Enter default password: ");
                oldpassword = sc.next();
                Authenticate authenticate = new Authenticate(oldpassword, id);
                if (authenticate.verifyPassword() == true)
                {
                    System.out.println("Change password: ");
                    System.out.println("Enter new password: ");
                    newpassword = sc.next();
                    Login login = new Login(oldpassword, newpassword, id);
                    login.ChangePassword();
                    //need to add next code for sucessful login
                    return true;
                }
                else 
                {
                    System.out.println("Incorrect Password! ");
                    return false;
                }

            case 'N': 
                System.out.println("Enter your Login Hospital ID: ");
                id = sc.next();
                System.out.println("Enter password: ");
                oldpassword = sc.next();
                Authenticate authenticater = new Authenticate(oldpassword, id);
                if (authenticater.verifyPassword() == true)
                {
                    //need to add next code for sucessful login
                    return true;
                }
                else 
                {
                    System.out.println("Incorrect Password! ");
                    return false;
                }

            default: 
                System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
                return false;
        }
    }
}

import java.io.IOException;

public class Login {
    private String oldPassword;
    private String newPassword;
    private String id;
    
    public Login(String Old, String New, String id)
    {
        oldPassword = Old;
        newPassword = New;
        this.id = id;
    }

    public void ChangePassword() throws IOException
    {
        Database db = new Database();
        db.UpdateFile("Allusers.txt", id, oldPassword, newPassword);
    }
    
}

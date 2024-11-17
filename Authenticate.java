import java.io.IOException;

public class Authenticate 
{
    private String Password;
    private String id;
    public Authenticate(String Password, String id)
    {
        this.Password = Password;
        this.id = id;
    }
    public boolean verifyPassword() throws IOException
    {
        Database db = new Database();
        String cur = db.ReadFile("Allusers.txt", Password, 1);
        String cur_id = db.ReadFile("Allusers.txt", id, 0);

        if (cur == null || cur.equals("None"))
        {
            return false;
        }
        else if (cur.equals(cur_id))
        {
            return true;
        }
        return false;
    }
}

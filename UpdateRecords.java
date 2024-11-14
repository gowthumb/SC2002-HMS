import java.io.IOException;

public class UpdateRecords 
{
    String id;
    String old;
    String replace;

    public UpdateRecords(String id, String old, String replace)
    {
        this.id = id;
        this.old = old;
        this.replace = replace;
    }

    public void performUpdate(Database db, String filePath) {
        try {
            db.UpdateFile(filePath, id, old, replace);
            System.out.println("Update successful for ID: " + id);
        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }

}

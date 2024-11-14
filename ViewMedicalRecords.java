import java.io.IOException;

public class ViewMedicalRecords {
    private String id;

    public ViewMedicalRecords(String id)
    {
        this.id = id;
    }
    public void PrintRecordspatient() throws IOException
    {
        Database db = new Database();
        System.out.println(db.ReadFile("Patient.txt", this.id, 0));
    }
}

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Database db = new Database();
        String filePath = "Patient.txt";
        
        ViewMedicalRecords view = new ViewMedicalRecords("Patient", "12345", "Patient.txt");
        view.PrintRecordspatient();

        UpdateRecords update = new UpdateRecords( "12345", "Male", "Female");
        update.performUpdate(db, filePath);
        ViewAvailableAppointments app = new ViewAvailableAppointments();
        app.AvailableAppointments();
    }
}

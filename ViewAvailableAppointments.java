import java.io.IOException;

public class ViewAvailableAppointments {
    public void AvailableAppointments() throws IOException
    {
        Database db = new Database();
        System.out.println(db.ReadFile("Appointments.txt", "Available",3 ));
    }
}

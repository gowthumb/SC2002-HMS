import java.io.IOException;

public class CancelAppointments {
    String id;
    String OldDoctor;

    public CancelAppointments(String id, String OldDoctor)
    {
        this.id = id;
        this.OldDoctor = OldDoctor;
    }
    public void Cancel() throws IOException
    {
        RescheduleAppointment reschedule = new RescheduleAppointment(this.id, "notneeded", "notneeded", "notneeded", this.OldDoctor);
        reschedule.CancelPreviousAppointment();
        System.out.println("Appointment Cancelled ");
    }

}

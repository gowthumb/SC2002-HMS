import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.View;

public class PatientMenu {
    
    public void chooseOption() throws IOException
    {
        // CancelAppointments cancel = new CancelAppointments("23456", "Dr.Y");
        // cancel.Cancel();

        // Database db = new Database();
        // String filePath = "Patient.txt";
        
        // ViewMedicalRecords view = new ViewMedicalRecords("12345");
        // view.PrintRecordspatient();

        // UpdateRecords update = new UpdateRecords( "12345", "Female", "Male");
        // update.performUpdate(db, filePath);
        // ViewAvailableAppointments app = new ViewAvailableAppointments();
        // app.AvailableAppointments();

        // ScheduleAppointment schedule = new ScheduleAppointment("23456", "1990-01-01", "Dr.Y", "4:00pm");
        // schedule.RequestAppointment();

        // RescheduleAppointment reschedule = new RescheduleAppointment("23455", "1990-01-01", "3:00pm", "Dr.Y", "Dr.X");
        // reschedule.MakeNewAppointment();
        // reschedule.CancelPreviousAppointment();
        System.out.println("1: View Medical Record");
        System.out.println("2: Update Personal Information");
        System.out.println("3: View Available Appointment Slots");
        System.out.println("4: Schedule an Appointment");
        System.out.println("5: Reschedule an Appointment");
        System.out.println("6: Cancel an Appointment");
        System.out.println("7: View Scheduled Appointments");
        System.out.println("8: View Past Appointments Records");
        System.out.println("9: Logout");

        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select an operation:");
        choice = sc.nextInt();

        switch(choice) {
            case 1:
                System.out.print("Enter your id: ");
                String id = sc.next();
                ViewMedicalRecords view = new ViewMedicalRecords(id);
                view.viewPatients();
                break;
            
            case 2:
                Database db = new Database();
                String filePath = "Patient.txt";
                System.out.print("Enter your id: ");
                id = sc.next();
                System.out.println("Enter field to change: ");
                System.out.println("1: Phone ");
                System.out.println("2: Email ");
                int field = sc.nextInt();

                if (field == 1)
                {
                    System.out.print("Enter old Phone Number: ");
                    String old = sc.next();
                    System.out.print("Enter New Phone Number: ");
                    String replace = sc.next();
                    UpdateRecords update = new UpdateRecords(id, old, replace);
                    update.updatePatients();
                }
                else
                {
                    System.out.print("Enter old Email: ");
                    String old = sc.next();
                    System.out.print("Enter new Email: ");
                    String replace = sc.next();
                    UpdateRecords update = new UpdateRecords(id, old, replace);
                    update.updatePatients();
                }
                break;
            
            case 3:
                System.out.println("Available Appointments: ");
                ViewAvailableAppointments app = new ViewAvailableAppointments();
                app.viewAppointments();
                break;
            
            case 4:
                System.out.print("Enter your id: ");
                id = sc.next();
                System.out.println("Available Appointments: ");
                ViewAvailableAppointments appointments = new ViewAvailableAppointments();
                appointments.viewAppointments();
                System.out.print("Enter the Date for appointment: ");
                String date = sc.next();
                System.out.print("Enter the Time for appointment: ");
                String time = sc.next();
                System.out.print("Enter Doctor Name: ");
                String doctor = sc.next();
                ScheduleAppointment schedule = new ScheduleAppointment(id, date, doctor, time);
                schedule.updateAppointments();
                break;
            
            case 5:
                System.out.print("Enter your id: ");
                id = sc.next();
                System.out.println("Available Appointments: ");
                ViewAvailableAppointments reappointments = new ViewAvailableAppointments();
                reappointments.viewAppointments();
                System.out.print("Enter the New Date for appointment: ");
                date = sc.next();
                System.out.print("Enter the New Time for appointment: ");
                time = sc.next();
                System.out.print("Enter the New Doctor Name: ");
                String new_doctor = sc.next();
                System.out.print("Enter the Old Doctor Name: ");
                String old_doctor = sc.next();
                RescheduleAppointment reschedule = new RescheduleAppointment(id, date, time, new_doctor, old_doctor);
                // ScheduleAppointment schedulenew = new ScheduleAppointment(id, date, new_doctor, time);
                // schedulenew.RequestAppointment();
                reschedule.CancelPreviousAppointment();
                reschedule.updateAppointments();
                break;
            
            case 6:
                System.out.print("Enter your id: ");
                id = sc.next();
                System.out.print("Enter doctor name: ");
                doctor = sc.next();
                CancelAppointments cancel = new CancelAppointments(id, doctor);
                cancel.updateAppointments();
                break;

            default:
                System.out.println("Invalid Choice");
          }
    }
   
}

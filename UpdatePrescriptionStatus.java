import java.io.IOException;

public class UpdatePrescriptionStatus implements UpdatePatient{
    private String filePath1;
    private String filePath2;
    String id;


    public UpdatePrescriptionStatus(String filePath1, String filePath2, String id) {
        this.filePath1 = filePath1;
        this.filePath2 = filePath2;
        this.id = id;
    }

    public void updatePatients() throws IOException {
        Database db = new Database();
        String patientRecord = db.ReadFile(filePath1, id, 0);
        String appointmentRecord = db.ReadFile(filePath2, id, 0);

        if (patientRecord == null || patientRecord.isEmpty()) {
            System.out.println("No record found for Patient ID: " + id);
            return;
        }
        if (appointmentRecord == null || appointmentRecord.isEmpty()) {
            System.out.println("No record found for Patient ID: " + id);
            return;
        }

        String[] fields1 = patientRecord.split("\\|");
        String[] fields2 = appointmentRecord.split("\\|");

        if (fields1.length < 10) {
            System.out.println("Invalid record format for Patient ID: " + id);
            return;
        }

        for (int i = 0; i < fields1.length; i++) {
            fields1[i] = fields1[i].trim();
        }
        for (int i = 0; i < fields2.length; i++) {
            fields2[i] = fields2[i].trim();
        }

        String oldStatus1 = fields1[9]; 
        String oldStatus2 = fields2[8];
        

        System.out.println("Current Status: " + oldStatus1);

        if (oldStatus1.equalsIgnoreCase("Pending")) {
            db.UpdateFile(filePath1, id, oldStatus1, "Dispensed");
            db.UpdateFile(filePath2, id, oldStatus2, "Dispensed");
            System.out.println("Prescription status updated successfully for Patient ID: " + id);
            System.out.println("New Status: Dispensed");
        } else if (oldStatus1.equalsIgnoreCase("Dispensed")) {
            System.out.println("Prescription status is already Dispensed for Patient ID: " + id);
        } else {
            System.out.println("Invalid status found in the record for Patient ID: " + id);
        }
    }
}

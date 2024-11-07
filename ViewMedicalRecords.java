import java.io.IOException;

public class ViewMedicalRecords {
    
    private Database database;
    private Records records;
    private String id;
    private String filepath;
    private String userType;

    public ViewMedicalRecords(String userType, String id, String filepath) {
        this.id = id;
        this.filepath = filepath;
        this.userType = userType;
        this.database = new Database();

        if (userType.equals("Patient")) {
            this.records = new Patient(); 
        }   
    }
    
    public void PrintRecordspatient() {
        try {
            if (this.records == null) {
                System.out.println("Invalid user type: " + this.userType);
                return;
            }
            this.database.loadPersonData(this.records, this.filepath, this.id);
            Patient patient = (Patient) this.records;
            System.out.println("Patient ID: " + patient.getID());
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Patient DOB: " + patient.getDOB());
            System.out.println("Patient Gender: " + patient.getGender());            
            System.out.println("Patient Phone: " + patient.getPhone());
            System.out.println("Patient Email: " + patient.getEmail());
            System.out.println("Patient Blood Type: " + patient.getBloodType());
            System.out.println("Patient Past Diagnoses: " + patient.getPastDiagnoses());
            System.out.println("Patient Treatments: " + patient.getTreatments());

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
}
}

// import java.io.IOException;

// public class Patient implements Records {
//     private String ID;
//     private String Name;
//     private String DOB;
//     private String Gender;
//     private String Phone;
//     private String Email;
//     private String BloodType;
//     private String PastDiagnoses;
//     private String Treatments;

//     @Override
//     public void loadFromDatabase(Database database, String filePath, String id) throws IOException {
//         String line = database.ReadFile(filePath, id, 0);
//         if (line != null) {
//             String[] data = line.split("\\s+");
//             this.ID = data[0].trim();
//             this.Name = data[1].trim();
//             this.DOB = data[2].trim();
//             this.Gender = data[3].trim();
//             this.Phone = data[4].trim();
//             this.Email = data[5].trim();
//             this.BloodType = data[6].trim();
//             this.PastDiagnoses = data[7].trim();
//             this.Treatments = data[8].trim();
//         } else {
//             System.out.println("No data found for ID: " + id);
//         }
//     }

//     // Getter methods for each field
//     public String getID() {
//         return ID;
//     }

//     public String getName() {
//         return Name;
//     }

//     public String getDOB() {
//         return DOB;
//     }

//     public String getGender() {
//         return Gender;
//     }

//     public String getPhone() {
//         return Phone;
//     }

//     public String getEmail() {
//         return Email;
//     }

//     public String getBloodType() {
//         return BloodType;
//     }

//     public String getPastDiagnoses() {
//         return PastDiagnoses;
//     }

//     public String getTreatments() {
//         return Treatments;
//     }
// }

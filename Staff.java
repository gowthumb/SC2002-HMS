import java.io.IOException;

public class Staff implements Records {
    private String id;
    private String name;
    private String role;
    private String gender;
    private int age; 
    
    public void loadFromDatabase(Database database, String filePath, String id) throws IOException {
    String line = database.ReadFile(filePath, id, 0);
        if (line != null) {
            String[] data = line.split("\\s+");
            this.id = data[0].trim();
            this.name = data[1].trim();
            this.role = data[2].trim();
            this.gender = data[3].trim();
            this.age = Integer.parseInt(data[4].trim());
        } else {
            System.out.println("No data found for ID: " + id);
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
}
import java.io.IOException;

public class Inventory implements Records {
    private String MedicineName;
    private int StockLevel;

    public void loadFromDatabase(Database database, String filePath, String id) {
        try {
            String line = database.ReadFile(filePath, id);
            if (line != null) {
                String[] data = line.split("\\s+");
                this.MedicineName = data[0].trim();
                this.StockLevel = Integer.parseInt(data[1].trim());
            } else {
                System.out.println("No data found for Medicine Name: " + id);
            }
        } catch (IOException e) {
            System.err.println("Error loading inventory data: " + e.getMessage());
        }
    }

    // Getter methods for each field
    public String getMedicineName() { return MedicineName; }
    public int getStockLevel() { return StockLevel; }

}

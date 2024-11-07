import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewInventory extends Inventory{
    public void displayInventoryDetails() {
        if (getMedicineName() == null) {
            System.out.println("Empty Inventory");
            return;
        }
        System.out.println("Medicine Name: " + getMedicineName() + ", " + "Stock Level: " + getStockLevel());
    }

    public void displayFullInventory(String filePath) {
        System.out.println("===== Full Inventory =====");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+");
                if (data.length >= 2) { // Only requires MedicineName and StockLevel
                    System.out.println("Medicine Name : " + data[0]);
                    System.out.println("Stock Level   : " + data[1]);
                    System.out.println("--------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading full inventory: " + e.getMessage());
        }
    }

    public void checkLowStock(int threshold) {
        if (getStockLevel() < threshold) {
            System.out.println("Warning: Low stock for " + getMedicineName() + " (Current level: " + getStockLevel() + ")");
        } else {
            System.out.println("Stock level for " + getMedicineName() + " is sufficient.");
        }
    }
}

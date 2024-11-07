import java.io.IOException;

public interface Records {
    public void loadFromDatabase(Database database, String filePath, String id) throws IOException;
} 


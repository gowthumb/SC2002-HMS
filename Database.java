import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Database {
    public String ReadAll(String filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();
    
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }
        }
    
        return fileContent.toString();
    }
    public String ReadFile(String filePath, String required, int Column) throws IOException {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words[Column].equals(required)) 
                { 
                    fileContent.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            return "An error occurred while reading the file: " + e.getMessage(); // Error handling within the method
        }
        return fileContent.toString();
    }
    public void UpdateFile(String filePath, String id, String old, String replace) throws IOException 
    {
        File tempFile = new File("tempFile.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                
                if (words[0].equals(id)) { 
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].equals(old)) {
                            words[i] = replace;
                        }
                    }
                    line = String.join(" ", words);
                }
                
                bw.write(line);
                bw.newLine();
            }
        }
        
        File originalFile = new File(filePath);
        if (originalFile.delete()) {
            if (!tempFile.renameTo(originalFile)) {
                throw new IOException("Could not rename temporary file.");
            }
        } else {
            throw new IOException("Could not delete the original file.");
        }
    }


    public void addnew(String filePath, String newline) throws IOException 
    {
        try (FileWriter writer = new FileWriter(filePath, true)) 
        { 
            writer.write(newline);
        }
    }

}
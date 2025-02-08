// DataGenerator.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public void generateData(String filename) {
        Random rand = new Random();
        
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i <= 3000; i++) {
                writer.write(rand.nextInt(1000) + "\n");
            }
            System.out.println("Datos generados en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
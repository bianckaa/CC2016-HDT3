// DataGenerator.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        String filename = "data.txt";
        Random rand = new Random();
        
        try (FileWriter writer = new FileWriter(filename)) {
            for (int numElements = 10; numElements <= 3000; numElements *= 10) {
                writer.write("\nDataset size: " + numElements + "\n");
                for (int i = 0; i < numElements; i++) {
                    writer.write(rand.nextInt(10000) + "\n");
                }
            }
            System.out.println("Datos generados en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
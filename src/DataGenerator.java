import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    
    /** 
     * @param filename
     */
    public void generateData(String filename) {
        Random rand = new Random();
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("El archivo ya existe y será sobrescrito: " + filename);
        }

        try (FileWriter writer = new FileWriter(file, false)) { 
            for (int i = 0; i <= 3000; i++) {
                writer.write(rand.nextInt(1000) + "\n");
            }
            System.out.println("Datos generados en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

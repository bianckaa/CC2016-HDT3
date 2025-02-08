import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test; 
import java.io.File; 

public class DataGeneratorTest {

    @Test
    public void testGenerateData() {
        // Crear una instancia de DataGenerator
        DataGenerator generator = new DataGenerator();
        String filename = "test_data.txt";

        
        generator.generateData(filename);

        
        File file = new File(filename);
        assertTrue(file.exists(), "El archivo no se creó correctamente");

        
        assertTrue(file.length() > 0, "El archivo está vacío");

        
        file.delete();
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class DataReaderTest {
    @Test
    public void testReadData() {
        String filename = "test_read_data.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("170\n45\n75\n90\n802\n24\n2\n66\n");
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<List<Integer>> data = DataReader.readData(filename);

        assertEquals(1, data.size()); 
        assertEquals(8, data.get(0).size()); 


        List<Integer> dataset = data.get(0);
        assertArrayEquals(new Integer[]{170, 45, 75, 90, 802, 24, 2, 66}, dataset.toArray());

        new File(filename).delete();
    }

    @Test
    public void testReadDataWithMultipleDatasets() {
        String filename = "test_multiple_datasets.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Dataset size: 3\n170\n45\n75\nDataset size: 2\n90\n802\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<List<Integer>> data = DataReader.readData(filename);

        assertEquals(2, data.size());
        assertArrayEquals(new Integer[]{170, 45, 75}, data.get(0).toArray());
        assertArrayEquals(new Integer[]{90, 802}, data.get(1).toArray());
        new File(filename).delete();
    }
}

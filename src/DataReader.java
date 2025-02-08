// DataReader.java
import java.io.*;
import java.util.*;

public class DataReader {
    public List<List<Integer>> readData(String filename) {
        List<List<Integer>> datasets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            List<Integer> currentDataset = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Dataset size")) {
                    if (!currentDataset.isEmpty()) {
                        datasets.add(new ArrayList<>(currentDataset));
                        currentDataset.clear();
                    }
                } else {
                    currentDataset.add(Integer.parseInt(line.trim()));
                }
            }
            if (!currentDataset.isEmpty()) {
                datasets.add(currentDataset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datasets;
    }
}
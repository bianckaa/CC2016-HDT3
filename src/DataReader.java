/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: Data Reader.java
 * Lee un archivo .txt y extrae sus datos almacenados. 
 */
import java.io.*;
import java.util.*;

public class DataReader {
    /**
     * Lee datos desde un archivo y los guarda en listas.
     * @param filename nombre del archivo de donde se leeran los datos.
     * @return lista de lista, donce cada una es un dataset
     */
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
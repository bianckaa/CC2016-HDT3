/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: DataGenerator.java
 * Genera un archivo .txt con un número de datos aleatorios, el cual la cantidad lo decide el usuario. 
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    
    /** 
     * Genera datos aleatorios y los guarda en un archivo .txt
     * @param filename nombre del archivo donde se guardaran los datos
     * @param cantidadNumeros cantidad de numeros a generar
     */
    public void generateData(String filename, int cantidadNumeros) {
        Random rand = new Random();
        File file = new File(filename);

        try (FileWriter writer = new FileWriter(file, false)) { 
            for (int i = 0; i < cantidadNumeros; i++) {
                writer.write(rand.nextInt(1000) + "\n");
            }
            System.out.println("Los datos fueron generados correctamente en el archivo " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

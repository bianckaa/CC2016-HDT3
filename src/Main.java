/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: GnomeSort.java
 * Genera archivo txt con datos y permite elegir al usuario un algoritmo para su ordenamiento. 
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataReader reader = new DataReader();
        DataGenerator generator = new DataGenerator();

        String file = "dataset.txt";
        System.out.print("¡Bienvenido! \n");
        System.out.print("¿Cuántos números enteros desea generar? ");
        int limitSuperior = scanner.nextInt();
        System.out.println();
        generator.generateData(file, limitSuperior);
        
        List<List<Integer>> listaDeListas = reader.readData(file);
        List<Integer> lista = new ArrayList<>();
        for (List<Integer> sublista : listaDeListas) {
            lista.addAll(sublista);
        }
        
        Integer[] array = lista.toArray(new Integer[0]);

        List<IGenericSort<Integer>> algorithms = Arrays.asList(
            new InsertionSort<>(), 
            new MergeSort<>(), 
            new QuickSort<>(), 
            new GnomeSort<>(),
            new RadixSort<>());
        Integer[] arrayOrdenado = null;

        boolean menuContinuar = true;
        while (menuContinuar) {
            System.out.println("\n+ ================================================== +");
            System.out.println("                  Selección de Algoritmo             ");
            System.out.println("+ ================================================== +");
            System.out.printf("| %-5s | %-40s |\n", "N°", "Algoritmo de Ordenamiento");
            System.out.println("+ ================================================== +");
            System.out.printf("| %-5s | %-40s |\n", "1", "Insertion Sort");
            System.out.printf("| %-5s | %-40s |\n", "2", "Merge Sort");
            System.out.printf("| %-5s | %-40s |\n", "3", "Quick Sort");
            System.out.printf("| %-5s | %-40s |\n", "4", "Gnome Sort");
            System.out.printf("| %-5s | %-40s |\n", "5", "Radix Sort");
            System.out.printf("| %-5s | %-40s |\n", "6", "Salir");
            System.out.println("+ ================================================== +");
            System.out.print("Ingrese el N° del algoritmo a elegir: ");
            int choice  = scanner.nextInt();
            System.out.println();

            if (choice == 6) {
                System.out.println("Saliendo del programa...");
                if (arrayOrdenado != null) {
                    sobreescribirArchivo(arrayOrdenado, file);
                }
                menuContinuar = false;
                continue;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("Opción no válida, intente de nuevo.");
                continue;
            }
            
            IGenericSort<Integer> algorithm = algorithms.get(choice - 1);
            Integer[] arrayCopia = array.clone();
            long start = System.nanoTime();
            algorithm.sort(arrayCopia);
            long end = System.nanoTime();
            System.out.println(algorithm.getClass().getSimpleName() + " ordenó correctamente la lista en " + (end - start) + " nanosegundos");
            arrayOrdenado = arrayCopia;
        } scanner.close();
    }

    private static void sobreescribirArchivo (Integer[] arrayOrdenado, String file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Integer numero : arrayOrdenado) {
                writer.write(numero + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
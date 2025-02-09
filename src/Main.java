import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataReader reader = new DataReader();
        DataGenerator generator = new DataGenerator();
        String file = "dataset.txt";

        generator.generateData(file);
        List<List<Integer>> numeros = reader.readData(file);

        List<Integer> flatList = new ArrayList<>();
        for (List<Integer> dataset : numeros) {
            flatList.addAll(dataset);
        }

        Integer[] array = flatList.toArray(new Integer[0]);

        List<IGenericSort<Integer>> algorithms = Arrays.asList(
            new InsertionSort<>(), 
            new MergeSort<>(), 
            new QuickSort<>(), 
            new GnomeSort<>(),
            new RadixSort<>());

        while (true) {
            System.out.println("Seleccione un algoritmo de ordenamiento:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Gnome Sort");
            System.out.println("5. Radix Sort");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            
            int choice = scanner.nextInt();
            if (choice == 6) {
                System.out.println("Saliendo...");
                break;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("Opción no válida, intente de nuevo.");
                continue;
            }
            
            IGenericSort<Integer> algorithm = algorithms.get(choice - 1);
            Integer[] arrayOrdenado =null;
            for (int i = 0; i < 100; i++) {
                Integer[] arrayCopia = array.clone();
                long start = System.nanoTime();
                algorithm.sort(arrayCopia);
                long end = System.nanoTime();
                System.out.println(algorithm.getClass().getSimpleName() + " ordenó correctamente la lista en " + (end - start) + " nanosegundos");
                arrayOrdenado = arrayCopia;
            }

            sobreescribirArchivo(arrayOrdenado, file);
        }
        scanner.close();
    }

    private static void sobreescribirArchivo (Integer[] arrayOrdenado, String file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Integer numero : arrayOrdenado) {
                writer.write(numero + "\n");
            }
            System.out.println("Los datos ordenados fueron escritos correctamente en " + file);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
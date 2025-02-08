import java.util.*;

public class Main {
    public static void main(String[] args) {
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

        for(IGenericSort<Integer> algorithm : algorithms) {
            Integer[] copy = array.clone();
            long start = System.nanoTime();
            algorithm.sort(copy);
            long end = System.nanoTime();
            System.out.println(algorithm.getClass().getSimpleName() + " ordenó correctamente la lista en " + (end - start) + " nanosegundos");
        }
    }
}

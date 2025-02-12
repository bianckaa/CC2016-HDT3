/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: RadixSort.java
 * Ordena una lista de datos utilizando el algoritmo de ordenamiento Radix. 
 */
import java.util.Arrays;

public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {

    
    /** 
     * Ordena arreglo usando el algoritmo Radix Sort
     * 
     * @param array arreglo a ordenar
     * @return arreglo ordenado ascendentemente
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = (Integer) array[i]; // Cast a Integer
        }

        // máximo valor en el array
        int max = Arrays.stream(intArray).max().getAsInt();

        // Aplica Radix Sort
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(intArray, exp);
        }      
        for (int i = 0; i < array.length; i++) {
            array[i] = (T) Integer.valueOf(intArray[i]); // Cast de vuelta a T
        }

        return array; // Devuelve el array ordenado
    }

    /**
     * Itera de ordenamiento usando algoritmo Counting Sort
     * siento esto aun parte de Radix Sort
     * @param array arreglo a ordenar de manera parcial
     * @param exp posicion decimal actual usada para ordenar
     */
    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        } System.arraycopy(output, 0, array, 0, n);
    }
}

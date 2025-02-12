/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: QuickSort.java
 * Ordena una lista de datos utilizando el algoritmo de ordenamiento Quick. 
 */

public class QuickSort<T extends Comparable<T>> implements IGenericSort<T> {

    
    /** 
     * @param array
     * @return T[]
     */
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private int partition(T[] array, int left, int right) {
        T pivot = array[right]; 
        int i = left - 1; // El. más pequeño

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        // Coloca el pivote en la posición correcta
        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

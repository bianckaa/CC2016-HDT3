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
 * 
 * Referencia:
 * - Bailey, D. A. (2007). Java Structures: Data Structures in Java for the Principled Programmer (7ª ed.). McGraw-Hill.
 */

public class QuickSort<T extends Comparable<T>> implements IGenericSort<T> {

    /** 
     * Ordena arreglo usando algoritmo Quick Sort
     * 
     * @param array arreglo a ordenar
     * @return arreglo ordenado ascendentemente
     */
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /** 
     * Ordena arreglo usando algoritmo Quick Sort
     * 
     * @param array arreglo a ordenar
     * @param left indice izquierdo del subarreglo
     * @param right indice derecho del subarreglo
     */
    private void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    /**
     * Parte arreglo y coloca el pivote en una correcta posición
     * @param array arreglo a ordenar
     * @param left indice izquierdo del subarreglo
     * @param right indice derecho del subarreglo
     * @return nueva posicion del pivote
     */
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

    /** 
     * Intercambia dos elementos en el arreglo.
     * 
     * @param array arreglo donde se intercambian los elementos
     * @param i indice del primer elemento a intercambiar
     * @param j indice del segundo elemento a intercambiar
     */
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

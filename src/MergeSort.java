/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: MergeSort.java
 * Ordena una lista de datos utilizando el algoritmo de ordenamiento Merge. 
 */
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) return array;
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(T[] A, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(A, lo, mid);
        mergeSort(A, mid + 1, hi);
        merge(A, lo, mid, hi);
    }

    private void merge(T[] A, int lo, int mid, int hi) {
        T[] B = Arrays.copyOfRange(A, lo, hi + 1);
        int i = 0;
        int j = mid - lo + 1;
        int k = lo;

        while (i <= mid - lo && j <= hi - lo) {
            if (B[i].compareTo(B[j]) <= 0) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }

        while (i <= mid - lo) {
            A[k++] = B[i++];
        }

        while (j <= hi - lo) {
            A[k++] = B[j++];
        }
    }
}

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: InsertionSort.java
 * Ordena una lista de datos utilizando el algoritmo de ordenamiento Insertion. 
 * 
 * Referencia:
 * - Bailey, D. A. (2007). Java Structures: Data Structures in Java for the Principled Programmer (7ª ed.). McGraw-Hill.
 */
public class InsertionSort<T extends Comparable<T>> implements IGenericSort<T> {
    /**  
     * Ordena arreglo utilizando algoritmos de Insertion Sort.
     * 
     * @param array arreglo de elementos a ordenar
     * @return arreglo ordenado ascendentemente
     */
    @Override
    public T[] sort(T[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }
}

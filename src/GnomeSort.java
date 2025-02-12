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
 * Ordena una lista de datos utilizando el algoritmo de ordenamiento Gnome. 
 */
public class GnomeSort<T extends Comparable<T>> implements IGenericSort<T>  {
    /** 
     * Ordena arreglo utilizando algoritmo Gnome Sort
     * 
     * @param array Arreglo a ordenar
     * @return arreglo ordenado ascendentemente
     */
    @Override
    public T[] sort(T[] array) {
        int index = 0;
        int n = array.length;

        while (index < n) {
            if (index == 0 || array[index - 1].compareTo(array[index]) <= 0) {
                index++;
            } else {
                T temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
        return array;
    }
}

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 3
 * Integrantes:
 * Biancka Raxón 24960
 * Maria Jose Ramirez 221051 
 * 
 * 
 * Clase: IGenericSort.java
 * Interfaz genérica para ordenar arreglos de elementos que se puedan comparar. 
 */
import java.lang.Comparable;

public interface IGenericSort<T extends Comparable<T>> {
    public T[] sort (T[] arr);
}

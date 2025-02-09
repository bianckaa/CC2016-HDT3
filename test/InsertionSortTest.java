import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {
    @Test
    public void shouldBeAbleToSortIntegerByInsertion() {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer [] input = {5, 2, 9, 1, 5, 6, 1};
        Integer [] expected = {1, 1, 2, 5, 5, 6, 9};

        Integer [] result = insertionSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldReturnEmptyArrayWhenInputIsEmpty() {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer [] input = {};
        Integer [] expected = {};

        Integer[] result = insertionSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldReturnSameArrayWhenInputHasOneElem() {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] input = {199};
        Integer[] expected = {199};

        Integer[] result = insertionSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldBeAbleToStringByInsertion() {
        InsertionSort<String> insertionSort = new InsertionSort<>();
        String[] input = {"Torneo", "Destilar", "Ingreso", "Caliente", "Maldad", "Noticia"};
        String[] expected = {"Caliente", "Destilar", "Ingreso", "Maldad", "Noticia", "Torneo"};

        String[] result = insertionSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldNotAlterAlreadySortedArray() {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] result = insertionSort.sort(input);
        assertArrayEquals(expected, result);
    }
}

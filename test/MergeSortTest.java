import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MergeSortTest {
    @Test
    public void shouldBeAbleToSortIntegerByGnome() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer [] input = {5, 2, 9, 1, 5, 6, 1};
        Integer [] expected = {1, 1, 2, 5, 5, 6, 9};

        Integer [] result = mergeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldReturnEmptyArrayWhenInputIsEmpty() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer [] input = {};
        Integer [] expected = {};

        Integer[] result = mergeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldReturnSameArrayWhenInputHasOneElem() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] input = {199};
        Integer[] expected = {199};

        Integer[] result = mergeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldBeAbleToStringByInsertion() {
        MergeSort<String> mergeSort = new MergeSort<>();
        String[] input = {"Torneo", "Destilar", "Ingreso", "Caliente", "Maldad", "Noticia"};
        String[] expected = {"Caliente", "Destilar", "Ingreso", "Maldad", "Noticia", "Torneo"};

        String[] result = mergeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldNotAlterAlreadySortedArray() {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] result = mergeSort.sort(input);
        assertArrayEquals(expected, result);
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GnomeSortTest {
    @Test
    public void shouldBeAbleToSortIntegerByGnome() {
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        Integer [] input = {5, 2, 9, 1, 5, 6, 1};
        Integer [] expected = {1, 1, 2, 5, 5, 6, 9};

        Integer [] result = gnomeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldReturnEmptyArrayWhenInputIsEmpty() {
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        Integer [] input = {};
        Integer [] expected = {};

        Integer[] result = gnomeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldReturnSameArrayWhenInputHasOneElem() {
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        Integer[] input = {199};
        Integer[] expected = {199};

        Integer[] result = gnomeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldBeAbleToStringByInsertion() {
        GnomeSort<String> gnomeSort = new GnomeSort<>();
        String[] input = {"Torneo", "Destilar", "Ingreso", "Caliente", "Maldad", "Noticia"};
        String[] expected = {"Caliente", "Destilar", "Ingreso", "Maldad", "Noticia", "Torneo"};

        String[] result = gnomeSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test 
    public void shouldNotAlterAlreadySortedArray() {
        GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        Integer[] result = gnomeSort.sort(input);
        assertArrayEquals(expected, result);
    }
}

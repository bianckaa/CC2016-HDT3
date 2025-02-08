import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void testSort() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] array = {34, 7, 23, 32, 5, 62};
        Integer[] expected = {5, 7, 23, 32, 34, 62};
        assertArrayEquals(expected, quickSort.sort(array));
    }

    @Test
    public void testSortWithEmptyArray() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] array = {};
        Integer[] expected = {};
        assertArrayEquals(expected, quickSort.sort(array));
    }

    @Test
    public void testSortWithSingleElement() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] array = {42};
        Integer[] expected = {42};
        assertArrayEquals(expected, quickSort.sort(array));
    }
}

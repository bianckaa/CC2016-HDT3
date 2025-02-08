import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RadixSortTest {
    @Test
    void testSort() {
        RadixSort<Integer> radixSort = new RadixSort<>();
        Integer[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        
        assertArrayEquals(expected, radixSort.sort(array));
    }

    @Test
    void testEmptyArray() {
        RadixSort<Integer> radixSort = new RadixSort<>();
        Integer[] array = {};
        Integer[] expected = {};
        
        assertArrayEquals(expected, radixSort.sort(array));
    }

    @Test
    void testSingleElement() {
        RadixSort<Integer> radixSort = new RadixSort<>();
        Integer[] array = {42};
        Integer[] expected = {42};
        
        assertArrayEquals(expected, radixSort.sort(array));
    }
}

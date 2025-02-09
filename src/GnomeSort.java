public class GnomeSort<T extends Comparable<T>> implements IGenericSort<T>  {
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

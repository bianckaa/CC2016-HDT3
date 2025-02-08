import java.lang.Comparable;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T>{
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) return array;
        mergeSort(array, 0, array.length);
        return array;
    }

    private void mergeSort(T[] A, int lo, int hi) {
        if (hi - lo <= 1) return;

        int mid = (lo + hi) / 2;
        mergeSort(A, lo, mid);
        mergeSort(A, mid, hi);
        merge(A, lo, mid, hi);
    }

    private void merge(T[] A, int lo, int mid, int hi) {
        Comparable<T>[] B = new Comparable[hi - lo];
        int i = lo, j = mid, k = 0;

        while (i < mid && j < hi) {
            if (A[i].compareTo(A[j]) < 0) B[k++] = A[i++];
            else B[k++] = A[j++];
        }

        while (i < mid ) {
            B[k++] = A[i++];
        }

        while (j < hi ) {
            B[k++] = A[j++];
        }

        System.arraycopy(B, 0, A, lo, hi - lo);
    }
}

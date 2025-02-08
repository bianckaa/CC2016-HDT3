import java.util.Arrays;

public class RadixSort implements IGenericSort<Integer> {

    
    /** 
     * @param array
     * @return Integer[]
     */
    @Override
    public Integer[] sort(Integer[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        // Convertir el array de Integer a un array de enteros primitivos
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = array[i];
        }

        // max value array 
        int max = Arrays.stream(intArray).max().getAsInt();

        // Aplicar Radix Sort
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(intArray, exp);
        }

        // Convertir el array de enteros de vuelta a Integer
        for (int i = 0; i < array.length; i++) {
            array[i] = intArray[i];
        }

        return array; // Devuelve el array ordenado
    }

    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Contar la frecuencia de cada dígito
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

       
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

       
        System.arraycopy(output, 0, array, 0, n);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */
public class InsertionSort {


    /**
     * Insertion Sort
     * 
     * Execution: O(n^2)  -  Space: O(1)
     */
    static void insertionSort(int[] arr) {

        // **** sanity checks ****
        int n = arr.length;
        if (n <= 1) return;

        // **** sort array contents ****
        for (int i = 1; i < n; i++) {

            // **** key to be placed in sorted order ****
            int key = arr[i];

            // **** ****
            int j = i - 1;

            // ???? ????
            // System.out.println("<<<   i: " + i + " key: " + key + " j: " + j);

            // **** ****
            for ( ; j >= 0 && arr[j] > key; j--) {

                // **** ****
                arr[j + 1]  = arr[j];

                // // ???? ????
                // System.out.println("<<< arr: " + Arrays.toString(arr));
            }

            // **** put key in array in sorted order ****
            arr[j + 1] = key;

            // ???? ????
            // System.out.println("<<<                arr: " + Arrays.toString(arr));
        }
    }


    /**
     * Check if the elements in the array are sorted.
     */
    static boolean isSorted(int[] arr) {

        // **** sanity checks ****
        int n = arr.length;
        if (n <= 1) return true;

        // **** traverse array ****
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }

        // **** array is sorted ****
        return true;
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read data and populate array ****
        int[] arr = Arrays.stream(br.readLine().trim().split(","))
                            .map( s -> s.trim() ) 
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<<            arr: " + Arrays.toString(arr));

        // **** make a copy of the input array ****
        int[] shuffled = arr.clone();

        // **** loop a few times ****
        int n = 13;
        for (int i = 0; i < n; i++) {

            // **** get a copy of the input array ****
            arr = shuffled.clone();

            // ???? ????
            // System.out.println("main <<<            arr: " + Arrays.toString(arr));

            // **** sort the elements in the array ****
            insertionSort(arr);

            // **** check if the elements in the array are sorted ****
            boolean isSorted = isSorted(arr);
            if (isSorted && i == 0)
                System.out.println("main <<<     sorted arr: " + Arrays.toString(arr));
            else if (!isSorted) {
                System.err.println("main <<< not sorted arr: " + Arrays.toString(arr));
                System.exit(-1);
            }
        }
    }
}
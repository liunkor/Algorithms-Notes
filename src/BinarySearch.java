import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch {

    private BinarySearch() {}

    /**
     * Returns the index of the specified key in the specified array.
     * @param a the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Recursive implementation of binary search
     * @param a a sorted array
     * @param key the value to search
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int rank(int[] a, int key) {
        return rank(a, key, 0, a.length - 1);
    }

    private static int rank(int[] a, int key, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        var mid = lo + (hi - lo)/2;
        if (key == a[mid]) {
            return mid;
        }
        else if (key < a[mid]) {
            return rank(a, key, lo, mid - 1);
        }
        else  {
            return rank(a, key, mid + 1, hi);
        }
    }

    public static void main(String[] args) {
        FileInputStream input;
        ArrayList<Integer> nums = new ArrayList<>();
        try {
            // read data from file
            input = new FileInputStream(args[0]);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                nums.add(Integer.parseInt(scanner.nextLine().trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        nums.sort((a, b) -> a.compareTo(b));
        int[] numList = new int[nums.size()];
        for (int i = 0; i < nums.size() - 1; i++) {
            numList[i] = nums.get(i).intValue();
        }
        //int key = StdIn.readInt();
        int key = 9998;
        int result = indexOf(numList, key);
        if (result== -1) {
            System.out.printf("No found the number %d, result: %d \n", key, result);
        }
        else {
            System.out.printf("The index of %d is %d.\n", key, result);
        }

        int result2 = rank(numList, key);
        if (result2 == -1) {
            System.out.printf("No found the number %d, result2: %d \n", key, result2);
        }
        else {
            System.out.printf("The index of %d is %d.\n", key, result2);
        }
    }
}

package study;

import java.util.Arrays;

public class Binary {

    public static void main(String[] args) {
        int[] array = {8, 7, 2, 5, 11, 17};
        System.out.println(binarySearch(array, 7));
    }

    private static int binarySearch(int[] intArray, int target) {
        Arrays.sort(intArray);
        int low = 0;
        int high = intArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = intArray[mid];
            if(guess == target) {
                return mid;
            }else if(guess > target) {
                high = mid - 1;
            }else if(guess < target) {
                low = mid + 1;
            }
        }
        return 0;
    }

}

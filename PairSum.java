import java.util.*;

public class PairSum {
    public static void findPair(int[] arr, int target) {
        Map<Integer, Boolean> map = new HashMap<>();  // Stores visited elements
        
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists
            if (map.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + arr[i] + ")");
                return; 
            }

            // Store the current number in map
            map.put(arr[i], true);
        }

        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 10, 15};
        int target = 14;
        //output
        findPair(arr, target);
    }
}
/*Pair found: (6, 8) */
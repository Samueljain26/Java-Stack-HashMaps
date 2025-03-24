import java.util.*;

public class SumZero {
    public static void findZeroSum(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>(); //hashmap
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                System.out.println("Subarray: 0 to " + i);
            }

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        //ouput
        findZeroSum(arr);
    }
}
/*Subarray: 0 to 2
Subarray: 1 to 3
Subarray: 2 to 5
Subarray: 5 to 7
Subarray: 0 to 9
Subarray: 3 to 9 */
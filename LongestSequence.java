import java.util.*;

public class LongestSequence {
    public static int findLongestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>(); // hashmap
        for (int num : arr) {
            set.add(num);
        }
        int maxLength = 0;

        for (int num : arr) { 
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2, 5, 7, 6};
        System.out.println("Longest Consecutive Sequence Length: " + findLongestSequence(arr));
    }
}
/*Longest Consecutive Sequence Length: 7 */
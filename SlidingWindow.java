import java.util.*;

public class SlidingWindow {
    public static void findMaxInSlidingWindow(int arr[], int k) {
        Deque<Integer> dq = new LinkedList<>();  
        
        for (int i = 0; i < arr.length; i++) {
            // Remove elements that are out of the window
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();  
            }

            // Remove smaller elements 
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();  
            }

            dq.offer(i);

            // Step 4: Print the max 
            if (i >= k - 1) {
                System.out.print(arr[dq.peek()] + " "); 
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        findMaxInSlidingWindow(arr, k);
    }
}
/*3 3 5 5 6 7  */
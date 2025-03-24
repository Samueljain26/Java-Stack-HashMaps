import java.util.Stack;

public class StockSpan {
    public static void calculateSpan(int prices[], int span[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  
        span[0] = 1;    // First day's span is always 1

        for (int i = 1; i < prices.length; i++) {
            // Pop elements from stack while the price at top index is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate span
            if (stack.isEmpty()) {
                span[i] = i + 1;  // If stack is empty, entire range is valid
            } else {
                span[i] = i - stack.peek();  // Distance from last greater element
            }

            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int prices[] = {100, 80, 60, 70, 60, 75, 85};
        int span[] = new int[prices.length];

        calculateSpan(prices, span);

        // Print results 
        System.out.println("Stock Prices & Span:");
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Price: " + prices[i] + " -> Span: " + span[i]);
        }
    }
}
/*Stock Prices & Span:
Price: 100 -> Span: 1
Price: 80 -> Span: 1
Price: 60 -> Span: 1
Price: 70 -> Span: 2
Price: 60 -> Span: 1
Price: 75 -> Span: 4
Price: 85 -> Span: 6 */
import java.util.Stack;

public class StackSorting {
    
    // Function to sort a stack using recursion
    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
          
            int temp = stack.pop();
            sortStack(stack);
            
//Insert the popped element back in sorted order
            insertSorted(stack, temp);
        }
    }
    static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
  
        int temp = stack.pop();
        

        insertSorted(stack, element);
        
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        
        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
/*Original Stack: [3, 1, 4, 2, 5]
Sorted Stack: [1, 2, 3, 4, 5] */
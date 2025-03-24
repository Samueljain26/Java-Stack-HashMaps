import java.util.*;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    //method to add in stack
    void enqueue(int data) {
        stack1.push(data);
    }

    int dequeue() {
        //method to remove
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    //method to view element at first in queue
    int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}

// Main class 
class Main {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Peek: " + queue.peek());     
        queue.enqueue(40);
        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Dequeue: " + queue.dequeue()); 
    }
}
/*Dequeue: 10
Peek: 20
Dequeue: 20
Dequeue: 30
Dequeue: 40 */
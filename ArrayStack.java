import java.util.*;

class ArrayStack {    
    public char[] stack;
    public int capacity;
    protected int top = -1;

    
    public ArrayStack(int len) {
        capacity = len;
        stack = new char[len];
    }

    
    public int size() {
        return (top + 1);
    }

    
    public void push(char data) {
        if (isFull()) {
            System.out.println("Stack Overflow. Cannot insert into full stack.");
        } else {
            stack[++top] = data;
        }
    }

    
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. No elements to pop from empty stack.");
            return '\0';  // Return null character if the stack is empty
        } else {
            char data = stack[top];
            top--;
            return data;
        }
    }

    
    public boolean isFull() {
        return (size() == capacity);
    }

    
    public boolean isEmpty() {
        return (top < 0);
    }

    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. No elements to display in empty stack.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to reverse:");

        
        String str = sc.nextLine();
        ArrayStack arrStack = new ArrayStack(str.length());

        
        for (int i = 0; i < str.length(); i++) {
            arrStack.push(str.charAt(i));
        }

        System.out.println("Elements are inserted into the stack using push.");
        arrStack.display();

        
        System.out.println("Reversed string using pop:");
        StringBuilder reversedStr = new StringBuilder();
        while (!arrStack.isEmpty()) {
            reversedStr.append(arrStack.pop());
        }
        System.out.println(reversedStr.toString());
    }
}

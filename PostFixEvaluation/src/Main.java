import java.io.File;
import java.util.Scanner;

class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node top;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        int value = top.data;
        top = top.next;
        return value;
    }
}

class Queue {
    Node front, rear;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = newNode;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public int dequeue() {
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }
}

public class Main {

    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Jeremy\\Desktop\\CSC 130\\PostFixEvaluation\\src\\input.txt");
        System.out.println(postFixEvaluation(file));
    }

    public static int postFixEvaluation(File file) throws Exception{
        Stack stack = new Stack();
        Queue q = new Queue();
        Scanner s = new Scanner(file);
        String input = s.next();

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (Character.isDigit(curr)) {
                stack.push(Character.getNumericValue(curr));
            }
            else {
                int right = stack.pop();
                int left = stack.pop();
                int result = 0;
                if (curr == '+') {
                    result = left + right;
                }
                else if (curr == '-') {
                    result = left - right;
                }
                else if (curr == '*') {
                    result = left * right;
                }
                else if (curr == '/') {
                    result = left / right;
                }
                stack.push(result);
            }
        }
        int num = stack.pop();
        q.enqueue(num);
        return q.dequeue();
    }
}

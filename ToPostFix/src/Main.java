import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Node {
    Node next;
    char data;
    Node(char data) {
         this.data = data;
    }
}

class Queue {
    Node front, rear;
    public void enqueue(char c) {
        Node newNode = new Node(c);
        if (front == null) {
            front = newNode;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
    }
    public char dequeue() {
        char c = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return c;
    }
}

class Stack {
    Node top;

    public void push(char val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        char value = top.data;
        top = top.next;
        return value;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Jeremy\\Desktop\\CSC 130\\ToPostFix\\src\\input.txt");
        String postFix = inToPost(file);
        System.out.println(postFix);
    }

    public static int getPrecedence(char sign) {
        int precedence;
        switch (sign) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            default:
                precedence = -1;
        }
        return precedence;
    }

    public static String inToPost(File file) throws IOException {
        Stack stack = new Stack();
        Queue q = new Queue();
        Scanner s = new Scanner(file);
        String input = s.next();
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);

            if (Character.isDigit(curr)) {
                q.enqueue(curr);
            }
            else if(curr == '('){
                stack.push(curr);
            }
            else if(curr == ')') {
                while (stack.top != null) {
                    if (stack.top.data != '(') {
                        q.enqueue(stack.pop());
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            else {
                while (stack.top != null && getPrecedence(curr) <= getPrecedence(stack.top.data)) {
                    if (curr != '(') {
                        q.enqueue(stack.pop());
                    }
                    else {
                        stack.pop();
                    }
                }
                stack.push(curr);
            }
        }
        while (stack.top != null) {
            q.enqueue(stack.pop());
        }
        while (q.front != null) {
            output += q.dequeue();
        }

        return output;
    }
}


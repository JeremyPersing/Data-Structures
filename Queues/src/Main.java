import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
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
        if (front == null && rear == null) {
            throw new NoSuchElementException();
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }

        return value;
    }

    public String returnPositives(File file) throws Exception{
        String str = "";
        Scanner s = new Scanner(file);
        while (s.hasNextInt()) {
            int nextInt = s.nextInt();
            if (nextInt >= 0) {
                enqueue(nextInt);
            }
        }
        while (front != null) {
            str += dequeue() + " ";
        }
        return str;
    }
}

public class Main {

    public static void main(String[] args) throws Exception{
        File input = new File("C:\\Users\\Jeremy\\Desktop\\CSC 130\\Queues\\src\\input.txt");
        Queue queue = new Queue();
        // input contains the numbers -1, 0, -2, 5, -4, 100, 2, -3, 4, 5
        System.out.println(queue.returnPositives(input));
    }
}

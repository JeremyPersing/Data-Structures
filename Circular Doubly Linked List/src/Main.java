import java.util.*;
import java.io.*;

class Node {
    Node next, prev;
    String data;
    Node (String data) {
        this.data = data;
    }
}

class CircularLinkedList {
    Node head;

    void add(String str) {
        Node nn = new Node(str);
        if (head == null) {
            head = nn;
            nn.prev = nn;
            nn.next = nn;
        }
        else {
            nn.next = head;
            nn.prev = head.prev;
            head.prev = nn;
            nn.prev.next = nn;
            head = nn;
        }
    }

    void delete(int num) {
        int size = num;
        while (size > 0) {
            if (head.next != head) {
                head.next.prev = head.prev;
                head.prev.next = head.next;
                head = head.next;
                size--;
            }
            else {
                System.out.println("Your List is empty");
                head = null;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        CircularLinkedList cll = new CircularLinkedList();
        File file = new File("C:\\Users\\Jeremy\\Desktop\\CSC 130\\Circular Doubly Linked List\\src\\input.txt");
        Scanner s = new Scanner(file);
        Scanner keyboard = new Scanner(System.in);

        while (s.hasNext()) {
            String current = s.nextLine();
            cll.add(current);
        }
        System.out.println("How many nodes do you want to remove?");
        int num = keyboard.nextInt();
        cll.delete(num);
        Node curr = cll.head;
        do {
            System.out.println(curr.data);
            curr = curr.next;
        } while (curr != cll.head);
    }
}

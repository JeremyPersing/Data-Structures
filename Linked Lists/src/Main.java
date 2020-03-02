class Node {
    int value;
    Node next;

    Node(int data) {
        value = data;
    }

    int getValue() {
        return value;
    }

    void setNextNode(Node n) {
        next = n;
    }

    Node getNextNode() {
        return next;
    }
}

class LinkedList {
    Node head;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.setNextNode(head);
        head = newNode;
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size += 1;
            current = current.getNextNode();
        }
        return size;
    }

    public int get(int index) {
        int count = 0;
        Node current = head;
        if (index < 0 || index >= size()) {
            throw new NullPointerException();
        }
        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            count++;
            current = current.getNextNode();
        }
        return -1;
    }

    public void removeFirst() {
        Node current = head;
        current = head.getNextNode();
        head = head.getNextNode();
        current = null;
    }

    public String toString() {
        String str = "";
        Node current = head;
        while (current != null) {
            str += current.getValue();
            if (current.getNextNode() != null) {
                str += ", ";
            }
            current = current.getNextNode();
        }
        return str;
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        }

        if (head != null && index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        while (count < index) {
            previous = current;
            current = current.next;
            count++;
        }

        newNode.next = current;
        previous.next = newNode;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

}

public class Main {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList ll2 = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        System.out.println("Printing the Linked List: " + ll.toString());
        System.out.println("Size of the linked list: " + ll.size());
        System.out.println("Getting the value at index 0: " + ll.get(0));
        System.out.println("Getting the value at index 1: " + ll.get(1));
        ll2.addFirst(1);
        ll2.addFirst(2);
        ll2.addFirst(3);
        ll2.removeFirst();
        System.out.println("Removing the first element: " + ll2.toString());
        ll2.insert(2, 0);
        System.out.println("Inserting 0 as the last element: " + ll2.toString());
        ll2.insert(0, 4);
        System.out.println("Inserting 4 as the first element: " + ll2.toString());
        ll2.insert(1, 3);
        System.out.println("Inserting 3 at index 1: " + ll2.toString());
        ll2.addLast(-1);
        System.out.println("Inserting -1 at the last index using addLast(): " + ll2.toString());
    }


}

import java.util.Scanner;

class Node {
    char key;
    Node left, right, next;
    Node(char key) {
        this.key = key;
        right = left = null;
    }
}

class Stack {
    Node top;


    void push(Node n) {
        n.next = top;
        top = n;
    }

    Node pop() {
        Node n = top;
        top = top.next;
        return n;
    }
}

class ExpressionTree {
    boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^') {
            return true;
        }
        return false;
    }

    void inOrder(Node root) {
        if (root != null) {
            System.out.print(" (");
            inOrder(root.left);
            System.out.print(root.key);
            inOrder(root.right);
            System.out.print(") ");
        }
    }

    Node createTree(char [] arr) {
        Stack stack = new Stack();
        Node t, t1, t2;
        for (int i = 0; i < arr.length; i++) {
            if (!isOperator(arr[i])) {
//                System.out.println("Char: " + arr[i] + " pushed to stack");
                t = new Node(arr[i]);
            }
            else {
//                System.out.println("Creating new Node t " + arr[i]);
                t = new Node(arr[i]);

                t1 = stack.pop();
                t2 = stack.pop();
//                System.out.println("Popped value t1: " + t1.key);
//                System.out.println("Popped value t2: " + t2.key);

//                System.out.println("Assigning t1 to t.right");
                t.right = t1;
//                System.out.println("Assigning t2 to t.left");
                t.left = t2;
//                System.out.println("Pushing t");

            }
            stack.push(t);

        }

        t = stack.pop();
//        System.out.println("T value about to be returned " + t.key);

//        System.out.println("Stack top after pop: " + stack.top);
        return t;
    }
}


public class Main {

    public static void main(String[] args) {
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("Enter your expression");
	    String str = keyboard.nextLine();
	    char [] arr = str.toCharArray();
        ExpressionTree tree = new ExpressionTree();
        Node root = tree.createTree(arr);
        tree.inOrder(root);
    }

}

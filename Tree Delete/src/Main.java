import java.util.Scanner;
import java.io.File;

class Queue {
    Node front, rear;

    void enqueue(Node n) {
        if (front == null) {
            front = rear = n;
        }
        else {
            rear.next = n;
            rear = rear.next;
        }
    }

    void dequeue() {
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

}


class Node {
    Node right, left, next;
    int key;
    Node(int key) {
        this.key = key;
        right = left = null;
    }
}

class BinaryTree {
    Node root;

    void insert(int value) {
        Node leaf = root;
        boolean done = false;
        if (root == null) {
            root = new Node(value);
        }
        else {
            while (!done) {
                if (value == leaf.key) {
                    done = true;
                }
                else if(value < leaf.key) {
                    if (leaf.left == null) {
                        leaf.left = new Node(value);
                        done = true;
                    }
                    else {
                        leaf = leaf.left;
                    }
                }
                else {
                    if (leaf.right == null) {
                        leaf.right = new Node(value);
                        done = true;
                    }
                    else {
                        leaf = leaf.right;
                    }
                }
            }
        }
    }

    Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.key) {
            root.left = delete(root.left, value);
        }
        else if (value > root.key) {
            root.right = delete(root.right, value);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }


    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }

    boolean nodeExists(int value) {
        Node leaf = root;
        while (leaf != null) {
            if (value == leaf.key) {
                return true;
            }
            else if (value < leaf.key) {
                leaf = leaf.left;
            }
            else {
                leaf = leaf.right;
            }
        }
        return false;
    }

    void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(root);

        while (q.front != null) {
            Node current = q.front;
            System.out.print(current.key + " ");

            if (current.left != null) {
                q.enqueue(current.left);
            }
            if (current.right != null) {
                q.enqueue(current.right);
            }

            q.dequeue();
        }
    }
}


public class Main {

    public static void main(String[] args) throws Exception {
        File input = new File("C:\\Users\\Jeremy\\Desktop\\CSC 130\\Tree Delete\\input.txt");
	    Scanner s = new Scanner(input);
        BinaryTree bt = new BinaryTree();


        String str = "";
        while (s.hasNextLine()) {
            str += s.nextLine() + ",";
        }
        String [] inputs = str.split(",");
        for (int i = 0; i < inputs.length; i++) {

            if (inputs[i].charAt(0) != 'd'){
                bt.insert(Integer.parseInt(inputs[i]));
            }

            else {
                String scanned = inputs[i];
                String num = "";
                for (int j = 0; j < scanned.length(); j++) {
                    if (scanned.charAt(j) < 58 && scanned.charAt(j) > 47) {
                        num += scanned.charAt(j);
                    }
                }
                int number = Integer.parseInt(num);

                if (bt.nodeExists(number)) {
                    bt.delete(bt.root, number);
                }
                else {
                    bt.insert(number);
                }
            }
        }
        System.out.println("Pre-Order");
        bt.preOrder(bt.root);
        System.out.println("In-Order");
        bt.inOrder(bt.root);
        System.out.println("Post-Order");
        bt.postOrder(bt.root);
        System.out.println("Breadth Level");
        bt.levelOrder(bt.root);
    }
}

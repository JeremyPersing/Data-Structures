import java.io.File;
import java.io.IOException;
import java.util.Scanner;


class Node {
    Node  same, left, right;
    String key;
    Node(String str) {
        key = str;
        right = left = null;
    }
}

class BinaryTree {
    Node root;

    void insert(String str) {
        Node leaf = root;
        boolean done = false;
        if (root == null) {
            root = new Node(str);
        }
        else {
            while (!done) {
                if (leaf.key.compareToIgnoreCase(str) == 0) {
                    if (leaf.same == null) {
                        leaf.same = new Node(str);
                        done = true;
                    }
                    else {
                        leaf = leaf.same;
                    }
                }
                else if (leaf.key.compareToIgnoreCase(str) < 0) {
                    if (leaf.left == null) {
                        leaf.left = new Node(str);
                        done = true;
                    }
                    else {
                        leaf = leaf.left;
                    }
                }
                else {
                    if (leaf.right == null) {
                        leaf.right = new Node(str);
                        done = true;
                    }
                    else {
                        leaf = leaf.right;
                    }
                }
            }
        }
    }

    String findNode(String str) {
        Node curr = root;
        String endResult = "";

        while (curr != null) {
            if(str.compareToIgnoreCase(curr.key) == 0) {
                int count = 0;
                if (curr.same != null) {
                    while (curr != null) {
                        count += 1;
                        curr = curr.same;
                    }
                    System.out.println("Duplicates: " + count);
                    endResult += str;
                }
                else {
                    endResult += curr.key;
                }
                return endResult;
            }
            else if(str.compareToIgnoreCase(curr.key) > 0) {
                endResult += curr.key + ", ";
                curr = curr.left;
            }
            else {
                endResult += curr.key + ", ";
                curr = curr.right;
            }
        }

        return "Name not found";
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BinaryTree tree = new BinaryTree();
        Scanner s = new Scanner(new File("C:\\Users\\Jeremy\\Desktop\\CSC 130\\Linked Lists\\names.txt"));
        while(s.hasNext()) {
            tree.insert(s.nextLine().toLowerCase());
        }
        System.out.println("List of the names: Dan, Phil, Angela, Ayesha, Kai, Zia, Troy, Troy, Troy, Dan");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a name to see the path");
        String str = keyboard.nextLine();
        System.out.print(tree.findNode(str));
    }
}

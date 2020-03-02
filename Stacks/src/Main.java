import java.util.EmptyStackException;

class Node {
    Node next;
    int data;
    Node(int value) {
        data = value;
    }

}

class Stack {
    Node top;
    int length;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop() {
        int value = top.data;
        top = top.next;
        length--;
        return value;
    }
}

class NumberConversion {
    Stack thisStack = new Stack();

    public String toBinary(int value) {
        String binary = "";
        int temp;
        if (value == 0) {
            binary += value;
        }
        else {
            while (value != 0) {
                temp = value % 2;
                thisStack.push(temp);
                value = value / 2;
            }
        }
        while (thisStack.length > 0) {
            int currentValue = thisStack.pop();
            binary += currentValue;
        }
        return binary;
    }

    public String toHex(int value) {
        String hex = "";
        if (value == 0) {
            hex += 0;
        }
        else {
            while (value != 0) {
                thisStack.push(value % 16);
                value = value / 16;
            }
        }
        while (thisStack.length > 0) {
            int poppedNum = thisStack.pop();
            if (poppedNum < 10) {
                hex += poppedNum;
            }
            switch (poppedNum) {
                case 10:
                    hex += "A";
                    break;
                case 11:
                    hex += "B";
                    break;
                case 12:
                    hex += "C";
                    break;
                case 13:
                    hex += "D";
                    break;
                case 14:
                    hex += "E";
                    break;
                case 15:
                    hex += "F";
                    break;
                default:
                    break;
            }
        }

        return hex;
    }
}

public class Main {

    public static void main(String[] args) {
        NumberConversion binary = new NumberConversion();
        NumberConversion hex = new NumberConversion();
        System.out.println("Binary value of 10: " + binary.toBinary(10));
        System.out.println("Binary value of 15: " + binary.toBinary(15));
        System.out.println("Hexadecimal value of 65: " + hex.toHex( 65));
        System.out.println("Hexadecimal value of 30: " + hex.toHex( 30));
    }
}

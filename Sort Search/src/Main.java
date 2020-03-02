import java.util.*;

public class Main {
    public static final int ARR[][] = {{5, 3, 2, 16},
                                        {9, 8, 10, 17},
                                        {4, 7, 11, 18},
                                        {2, 5, 9, 12},
                                        {7, 9, 4, 10}};

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Bubble Sort \n-------------");
	    bubbleSort(ARR, ARR.length - 1);
	    System.out.println("\nSelection Sort \n------------");
        selectionSort(ARR, ARR.length - 1);
        System.out.println("\nShell Sort \n" + "------------");
        shellSort(ARR, ARR.length);
        System.out.println("\nInsertion Sort\n" + "-----------");
        int [][] insertArr = insertionSort(ARR);
        System.out.println("Enter a number from the last row of the Insertion sort and I will display that column");
        int num = keyboard.nextInt();
        System.out.println("That column contains :");
        binarySearch(insertArr, num);
    }

    public static void bubbleSort(int [][] arr, int limit) {
        int temp;
        int [][] newArr = new int[5][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        for (; limit > 0; limit--) {
            for (int j = 0; j < limit; j++) {
                if (newArr[j][0] > newArr[j + 1][0]) {
                    temp = newArr[j][0];
                    newArr[j][0] = newArr[j + 1][0];
                    newArr[j + 1][0] = temp;
                }
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(Arrays.toString(newArr[i]));
        }
    }

    public static void selectionSort(int [][] arr, int limit) {
        int temp, indexSmallest;
        int [][] newArr = new int[5][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        for (; limit > 0; limit--) {
            indexSmallest = 0;
            for (int i = 1; i <= limit; i++) {
                if (newArr[i][1] < newArr[indexSmallest][1]) {
                    indexSmallest = i;
                }
            }
            if (limit != indexSmallest) {
                temp = newArr[limit][1];
                newArr[limit][1] = newArr[indexSmallest][1];
                newArr[indexSmallest][1] = temp;
            }

        }

        for (int j = 0; j < newArr.length; j++) {
            System.out.println(Arrays.toString(newArr[j]));
        }
    }

    public static void shellSort(int arr[][], int length) {
        int [][] newArr = new int[5][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        int temp;
        for (int gap = length/2; gap >= 1; gap/=2) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && newArr[j - gap][2] > newArr[j][2]; j -= gap) {
                    temp = newArr[j - gap][2];
                    newArr[j - gap][2] = newArr[j][2];
                    newArr[j][2] = temp;
                }
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(Arrays.toString(newArr[i]));
        }
    }

    public static int[][] insertionSort(int [][] arr) {
        int [][] newArr = new int[5][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        int temp;
        for (int i = 1; i < newArr[4].length; i++) {
            int key = newArr[4][i];
            int j = i - 1;
            while ((j >= 0) && (key < newArr[4][j])) {
                temp = newArr[4][j];
                arr[4][j] = newArr[4][j + 1];
                newArr[4][j + 1] = temp;
                j--;
            }
            newArr[4][j + 1] = key;
        }

        for (int i = 0; i < newArr.length; i++) {
            System.out.println(Arrays.toString(newArr[i]));
        }
        return newArr;
    }

    public static void binarySearch(int [][] arr, int key) {
        int end = arr[4].length - 1;
        int start = 0;
        int mid;
        int [] newArr = new int[5];
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[4][mid] == key) {
                for (int i = 0; i < arr.length; i++) {
                    newArr[i] = arr[i][mid];
                    System.out.println(newArr[i]);
                }
                break;
            }
            else if (key < arr[4][mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
    }
}

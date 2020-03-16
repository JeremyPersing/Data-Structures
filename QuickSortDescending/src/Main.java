public class Main {

    public static void main(String[] args) {
        int [] arr = {12, 3, 6, 18, 72, 65, 26, 99, 23, 45, 67, 889};
        descendingQuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int partition(int [] arr, int start, int end) {
        int pivot = arr[end];
        int i = end;
        int j = start;

        while (j < i) {
            while (arr[i] <= pivot) {
                if (i == start) {
                    break;
                }
                i--;
            }

            while (arr[j] > pivot) {
                if (j == end) {
                    break;
                }
                j++;
            }

            if (j < i) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[end];
        arr[end] = arr[j];
        arr[j] = temp;
        return i;
    }

    public static void descendingQuickSort(int arr [], int start, int end) {
        if (start < end) {
            int i = partition(arr, start, end);
            descendingQuickSort(arr, start, i);
            descendingQuickSort(arr, i + 1, end);
        }
    }
}

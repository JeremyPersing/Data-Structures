public class Main {

    public static void main(String[] args) {
	    int [] arr = {5, 4, 10, 15, 22, 13, 64, 28};
	    quickSort(arr, 0, arr.length - 1);
	    for (int i = 0; i < arr.length; i++) {
	        System.out.print(arr[i] + " ");
        }
    }

    public static int partition(int [] arr, int low, int high) {
        int pivot  = arr[low];
        int i = low;
        int j = high;
        while (i < j) {

            while (arr[i] <= pivot) {
                if (i == high) {
                    break;
                }
                i++;
            }

            while (arr[j] > pivot) {
                if (j == 0) {
                    break;
                }
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }


    public static void quickSort(int arr [], int low, int high) {
        if (low < high) {
            int j = partition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);
        }
    }
}

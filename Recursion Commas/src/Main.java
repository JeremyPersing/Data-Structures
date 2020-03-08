class RecursiveFunction {
    public void addCommas(int value) {
        String str = "";
        String numsToDisplay = "";
        if (value < 999) {
            System.out.print(value);
        }
        else {
            addCommas(value / 1000);
            str += value;
            char [] arr = str.toCharArray();
            for (int i = arr.length - 3; i < arr.length; i++) {
                numsToDisplay += arr[i];
            }
            System.out.print("," + numsToDisplay);
        }
    }
}


public class Main {

    public static void main(String[] args) {
        RecursiveFunction r = new RecursiveFunction();
        r.addCommas(725135111);
        System.out.print("\n");
        r.addCommas(1111);
        System.out.print("\n");
        r.addCommas(2136756);

    }

}

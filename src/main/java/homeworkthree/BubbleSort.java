package homeworkthree;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {31, 432, 3, 42, 51, 999, -1};
        boolean flag;

        for (int j = 0; j < intArray.length - 1; j++) {
            flag = false;

            for (int i = 0; i < intArray.length - 1 - j; i++) {
                if (intArray[i] > intArray[i + 1]) {

                    int temp = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
        for (int num : intArray) {
            System.out.print(num + " ");
        }
    }
}

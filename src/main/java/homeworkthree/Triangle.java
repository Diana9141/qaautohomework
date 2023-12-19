package homeworkthree;

public class Triangle {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                System.out.print(" ");
            }
            int k = 1;
                while (k <= i * 2 - 1) {
                    System.out.print("*");
                    k++;
                }
                System.out.println();
        }
    }
}

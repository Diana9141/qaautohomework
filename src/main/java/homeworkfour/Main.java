package homeworkfour;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Put the numerator №1: ");
        Scanner scanner = new Scanner(System.in);
        int numerator = scanner.nextInt();

        System.out.println("Put the denominator №1: ");
        Scanner scanner2 = new Scanner(System.in);
        int denominator = scanner2.nextInt();

        Fraction fraction1 = new Fraction(numerator, denominator);

        System.out.println("Put the numerator №2: ");
        Scanner scanner3 = new Scanner(System.in);
        int numerator2 = scanner3.nextInt();

        System.out.println("Put the denominator №2: ");
        Scanner scanner4 = new Scanner(System.in);
        int denominator2 = scanner4.nextInt();

        Fraction fraction2 = new Fraction(numerator2, denominator2);
        System.out.println(fraction1.equals(fraction2));
    }
}

package homework4;

import homework2.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Put the numerator №1: ");
        Scanner scanner = new Scanner(System.in);
        Integer numerator = scanner.nextInt();

        System.out.println("Put the denominator №1: ");
        Scanner scanner2 = new Scanner(System.in);
        Integer denominator = scanner2.nextInt();

        Fraction fraction1 = new Fraction(numerator, denominator);

        System.out.println("Put the numerator №2: ");
        Scanner scanner3 = new Scanner(System.in);
        Integer numerator2 = scanner3.nextInt();

        System.out.println("Put the denominator №2: ");
        Scanner scanner4 = new Scanner(System.in);
        Integer denominator2 = scanner4.nextInt();

        Fraction fraction2 = new Fraction(numerator2, denominator2);
        System.out.println(fraction1.equals(fraction2));
    }
}

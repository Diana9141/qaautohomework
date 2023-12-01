package homework2;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Put in the current exchange rate: ");
        Scanner scanner = new Scanner(System.in);

        BigDecimal exchangeRate = scanner.nextBigDecimal();

        System.out.println("Put in the current commission in %: ");

        BigDecimal commissionInserted = scanner.nextBigDecimal();
        BigDecimal commission = commissionInserted.divide(BigDecimal.valueOf(100));

        CurrencyConverter currencyConverter = new CurrencyConverter(commission, exchangeRate);
        System.out.println("Put in the sum in dollars: ");

        BigDecimal sumInDollars = scanner.nextBigDecimal();

        BigDecimal result = currencyConverter.calculateTotalAmount(sumInDollars);
        String finalResult = new DecimalFormat("#0.00").format(result);

        System.out.println("You receive: "+ finalResult + " hrn");
    }
}
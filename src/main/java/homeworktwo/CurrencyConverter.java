package homeworktwo;

import java.math.BigDecimal;

public class CurrencyConverter {
    private BigDecimal commission;
    private BigDecimal exchangeRate;

    public CurrencyConverter(BigDecimal commission, BigDecimal exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    private BigDecimal convertToUah(BigDecimal dollarSum) {
        return dollarSum.multiply(exchangeRate);
    }

    private BigDecimal calculateCommission(BigDecimal convertedSum) {
        return convertedSum.multiply(commission);
    }

    public BigDecimal calculateTotalAmount(BigDecimal clientSum) {
        BigDecimal convertedSum = convertToUah(clientSum);
        return convertedSum.subtract(calculateCommission(convertedSum));
    }
}
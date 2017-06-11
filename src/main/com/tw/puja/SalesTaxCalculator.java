package com.tw.puja;

/**
 * Created by pujag on 6/11/17.
 */
public class SalesTaxCalculator {
    public static final double BASIC_TAX_RATE = 10;
    public static final double IMPORT_TAX_RATE = 5;

    public  static double roundOff(double input) {
        return (Math.round(input * 100)) / 100.00;
    }

    public  static double calculateTax(double itemPrice, boolean isTaxExempted, boolean isImported) {
        double tax = 0;
        if (!isTaxExempted)
            tax += BASIC_TAX_RATE * itemPrice / 100;
        if (isImported)
            tax += IMPORT_TAX_RATE * itemPrice / 100;
        return roundOff(tax);
    }


}

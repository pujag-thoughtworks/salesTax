package com.tw.puja;

import org.junit.Test;

import static com.tw.puja.SalesTaxCalculator.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by pujag on 6/11/17.
 */
public class SalesTaxCalculatorTest {
    double BASIC_TAX_RATE = 0.1;
    double IMPORT_TAX_RATE = 0.05;

    @Test
    public void shouldProvideCorrectSalesTaxForDifferentTypesOFInputs() {
        double priceOfPerfumeBottle = 14.99;
        double priceOfImportedChoclateBox = 10;
        assertEquals(roundOff(BASIC_TAX_RATE * priceOfPerfumeBottle), calculateTax(priceOfPerfumeBottle, false, false), 0);
        assertEquals(roundOff((IMPORT_TAX_RATE) * priceOfImportedChoclateBox), calculateTax(priceOfImportedChoclateBox, true, true), 0);

    }
}

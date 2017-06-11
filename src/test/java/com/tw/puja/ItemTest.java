package com.tw.puja;

import org.junit.Test;

import static com.tw.puja.SalesTaxCalculator.*;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public  void shouldCheckIfItemtIsTaxExempted() {
        Item item=new Item("packet of headache pills",9.75,1);
        assertTrue(item.isTaxExempted());
    }

    @Test
    public void shouldCheckIfItemIsImported() {
        Item item = new Item(" imported Box of chocolates", 11.3, 1);
        assertTrue(item.isImported());
    }

    @Test
    public void shouldProvideCorrectSalesTaxValue() {
        double priceOfItem = 10;
        Item item = new Item(" imported Box of chocolates", priceOfItem, 1);
        assertEquals(roundOff(IMPORT_TAX_RATE * priceOfItem/100), item.getSalesTax(), 0.00);

    }

    @Test
    public void shouldProvideTaxInclusivePrice() {
        double itemPrice = 12.9;
        Item item = new Item("music cd", itemPrice, 1);
        assertEquals(itemPrice + item.getSalesTax(), item.getTaxInclusivePrice(), 0.005);

    }

    @Test
    public void itemsWithEqualFieldsShouldBeEqual() {
        Item item1 = new Item(" imported Box of chocolates", 67.2, 1);
        Item item2 = new Item(" imported Box of chocolates", 67.2, 1);
        assertEquals(item1, item2);
    }

}

package com.tw.puja;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    public static final double BASIC_TAX_RATE =0.1;
    public static final double IMPORT_TAX_RATE=0.05;
    @Test
    public void shouldFindIfItemIsExemptedFromTaxes() {
        Item item1=new Item("Box of chocolates", 12.56, 1);
        Item item2=new Item("Bottle  of perfume ", 40, 1);
        assertTrue(item1.isTaxExempted());
        assertFalse(item2.isTaxExempted());
    }

    @Test
    public void shouldProvideCorrectSalesTaxForDifferentTypesOFInputs() {
        double priceOfItem1=12.9;
        double priceOfItem2=14.99;
        double priceOfItem3=10;
        Item item1=new Item("book",priceOfItem1,1);
        Item item2=new Item("music cd",priceOfItem2, 1);
        Item item3=new Item(" imported Box of chocolates", priceOfItem3, 1);
        assertEquals(0,item1.getSalesTax(),0.005);
        assertEquals(BASIC_TAX_RATE *priceOfItem2,item2.getSalesTax(),0.005);
        assertEquals(IMPORT_TAX_RATE*priceOfItem3,item3.getSalesTax(),0.005);

    }
    @Test
    public void shouldProvideTaxInclusivePrice() {
        double itemPrice=12.9;
        Item item=new Item("music cd",itemPrice, 1);
        assertEquals(itemPrice+item.getSalesTax(),item.getTaxInclusivePrice(),0.005);

    }
}

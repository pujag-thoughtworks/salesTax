package com.tw.puja;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void shouldFindIfItemIsExemptedFromTaxes() {
        Item item1=new Item("Box of chocolates", 12.56, 1);
        Item item2=new Item("Bottle  of choclate ", 40, 1);
        assertTrue(item1.isTaxExempted());
        assertFalse(item2.isTaxExempted());
    }
}

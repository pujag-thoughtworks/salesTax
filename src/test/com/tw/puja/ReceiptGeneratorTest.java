package com.tw.puja;

import com.tw.exceptions.EmptyItemListException;
import com.tw.exceptions.IllegalInputFormatException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by pujag on 6/10/17.
 */
public class ReceiptGeneratorTest {

    @Test(expected = EmptyItemListException.class)
    public void shouldThrowExceptionWhenTryingToGenerateReceiptOfEmptyShopingBasket() {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        ReceiptGenerator receiptGenerator = new ReceiptGenerator(shoppingBasket);
        ArrayList<String> receipt = receiptGenerator.generateReceipt();
    }


    @Test
    public void shouldGenerateDesiredReceiptForGivenShoppingBasket()  throws IllegalInputFormatException{
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItem("1 book at 12.49");
        shoppingBasket.addItem("1 music CD at 14.99");
        shoppingBasket.addItem("1 chocolate bar at 0.85");
        ArrayList<String> expectedReceipt = generateExpectedReceipt();
        ReceiptGenerator receiptGenerator = new ReceiptGenerator(shoppingBasket);
        assertEquals(expectedReceipt, receiptGenerator.generateReceipt());

    }

    public ArrayList<String> generateExpectedReceipt() {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("1 book - 12.49");
        expectedList.add("1 music CD - 16.49");
        expectedList.add("1 chocolate bar - 0.85");
        expectedList.add("Sales Taxes - 1.50");
        expectedList.add("Total - 29.83");
        return expectedList;
    }
}

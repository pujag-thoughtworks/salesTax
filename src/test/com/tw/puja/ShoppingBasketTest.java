package com.tw.puja;

import com.tw.exceptions.IllegalInputFormatException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShoppingBasketTest {
    @Test
    public void shouldNotBeEmptyAfterAddingItem() throws IllegalInputFormatException {
        ShoppingBasket cart = new ShoppingBasket();
        cart.addItem("1 book at 12.49");
        ArrayList<Item> cartItems = cart.getItems();
        assertTrue(!cartItems.isEmpty());
    }

    @Test
    public void shouldIdentifyCorrectItemFieldsFromStringInputForCorrectInputCreation() throws IllegalInputFormatException {
        ShoppingBasket cart = new ShoppingBasket();
        cart.addItem("1 book at 12.49");
        ArrayList<Item> cartItems = cart.getItems();
        Item expectedItem=new Item("book",12.49,1);
        Item actualItem=cartItems.get(0);
        assertEquals(expectedItem,actualItem);
    }

    @Test
    public void shouldCheckIfTheInputFormatIsStrong() {
        ShoppingBasket cart = new ShoppingBasket();
        String exampleString="1 chocolate bar at 0.85";
        assertEquals(true,cart.isInputFormatCorrect(exampleString));
    }

}

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





    @Test(expected = IllegalInputFormatException.class)
    public void shouldNotAcceptInputIfNotInFormat() throws IllegalInputFormatException {
        ShoppingBasket cart = new ShoppingBasket();
        cart.addItem("chocolate bar at 0.85");
    }
}

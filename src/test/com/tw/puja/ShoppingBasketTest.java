package com.tw.puja;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShoppingBasketTest {
    @Test
    public void shouldNotBeEmptyAfterAddingItem() {
        ShoppingBasket cart=new ShoppingBasket();
        cart.addItem("1 book at 12.49");
        ArrayList<Item> cartItems=cart.getItems();
        assertTrue(!cartItems.isEmpty());
    }
}

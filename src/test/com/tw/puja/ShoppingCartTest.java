package com.tw.puja;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    @Test
    public void shouldNotBeEmptyAfterAddingItem() {
        ShoppingCart cart=new ShoppingCart();
        cart.addItem("1 book at 12.49");
        ArrayList<Item> cartItems=cart.getItems();
        assertTrue(!cartItems.isEmpty());
    }
}

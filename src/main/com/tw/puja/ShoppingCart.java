package com.tw.puja;

import java.util.HashMap;

/**
 * Class to hold all the shopping items.
 */
public class ShoppingCart {
    private HashMap<Item,Integer> itemWithQuantity;

    ShoppingCart() {
        itemWithQuantity =new HashMap<>();
    }

    public void addItem(String inputString) {
        inputString=inputString.trim();
        int indexOfFirstSpace=inputString.indexOf(" ");
        int itemQuantity= Integer.parseInt(inputString.substring(0,indexOfFirstSpace));
        inputString=inputString.substring(indexOfFirstSpace+1);
        String[] itemString=inputString.split(" at ");
        Item item=new Item(itemString[0],Double.parseDouble(itemString[1]));
        itemWithQuantity.put(item,itemQuantity);

    }

    public HashMap<Item,Integer> getItems() {
        return itemWithQuantity;
    }
}

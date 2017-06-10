package com.tw.puja;

import java.util.ArrayList;

/**
 * Class to hold all the shopping items.
 */
public class ItemList {
    private ArrayList<Item> items;

    ItemList() {
        items =new ArrayList<>();
    }

    public void addItem(String inputString) {
        inputString=inputString.trim();
        int indexOfFirstSpace=inputString.indexOf(" ");
        int itemQuantity= Integer.parseInt(inputString.substring(0,indexOfFirstSpace));
        inputString=inputString.substring(indexOfFirstSpace+1);
        String[] itemString=inputString.split(" at ");
        Item item=new Item(itemString[0],Double.parseDouble(itemString[1]),itemQuantity);
        items.add(item);

    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

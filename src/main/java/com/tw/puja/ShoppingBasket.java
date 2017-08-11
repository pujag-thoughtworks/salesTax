package com.tw.puja;

import com.tw.exceptions.IllegalInputFormatException;

import java.util.ArrayList;

/**
 * Class to hold all the shopping items.
 */
public class ShoppingBasket {
    private ArrayList<Item> items;
    private InputParser inputParser;

    public ShoppingBasket() {
        items = new ArrayList<>();
        inputParser=new InputParser();
    }

    public void addItem(String inputString) throws IllegalInputFormatException {
        Item item=inputParser.createItems(inputString);
        items.add(item);

    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

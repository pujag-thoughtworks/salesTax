package com.tw.puja;

import com.tw.exceptions.IllegalInputFormatException;

import java.util.ArrayList;
import java.util.regex.*;

/**
 * Class to hold all the shopping items.
 */
public class ShoppingBasket {
    private ArrayList<Item> items;

    public ShoppingBasket() {
        items = new ArrayList<>();
    }

    public boolean isInputFormatCorrect(String input) {
        Pattern requiredFormat = Pattern.compile("[1-9]\\d*[\\s\\w]+\\sat\\s\\d+(\\.\\d{1,2})?");
        Matcher matcher = requiredFormat.matcher(input);
        return matcher.matches();
    }

    public void addItem(String inputString) throws IllegalInputFormatException {
        inputString = inputString.trim();
        if(!isInputFormatCorrect(inputString))
            throw  new IllegalInputFormatException();
        int indexOfFirstSpace = inputString.indexOf(" ");
        int itemQuantity = Integer.parseInt(inputString.substring(0, indexOfFirstSpace));
        inputString = inputString.substring(indexOfFirstSpace + 1);
        String[] itemString = inputString.split(" at ");
        Item item = new Item(itemString[0], Double.parseDouble(itemString[1]), itemQuantity);
        items.add(item);

    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

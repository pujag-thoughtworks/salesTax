package com.tw.puja;

import com.tw.exceptions.IllegalInputFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pujag on 6/12/17.
 */
public class InputParser {

    public boolean isInputFormatCorrect(String input) {
        Pattern requiredFormat = Pattern.compile("[1-9]\\d*[\\s\\w]+\\sat\\s\\d+(\\.\\d{1,2})?");
        Matcher matcher = requiredFormat.matcher(input);
        return matcher.matches();
    }
    public  Item createItems(String inputString) throws
            IllegalInputFormatException {
        inputString = inputString.trim();
        if (!isInputFormatCorrect(inputString))
            throw new IllegalInputFormatException();
        int indexOfFirstSpace = inputString.indexOf(" ");
        int itemQuantity = Integer.parseInt(inputString.substring(0, indexOfFirstSpace));
        inputString = inputString.substring(indexOfFirstSpace + 1);
        String[] itemString = inputString.split(" at ");
        Item item = new Item(itemString[0], Double.parseDouble(itemString[1]), itemQuantity);
        return item;
    }
}

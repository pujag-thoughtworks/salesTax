package com.tw.puja;

import com.tw.exceptions.IllegalInputFormatException;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by pujag on 6/13/17.
 */
public class InputParserTest {
    @Test
    public void shouldCheckIfTheInputFormatIsStrong() {
        InputParser parser = new InputParser();
        String exampleString = "1 chocolate bar at 0.85";
        assertTrue(parser.isInputFormatCorrect(exampleString));
    }

    public void shouldIdentifyCorrectItemFieldsFromStringInputForCorrectInputCreation() throws IllegalInputFormatException {
        InputParser parser = new InputParser();
        Item actualItem=parser.createItems("1 book at 12.49");
        Item expectedItem = new Item("book", 12.49, 1);
        assertEquals(expectedItem, actualItem);
    }
}

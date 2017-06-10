/**
 * Template for bill structure
 */

package com.tw.puja;
public class Item {
    private String itemName;
    private double itemPrice;

    Item(String itemName, double itemPrice) {
        this.itemName=itemName;
        this.itemPrice=itemPrice;
    }

    @Override
    public String toString() {
        return itemName + " @ " + itemPrice;
    }
}

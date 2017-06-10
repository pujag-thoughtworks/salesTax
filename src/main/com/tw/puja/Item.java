/**
 * Template for bill structure
 */

package com.tw.puja;

import java.util.ArrayList;

public class Item {
    public static final String IMPORTED="imported ";
    public static final String[] taxExemptedGoods={"book","chocolate","pill"};
    private String itemName;
    private double itemPrice;
    private int quantity;
    private boolean isImported;

    Item(String itemName, double itemPrice, int quantity) {
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.quantity=quantity;
        isImported=itemName.contains(IMPORTED);
    }
    public boolean isTaxExempted() {
        for (String taxExemptedGood : taxExemptedGoods) {
            if (itemName.contains(taxExemptedGood))
                return true;
        }
        return false;
    }


   /* public double computeSalesTax() {
        double tax;
        if()
    } */
}

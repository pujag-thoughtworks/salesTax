/**
 * Template for bill structure
 */

package com.tw.puja;

public class Item {
    public static final String IMPORTED = "imported ";
    private String itemName;
    private double itemPrice;
    private int noOfCopies;
    private boolean isImported;
    private boolean isTaxExempted;

    Item(String itemName, double itemPrice, int noOfCopies) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.noOfCopies = noOfCopies;
        isImported = itemName.contains(IMPORTED);
        isTaxExempted= TaxExemptedItems.isTaxExempted(itemName);

    }
    public double getSalesTax() {
        double salesTax=SalesTaxCalculator.calculateTax(itemPrice,isTaxExempted,isImported);
        return noOfCopies * salesTax;
    }

    public double getTaxInclusivePrice() {
        return (itemPrice + getSalesTax()) * noOfCopies;
    }


    @Override
    public String toString() {
        return noOfCopies + " " + itemName;
    }

    @Override
    public boolean equals(Object object) {
        Item item = (Item) object;
        if (!(item instanceof Item))
            return false;
        return (itemName.equals(item.itemName) && itemPrice == item.itemPrice && noOfCopies == item.noOfCopies);
    }

    public boolean isTaxExempted() {
        return isTaxExempted;
    }

    public boolean isImported() {
        return isImported;
    }
}

/**
 * Template for bill structure
 */

package com.tw.puja;


public class Item {
    public static final String IMPORTED="imported ";
    public static final String[] taxExemptedGoods={"book","chocolate","pill"};
    public static final int BASIC_TAX_RATE=10;
    public static final int IMPORT_TAX_RATE=5;
    private String itemName;
    private double itemPrice;
    private int noOfCopies;
    private boolean isImported;

    Item(String itemName, double itemPrice,int noOfCopies) {
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.noOfCopies=noOfCopies;
        isImported=itemName.contains(IMPORTED);
    }
    public boolean isTaxExempted() {
        for (String taxExemptedGood : taxExemptedGoods) {
            if (itemName.contains(taxExemptedGood))
                return true;
        }
        return false;
    }


    private double computeSalesTax() {
        double tax=0;
        if(!isTaxExempted())
            tax+=BASIC_TAX_RATE*itemPrice/100;
        if(isImported)
            tax+=IMPORT_TAX_RATE*itemPrice/100;
        return tax;
    }

    public double getTaxInclusivePrice() {
        return (itemPrice+ computeSalesTax())*noOfCopies;
    }

    public double getSalesTax() {
        return noOfCopies*computeSalesTax();
    }

    

}

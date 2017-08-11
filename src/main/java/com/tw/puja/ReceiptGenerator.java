package com.tw.puja;

import com.tw.exceptions.EmptyItemListException;

import java.util.ArrayList;

/**
 * Created by pujag on 6/10/17.
 */
public class ReceiptGenerator {
    ShoppingBasket shoppingBasket;
    ArrayList<String> receipt;

    public ReceiptGenerator(ShoppingBasket shoppingBasket) {
        if (shoppingBasket == null)
            throw new IllegalArgumentException();
        this.shoppingBasket = shoppingBasket;
        receipt = new ArrayList<>();
    }

    public ArrayList<String> generateReceipt() {
        ArrayList<Item> items = shoppingBasket.getItems();
        if (items.isEmpty())
            throw new EmptyItemListException();
        double totalTax = 0;
        double totalAmount = 0;
        for (Item item : items) {
            double taxInclusivePrice = item.getTaxInclusivePrice();
            String itemDetails = item.toString() + " - " + String.format("%.2f", taxInclusivePrice);
            receipt.add(itemDetails);
            totalTax += item.getSalesTax();
            totalAmount += taxInclusivePrice;
        }
        String taxDetails = "Sales Taxes - " + String.format("%.2f", totalTax);
        receipt.add(taxDetails);
        String total = "Total - " + String.format("%.2f", totalAmount);
        receipt.add(total);

        return receipt;

    }


}

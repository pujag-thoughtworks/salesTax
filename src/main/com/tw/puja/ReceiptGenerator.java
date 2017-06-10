package com.tw.puja;

import com.tw.exceptions.EmptyItemListException;

import java.util.ArrayList;

/**
 * Created by pujag on 6/10/17.
 */
public class ReceiptGenerator {
    ShoppingBasket shoppingBasket;
    ArrayList<String> receipt;

    ReceiptGenerator(ShoppingBasket shoppingBasket)  {
        if(shoppingBasket ==null)
            throw new IllegalArgumentException();
        this.shoppingBasket = shoppingBasket;
        receipt=new ArrayList<>();
    }

    public ArrayList<String> generateReceipt()  {
        ArrayList<Item> items= shoppingBasket.getItems();
        if(items.isEmpty())
            throw new EmptyItemListException();
        double totalTax=0;
        double totalAmount=0;
        for(Item item:items) {
            String itemDetails=item.toString() +" - " +item.getTaxInclusivePrice();
            receipt.add(itemDetails);
            totalTax+=item.getSalesTax();
            totalAmount+=item.getTaxInclusivePrice();
        }
        String taxDetails="Sales Taxes - " +totalTax;
        receipt.add(taxDetails);
        String total="Total - " +totalAmount;
        receipt.add(total);

        return receipt;

    }


}

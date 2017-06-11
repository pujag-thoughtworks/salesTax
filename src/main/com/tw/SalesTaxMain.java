package com.tw;

import com.tw.exceptions.IllegalInputFormatException;
import com.tw.puja.ReceiptGenerator;
import com.tw.puja.ShoppingBasket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pujag on 6/11/17.
 */
public class SalesTaxMain {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        for(int inputNo=1;inputNo<=3;inputNo++) {
            ShoppingBasket shoppingBasket=new ShoppingBasket();
            String inputString=bufferedReader.readLine();
                while(inputString.length()!=0) {
                try {
                    shoppingBasket.addItem(inputString);
                }
                catch(IllegalInputFormatException e) {
                    System.out.println("Invalid input, Enter again");
                }
                inputString=bufferedReader.readLine();
                }
            ReceiptGenerator receiptGenerator=new ReceiptGenerator(shoppingBasket);
            ArrayList<String> receipt=receiptGenerator.generateReceipt();
            for(String receiptItem:receipt)
                System.out.println(receiptItem);

        }
        bufferedReader.close();
    }
}

package com.tw.puja;

/**
 * Created by pujag on 6/11/17.
 */
public enum TaxExemptedItems {
    book,chocolate,pill;

    public static boolean isTaxExempted(String input) {
        for(TaxExemptedItems item: TaxExemptedItems.values()) {
            if(input.contains(String.valueOf(item)))
                return true;
        }
        return false;
    }
}

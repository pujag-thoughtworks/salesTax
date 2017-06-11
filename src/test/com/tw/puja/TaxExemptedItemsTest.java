package com.tw.puja;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by pujag on 6/11/17.
 */
public class TaxExemptedItemsTest {

    @Test
    public void shouldFindIfGivenItemIsTaxExemptedOrNot() {
            assertFalse(TaxExemptedItems.isTaxExempted("imported bottle of perfume"));
            assertTrue(TaxExemptedItems.isTaxExempted("packet of headache pills"));
    }
}

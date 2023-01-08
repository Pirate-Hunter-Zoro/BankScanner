package org.bankscanner.Quarter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class QuarterTest {

    /**
     * A simple test to ensure that the fields for parents are showing up correctly
     */
    @Test
    public void testParentDictionary() {
        Quarter firstQuarter = new Quarter(2022, Month.September); // 2328 parent fields
        assertEquals(427, firstQuarter.getParents().keySet().size());
        for (HashMap parent : firstQuarter.getParents().values()) {
            assertEquals(2328, parent.size());
        }

        Quarter secondQuarter = new Quarter(2022, Month.June); // 2327 parent fields
        assertEquals(3958, secondQuarter.getParents().keySet().size());
        for (HashMap parent : secondQuarter.getParents().values()) {
            assertEquals(2327, parent.size());
        }
    }

    /**
     * A simple test to ensure that fields for banks are showing
     */
    @Test
    public void testBankDictionary() {

    }

}
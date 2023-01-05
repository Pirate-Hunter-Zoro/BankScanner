package org.bankscanner.Quarter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class QuarterTest {

    /** Variable setup for the tests */
    private static Quarter FIRST_QUARTER;
    private static Quarter SECOND_QUARTER;

    /**
     * Run this method right before all tests
     */
    @BeforeEach
    public void setup() {
        FIRST_QUARTER = new Quarter(2022, Month.June); // 2329 parent fields
        SECOND_QUARTER = new Quarter(2022, Month.March); // 2328 parent fields
    }

    /**
     * A simple test to ensure that the fields for parents are showing up correctly
     */
    @Test
    public void testParentDictionary() {
        assertEquals(3958, FIRST_QUARTER.getParents().keySet().size());
        for (HashMap parent : FIRST_QUARTER.getParents().values()) {
            assertEquals(2328, parent.size());
        }
    }

    /**
     * A simple test to ensure that fields for banks are showing
     */
    @Test
    public void testBankDictionary() {

    }

}
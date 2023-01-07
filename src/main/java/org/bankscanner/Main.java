package org.bankscanner;

import org.bankscanner.Quarter.Month;
import org.bankscanner.Quarter.Quarter;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Quarter firstQuarter = new Quarter(2022, Month.September); // 2328 parent fields
        Quarter secondQuarter = new Quarter(2022, Month.June); // 2327 parent fields

        if (427 == firstQuarter.getParents().keySet().size()){
            System.out.println("first test passed");
        }
        boolean rightSize = true;
        for (HashMap parent : firstQuarter.getParents().values()) {
            rightSize = 2327 == parent.size();
        }
        if (rightSize)
            System.out.println("WE DON'T SCAN ALL PARENT FIELDS - WTF!?!? Missing one...");

        if (3958 == secondQuarter.getParents().keySet().size()){
            System.out.println("third test passed");
        }
        for (HashMap parent : secondQuarter.getParents().values()) {
            rightSize = 2326 == parent.size();
        }
        if (rightSize)
            System.out.println("WE DON'T SCAN ALL PARENT FIELDS - WTF!?!? Missing one...");

        // TODO: find what the last field value scanned was - which field is missing? Is it the last one? We skip the ID... But we're still missing one...

    }
}
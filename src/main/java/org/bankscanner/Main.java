package org.bankscanner;

import org.bankscanner.Quarter.Month;
import org.bankscanner.Quarter.Quarter;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Quarter firstQuarter = new Quarter(2022, Month.September); // 2328 parent fields
        System.out.println(427 == firstQuarter.getParents().keySet().size());
        boolean right = true;
        for (HashMap parent : firstQuarter.getParents().values()) {
            right = (2328 == parent.size());
        }
        System.out.println(right);

        Quarter secondQuarter = new Quarter(2022, Month.June); // 2327 parent fields
        System.out.println(3958 == secondQuarter.getParents().keySet().size());
        for (HashMap parent : secondQuarter.getParents().values()) {
            right = (2327 == parent.size());
        }
        System.out.println(right);
    }
}
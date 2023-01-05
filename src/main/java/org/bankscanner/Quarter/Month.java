package org.bankscanner.Quarter;

import java.util.Comparator;

/**
 * What months could a quarter start at?
 */
public enum Month {
    /** There are exactly four {@link Month} objects in existence - here they are */
    March(3, 31),
    June(6, 30),
    September(9, 30),
    December(12, 31);

    /** Which number month? 4 possibilities */
    private final int monthNumber;

    /** How many days are in this {@link Month}? */
    private final int numDays;

    /** How to compare two {@link Month}s? This genius code call is DEFINITELY from IntelliJ suggestions. */
    public static final Comparator<Month> MONTH_COMPARATOR = Comparator.comparingInt(month -> month.monthNumber);

    /**
     * Private constructor for a  {@link Month}
     * @param monthNumber - integer
     */
    Month(int monthNumber, int numDays) {
        this.monthNumber = monthNumber;
        this.numDays = numDays;
    }

    /**
     * Simple getter for the number of days in this {@link Month}
     * @return int
     */
    public int getNumDays() {
        return this.numDays;
    }
}

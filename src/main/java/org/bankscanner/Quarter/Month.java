package org.bankscanner.Quarter;

import java.util.Comparator;

/**
 * What months could a quarter start at?
 */
public enum Month {
    March(3),
    June(6),
    September(9),
    December(12);

    /** Which number month? 4 possibilities */
    private final int monthNumber;

    /** How to compare two {@link Month}s? This genius code call is DEFINITELY from IntelliJ suggestions. */
    public static final Comparator<Month> MONTH_COMPARATOR = Comparator.comparingInt(month -> month.monthNumber);

    /**
     * Private constructor for a  {@link Month}
     * @param monthNumber - integer
     */
    Month(int monthNumber) {
        this.monthNumber = monthNumber;
    }
}

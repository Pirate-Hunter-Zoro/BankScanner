/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Mikey Ferguson
 * Section: 02
 * Date: 1/1/23
 * Time: 1:00 PM
 *
 * Project: BankScanner
 * Package: org.bankscanner
 * Class: Quarter
 *
 * Description:
 *
 * *****************************************/

package org.bankscanner.Quarter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Representative of a certain 3 months during a particular year
 */
public class Quarter {

    /** Regular expression for the reading in the fields of parents */
    private static final String PARENT_FIELDS_REGEX = "(?<!\\w)([A-Z]{4}\\w{3}\\d)(?=[\\^\\n])";

    /** {@link Pattern} which finds field matches */
    private static final Pattern FIELD_PATTERN = Pattern.compile(PARENT_FIELDS_REGEX);

    /** The earliest year in which we have interest */
    private static final int MIN_YEAR = 2007;

    /** Year in which this quarter takes place */
    private final int year;

    /** Month in the year that this quarter begins */
    private final Month month;

    /** Contains all the information for all Banks in this quarter */
    private final HashMap<String, HashMap<String, String>> banks;

    /** Contains all the information for all Parents in this quarter */
    private final HashMap<String, HashMap<String, String>> parents;

    /**
     * Only two parameters are necessary to have all the information needed to create a quarter
     * @param year - int
     * @param month - int
     */
    public Quarter(int year, Month month) {
        this.year = Math.max(MIN_YEAR, year);
        this.month = month;

        this.banks = this.scanForBanks();
        this.parents = this.scanForParents();
    }

    /**
     * How to compare to {@link Quarter}s?
     */
    public static final Comparator<Quarter> QUARTER_COMPARATOR = (quarter1, quarter2) -> (quarter1.year - quarter2.year + (Month.MONTH_COMPARATOR.compare(quarter1.month, quarter2.month)));

    private HashMap<String, HashMap<String, String>> scanForBanks() {
        HashMap<String, HashMap<String, String>> scanResult = new HashMap<>();

        return scanResult;
    }

    private HashMap<String, HashMap<String, String>> scanForParents() {
        HashMap<String, HashMap<String, String>> scanResult = new HashMap<>();

        return scanResult;
    }

}
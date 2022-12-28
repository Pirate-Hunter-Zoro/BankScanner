/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Mikey Ferguson
 * Section: 02
 * Date: 12/26/22
 * Time: 2:29 PM
 *
 * Project: BankScanner
 * Package: org.bankscanner.Readers
 * Class: ParentScanner
 *
 * Description:
 *
 * *****************************************/

package org.bankscanner.Readers;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ParentScanner {

    /** Regular expression for the reading in the fields of parents */
    private static final String PARENT_FIELDS_REGEX = "([A-Z]{4})([\\w]){4}";

    /** {@link Pattern} which finds field matches */
    private static final Pattern FIELD_PATTERN = Pattern.compile(PARENT_FIELDS_REGEX);

    /** Contains all the fields */
    public static ArrayList<String> fields;

    /** Regular expression for the assets of a parent in a file */
    private static final String ASSETS_REGEX =
            "(?<=\\n)" +
            "(" +
                 "(" +
                    "(" +
                        "([\\d\\-\\.]*)" +
                        "|" +
                        "([a-zA-Z\\s\\.\\,\\s\\d]*)" +
                    ")" +
                    "(\\^)" +
                 ")" +
                 "*" +
            ")" +
            "(" +
                "([\\d\\-\\.]*)" +
                "|" +
                "([a-zA-Z\\s\\.\\,\\s\\d]*)" +
            ")" +
            "(?=\\n)";
    // (?<=\n)(((([\d\-\.]*)|([a-zA-Z\s\.\,\s\d]*))(\^))*)(([\d\-\.]*)|([a-zA-Z\s\.\,\s\d]*))(?=\n)

    /** {@link Pattern} which finds asset amounts */
    private static final Pattern ASSET_PATTERN = Pattern.compile(ASSETS_REGEX);

    /**
     * Read in the fields from all the files for all banks
     */
    private ParentScanner() {
        if (fields == null) {
            fields = new ArrayList<>();
        }
    }

}
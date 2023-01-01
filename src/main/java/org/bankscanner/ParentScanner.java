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

package org.bankscanner;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ParentScanner {

    /** Regular expression for the reading in the fields of parents */
    private static final String PARENT_FIELDS_REGEX = "(?<!\\w)([A-Z]{4}\\w{3}\\d)(?=[\\^\\n])";

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
     * Public method which scans for new files every time
     * */
    public static void ScanFiles() {
        if (fields == null) {
            new ParentScanner();
        }
    }

    /**
     * Read in the fields from all the files for all banks
     */
    private ParentScanner() {
        fields = new ArrayList<>();

        HashSet<String> fields1 = new HashSet<>();
        HashSet<String> fields2 = new HashSet<>();

        // source: https://stackoverflow.com/questions/3154488/how-do-i-iterate-through-the-files-in-a-directory-and-its-sub-directories-in-ja
        File parentDirectory = new File("src/main/resources/parents");
        File[] parentFiles = parentDirectory.listFiles();

        // just look through the first file - you'll see all the fields
        try (FileInputStream inStream = new FileInputStream(parentFiles[0])) {
            Scanner scanner = new Scanner(inStream);
            while (scanner.findWithinHorizon(FIELD_PATTERN, 0) != null) {
                MatchResult fileFields = scanner.match();
                String field = fileFields.group(1);
                fields.add(field);
                fields1.add(field);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream inStream = new FileInputStream(parentFiles[1])) {
            Scanner scanner = new Scanner(inStream);
            while (scanner.findWithinHorizon(FIELD_PATTERN, 0) != null) {
                MatchResult fileFields = scanner.match();
                String field = fileFields.group(1);
                fields2.add(field);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String field : fields1) {
            if (!fields2.contains(field)){
                System.out.println(field);
            }
        }

        for (String field : fields2) {
            if (!fields1.contains(field)){
                System.out.println(field);
            }
        }
    }

}
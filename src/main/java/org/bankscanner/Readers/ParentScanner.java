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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ParentScanner {

    /** Regular expression for the reading in the fields of parents */
    private static final String PARENT_FIELDS_REGEX = "([A-Z]{4})([\\w]{4})";

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

        ArrayList<File> parents = new ArrayList<>();
        try (Stream<Path> filePath = Files.walk(Paths.get("src/main/resources"))) {
            filePath.forEach(path -> {
                parents.add(new File(path.toUri()));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // just look through the first file - you'll see all the fields
        for (File parentFile : parents) {
            try (FileInputStream inStream = new FileInputStream(parentFile)) {
                Scanner scanner = new Scanner(inStream);
                while (scanner.findWithinHorizon(FIELD_PATTERN, 0) != null) {
                    MatchResult fileFields = scanner.match();
                    String field = fileFields.group(0) + fileFields.group(1);
                    fields.add(field);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

}
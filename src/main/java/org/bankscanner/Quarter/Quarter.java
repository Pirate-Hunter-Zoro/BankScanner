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
 * Description: Scans all banks and parents given a date/quarter
 *
 * *****************************************/

package org.bankscanner.Quarter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static org.bankscanner.Quarter.Month.*;

/**
 * Representative of a certain 3 months during a particular year
 */
public class Quarter {

    /** Regular expression for the reading in the fields of parents */
    private static final String PARENT_FIELDS_REGEX = "(?<!\\w)([A-Z]{4}\\w{3}\\d)(?=[\\^\\n])";

    /** {@link Pattern} which finds field matches in parent files */
    private static final Pattern PARENT_FIELD_PATTERN = Pattern.compile(PARENT_FIELDS_REGEX);

    /** The earliest year in which we have interest */
    private static final int MIN_YEAR = 2007;

    /** Year in which this quarter takes place */
    private final int year;

    /** Month in the year that this quarter begins */
    private final Month month;

    /** Depending on the month and year, this will affect which suffix we want in the bank files that have information pertaining to this {@link Quarter} */
    private final String bankFilesSuffix;

    /** Depending on the month and year, this will affect which suffix we want in the parent file that has information pertaining to this {@link Quarter} */
    private final String parentFileSuffix;

    /** All available parent fields for this {@link Quarter} */
    private final ArrayList<String> parentFields;

    /** All available bank fields for this {@link Quarter} */
    private final ArrayList<String> bankFields;

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

        // set up year and month
        this.year = Math.max(MIN_YEAR, year);
        this.month = month;

        // find out what names on the files we should be looking for
        String yearAsString = Integer.toString(year);
        String bankYearSuffix = yearAsString.substring(yearAsString.length() - 2);
        switch (month) {
            case March -> {
                this.bankFilesSuffix = "03" + March.getNumDays() + bankYearSuffix + ".SDF";
                this.parentFileSuffix = "03" + March.getNumDays() + yearAsString + ".txt";
            }
            case June -> {
                this.bankFilesSuffix = "06" + June.getNumDays() + bankYearSuffix + ".SDF";
                this.parentFileSuffix = "06" + June.getNumDays() + yearAsString + ".txt";
            }
            case September -> {
                this.bankFilesSuffix = "09" + September.getNumDays() + bankYearSuffix + ".SDF";
                this.parentFileSuffix = "09" + September.getNumDays() + yearAsString + ".txt";
            }
            default -> { // December
                this.bankFilesSuffix = "12" + December.getNumDays() + bankYearSuffix + ".SDF";
                this.parentFileSuffix = "12" + December.getNumDays() + yearAsString + ".txt";
            }
        }

        // set up lists of fields
        this.bankFields = new ArrayList<>();
        this.parentFields = new ArrayList<>();

        // set up dictionaries
        this.banks = new HashMap<>();
        this.parents = new HashMap<>();

        // fill in the above ArrayList's and create the dictionaries of all the banks, each with its corresponding dictionary of fields -> assets
        this.scanForBanks();
        // create the dictionary of all the parents, each with its corresponding dictionary of fields -> assets
        this.scanForParents();
    }

    /**
     * How to compare to {@link Quarter}s?
     */
    public static final Comparator<Quarter> QUARTER_COMPARATOR = (quarter1, quarter2) -> (quarter1.year - quarter2.year + (Month.MONTH_COMPARATOR.compare(quarter1.month, quarter2.month)));

    /**
     * Create the dictionary of data for this {@link Quarter} for all parents
     * @return {@link HashMap}
     */
    private void scanForParents() {
        // source: https://stackoverflow.com/questions/3154488/how-do-i-iterate-through-the-files-in-a-directory-and-its-sub-directories-in-ja
        File parentDirectory = new File("src/main/resources/parents");
        File[] parentFiles = parentDirectory.listFiles();

        // scan to find all the fields
        assert parentFiles != null;
        loadParentFields(parentFiles);
    }

    /**
     * Create the dictionary of data for this {@link Quarter} for all banks
     * @return {@link HashMap}
     */
    private void scanForBanks() {
        // now for the banks
        File bankDirectory = new File("src/main/resources/banks");
        File[] bankFiles = bankDirectory.listFiles();

        // just look every file because each file is a bank, but each Quarter therefore corresponds to a BUNCH of bank files
        assert bankFiles != null;
        loadBankFields(bankFiles);
    }

    /**
     * Find all the fields belonging to parents during this {@link Quarter}
     * @param parentFiles {@link File[]}
     */
    private void loadParentFields(File[] parentFiles) {
        // ONLY ONE parent file contributes to the dictionary of data - we want all possible fields
        for (File parentFile : parentFiles) {
            String fileName = parentFile.getName();
            int nameLength = fileName.length();
            if (fileName.substring(nameLength - this.parentFileSuffix.length(), nameLength).equals(this.parentFileSuffix)) {
                // we found the correct parent file, which contains information on ALL parents for this quarter
                try (FileInputStream inStream1 = new FileInputStream(parentFile); FileInputStream inStream2 = new FileInputStream(parentFile)) {
                    // find all the field names - the first one is the RSSD Identifier
                    Scanner fieldScanner = new Scanner(inStream1);
                    boolean idBurned = false;
                    while (fieldScanner.findWithinHorizon(PARENT_FIELD_PATTERN, 0) != null) {
                        if (!idBurned) {
                            fieldScanner.match();
                            idBurned = true;
                        } else {
                            MatchResult fileFields = fieldScanner.match();
                            String field = fileFields.group(1);
                            this.parentFields.add(field);
                        }
                    }

                    // now we need to scan through the file - each line is a field
                    Scanner parentScanner = new Scanner(inStream2);
                    parentScanner.nextLine();
                    while (parentScanner.hasNextLine()) {
                        // scan a line/row of this file, and edit the dictionary accordingly
                        String parent = parentScanner.nextLine();
                        Scanner individualParentScanner = new Scanner(parent);
                        individualParentScanner.useDelimiter("\\^");
                        String identifier = individualParentScanner.next();
                        this.parents.put(identifier, new HashMap<>());
                        int fieldIndex = 1;
                        while (individualParentScanner.hasNext()) {
                            if (fieldIndex < this.parentFields.size()) {
                                this.parents.get(identifier).put(this.parentFields.get(fieldIndex++), individualParentScanner.next());
                            } else {
                                break;
                            }
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                // there will only be one matching file
            }
        }
    }

    /**
     * Find all the fields belonging to banks during this {@link Quarter}
     * @param bankFiles {@link File[]}
     */
    private void loadBankFields(File[] bankFiles) {
        // only one bank file is necessary to find all possible bank fields for this quarter
        for (File bankFile : bankFiles) {
            String fileName = bankFile.getName();
            int nameLength = fileName.length();
            if (fileName.substring(nameLength - this.bankFilesSuffix.length(), nameLength).equals(this.bankFilesSuffix)) {
                // we found a correct bank file, which contains information on a certain bank for this quarter
                try (FileInputStream inStream = new FileInputStream(bankFile)) {
                    // first skip past the heading line
                    Scanner fileScanner = new Scanner(inStream);
                    fileScanner.nextLine();

                    // now we are ready to add to our map
                    boolean scannedIdentifier = false;
                    while (fileScanner.hasNextLine()) {
                        Scanner fieldScanner = new Scanner(fileScanner.nextLine());
                        fieldScanner.useDelimiter(";");
                        // the first entry is the date - we already have this information contained within this class
                        fieldScanner.next();
                        String identifier = fieldScanner.next();
                        if (!scannedIdentifier) {
                            this.banks.put(identifier, new HashMap<>());
                            scannedIdentifier = true;
                        }
                        // now comes the field - the next two items in the row
                        this.banks.get(identifier).put(fieldScanner.next(), fieldScanner.next());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Overridden method to determine if an {@link Object} is equivalent to this {@link Quarter} are equal
     * @param obj {@link Object}
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Quarter)){
            return false;
        } else {
            Quarter other = (Quarter) obj;
            return QUARTER_COMPARATOR.compare(this, other) == 0;
        }
    }

    /**
     * Overridden method to yield a hashcode for this {@link Quarter}
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.year, this.month);
    }

    /**
     * Getter for a copy of the banks dictionary
     * @return {@link HashMap}
     */
    public HashMap<String, HashMap<String, String>> getBanks() {
        return (HashMap<String, HashMap<String, String>>) banks.clone();
    }

    /**
     * Getter for a copy of the parents dictionary
     * @return {@link HashMap}
     */
    public HashMap<String, HashMap<String, String>> getParents() {
        return (HashMap<String, HashMap<String, String>>) parents.clone();
    }
}
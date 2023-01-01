package org.bankscanner;

import org.bankscanner.Readers.ParentScanner;

public class Main {
    public static void main(String[] args) {
        ParentScanner.ScanFiles();
        System.out.println(ParentScanner.fields.size());
    }
}
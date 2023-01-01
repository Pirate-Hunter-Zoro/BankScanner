package org.bankscanner;

public class Main {
    public static void main(String[] args) {
        ParentScanner.ScanFiles();
        System.out.println(ParentScanner.fields.size());
    }
}
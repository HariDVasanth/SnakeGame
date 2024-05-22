package com.zsgs.scanner;

import java.util.Scanner;

public class ScannerGet {
    private static Scanner scanner;
    public static Scanner getInstance(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}

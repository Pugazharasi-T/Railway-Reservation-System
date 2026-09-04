package org.anudip.rrs.util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg) {
        System.out.print(msg);
        int value = sc.nextInt();
        sc.nextLine();      // Consume newline
        return value;
    }

    public static double getDouble(String msg) {
        System.out.print(msg);
        double value = sc.nextDouble();
        sc.nextLine();      // Consume newline
        return value;
    }

    public static String getString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
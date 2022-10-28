package com.itheima;

import java.util.*;
import java.util.regex.Pattern;

public class draft {
    public static void main(String[] args) {
        String pattern = "([0-9]+),([0-9]+)";
//        String pattern = "(^[0-9]*$),(^[0-9]*$)";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (Pattern.matches(pattern, str)) {
                System.out.println("correct input");
            } else if (Objects.equals(str, "exit")) {
                System.exit(0);
            } else {
                System.out.println("incorrect input");
            }
        }
    }
}

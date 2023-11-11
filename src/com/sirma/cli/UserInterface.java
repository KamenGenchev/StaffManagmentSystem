package com.sirma.cli;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public int start() {
        int input = getIntegerInput();

        if (input < 0 || input > 7 && input != 9) {
            System.out.println("Wrong input!");
        }

        return input;
    }


    public static double getDoubleInput() {
        System.out.print("?: ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return getIntegerInput();
        }
    }

    public static int getIntegerInput() {
        System.out.print("?: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return getIntegerInput();
        }
    }

    public static String getInput() {
        System.out.print("?: ");
        return scanner.nextLine();
    }


    public void displayCommands() {
        System.out.println("***Hello Manager! Manager do managing:***");
        System.out.println("""
                1. Add Employee\s
                2. Edit Employee\s
                3. List Employees\s
                4. Search Name\s
                5. Search ID\s
                6. Search Department\s
                7. Fire Employee\s
                9. Save & Exit
                """);
    }
}

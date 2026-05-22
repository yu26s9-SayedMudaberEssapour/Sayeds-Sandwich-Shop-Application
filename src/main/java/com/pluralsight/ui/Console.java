package com.pluralsight.ui;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for a double.
     * @param prompt to display the user
     * @return the double the user selected.
     */
    public static double promptForDouble(String prompt) {
        double result = 0;
        try{
            System.out.print(prompt);
            result =  scanner.nextDouble();
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Sorry Invalid input: ");
            e.getMessage();
        }

        return result;

    }

    public static float promptForFloat(String prompt) {

        float result = 0;
        try{
            System.out.print(prompt);
            result =  scanner.nextFloat();
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Sorry Invalid input: ");
            e.getMessage();
        }

        return result;

    }

    /**
     * Prompts the user for a string.
     * @param prompt to display the user
     * @return the string the user selected.
     */
    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Prompts the user for an integer.
     * @param prompt to display the user
     * @return the int the user selected.
     */
    public static int promptForInt(String prompt) {

        int result = 0;
        try{
            System.out.print(prompt);
            result =  scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Sorry Invalid Input! ");
        }

        return result;

    }

    /**
     * Prompts the user for a Yes or No which is returned as a boolean.
     * @param prompt to display the user
     * @return the boolean
     */
    public static boolean promptForYesNo(String prompt) {
        boolean result = false;
        try{
            System.out.print(prompt);
            String userInput = scanner.nextLine();
            result = userInput.equalsIgnoreCase("YES");
        }
        catch (Exception e){
            System.out.println("Sorry Invalid Input");
        }

        return result;
        //opportunity to enhance this with some error protection.
    }

    public static long promptForLong(String prompt){
        long userInput = 0;
        try{
            System.out.println(prompt);
            userInput = scanner.nextLong();
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Sorry Invalid Input");
        }

        return userInput;
    }}


package com.pluralsight.Screens;

import com.pluralsight.ingredients.PremiumTopping;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {

    ArrayList<Object> CurrentOrder = new ArrayList<>();



    public void StartOrder(){

        System.out.println("""
                Welcome to Sayed's Sandwich Shop!!
                1) New Order
                0) Exit the Application
                """);

        String input = "";
        while(!input.equals("0")){
            input = Console.promptForString("Please enter your response here: ");

            switch (input){
                case "1":
                    System.out.println("go to neworderscreen");
                    break;
                case "0":
                    return;
                default:
                    break;}
        }

    }


    public void orderScreen(){
        System.out.println("""
                OrderScreen!!
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Check Out
                5) Cancel Order
                """);

        String input = "";
        while(!input.equals("5")){
            input = Console.promptForString("Please enter your response here: ");

            switch (input){
                case "1":
                    System.out.println("Add Sandwich");
                    break;
                case "2":
                    System.out.println("Add Drink");
                    break;
                case "3":
                    System.out.println("Add Chips");
                    break;
                case "4":
                    System.out.println("CheckOut");
                    break;
                case "5":
                    System.out.println("""
                            Your Order Has been Canceled 😞
                            Returning back to Home Screen 🚶‍♂️
                            """);
                    return;
                default:
                    break;}
        }

    }


    //__________________Add Sandwich______________________________

    //3rd Screen here
    public void AddSandwich(){

        System.out.println("""
                Time to add your Sandwich 🥪
                
                Our Sizes:
                Small(4 inches)
                Medium(8 inches)
                Large(12 inches)
                
                Our Bread Types:
                1. White Bread
                2. Wheat Bread
                3. Rye Bread
                4. Wrap
                
                Our toppings:
                
                1.  (Meat)
                    Steam
                    Ham
                    Salami
                    Roast Beef
                    Chicken
                    TurkeyBacon
                
                2.  (Cheese)
                    American
                    Provolone
                    Cheddar
                    Swiss
                    Paneer
                
                3. (Souses)
                    Mayo
                    Mustard
                    Ketchup
                    ranch
                    ThousandIsland
                    Vinaigrette
                
                4. (Other Toppings)
                        Au jus
                        Salt
                        Pepper
                        Jalapeno
                        RedPepper
                        GreenPepper
                
                """);

        String breadInput = Console.promptForString("Please Select your Bread Type: ");
        int SizeOfSandwich = Console.promptForInt(("Please Enter your Sandwich Size in (inches)"));

        //for toppings create another method and call it
        boolean shouldToast = Console.promptForYesNo("Do you want your Sandwich Toasted? (yes/no)");
        //method for sauses
        //method for other toppings

    }

    /**
     * This method takes as many Souses as the user would like to add and returns
     * a list with those sauses listed. 
     * @return
     */
    public ArrayList<String> listOfSouses(){

        ArrayList<String> souseCondiment = new ArrayList<>();

        List<String> availableSouses = new ArrayList<>();
        availableSouses.add("Mayo");
        availableSouses.add("Mustard");
        availableSouses.add("Ketchup");
        availableSouses.add("Ranch");
        availableSouses.add("Thousand Island");
        availableSouses.add("Vinaigrette");


        System.out.println("""
                  (Souses)
                    Mayo
                    Mustard
                    Ketchup
                    Ranch
                    ThousandIsland
                    Vinaigrette
              
               """);

        String input = "";

        do {
            input = Console.promptForString("Type the name of the souse or type (Stop) ");
            String turningFirstLetterToUpper = input.substring(0,1).toUpperCase();
            String joinBack = turningFirstLetterToUpper + input.substring(1);

            if(availableSouses.contains(joinBack)){
                souseCondiment.add(joinBack);
            }
        }
        while (!input.equalsIgnoreCase("Stop"));


        return souseCondiment;

    }







}

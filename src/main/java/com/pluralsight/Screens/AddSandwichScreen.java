package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Sandwich;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;
import com.pluralsight.ingredients.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AddSandwichScreen <T>{

    //__________________Add Sandwich______________________________


    //3rd Screen here
    public static void AddSandwich() {

        //(1)first ask the customer for their bread type
        String breadInput = returnTypeOfBread();

        //(2)ask the customer for the size of the sandwich
        String SizeOfSandwich = sandwichSize();

        //(3)list of meat
        ArrayList<String> meat = typeOfMeat();

        //(4)list of Cheese
        ArrayList<String> cheese = typeOfCheese();

        //(5)regular toppings
        ArrayList<RegularToppings> regularTopping = regularToppings();

        //(6)list of souses
        ArrayList<Sauses> Sauses = listOfSouses();

        //(7)ask the user if they want sandwich toasted
        boolean shouldToast = shouldToast();


        //this is how the
        Sandwich sandwich = new Sandwich(SizeOfSandwich, breadInput, shouldToast, Sauses, meat, cheese, regularTopping);
        System.out.println("price of this sandwich is " + sandwich.getPrice());

        //should be able to add sandwich to the current order.



    }
    private static boolean shouldToast(){
        boolean result = false;
        int shouldToast = Console.promptForInt("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║              TOAST YOUR SANDWICH 🔥                  ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Make it warm, crispy, and extra delicious!
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                🔥 WOULD YOU LIKE YOUR SANDWICH TOASTED?
                                                                
                                                                   [1] Yes — Toast my sandwich 🔥
                                                                   [2] No  — Keep it fresh 🥗
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                👉 Enter your choice (1/2):
                """);

        switch (shouldToast){
            case 1:
                result = true;
                break;
            case 2:
                break;
            default:
                break;
        }
        return result;
    }

    public static String sandwichSize(){

        String result = "";
        int sizeOfSandwich = 0;
        do {
            sizeOfSandwich = Console.promptForInt(("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║               SELECT YOUR SIZE 📏                    ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Choose the perfect size for your sandwich!
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                📏 AVAILABLE SIZES
                                                                   [1] Small   - 4 Inches
                                                                   [2] Medium  - 8 Inches
                                                                   [3] Large   - 12 Inches
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                👉 Please enter the corresponding number for your sandwich size:
                """));


            switch (sizeOfSandwich){
                case 1:
                    result = "Small";
                    break;
                case 2:
                    result = "Medium";
                    break;
                case 3:
                    result = "Large";
                    break;
                default:
                    break;
            }
            if((sizeOfSandwich == 1) || (sizeOfSandwich == 2 )||(sizeOfSandwich == 3)){
                break;
            }
        }
        while((sizeOfSandwich != 1) || (sizeOfSandwich != 2) || sizeOfSandwich != 3);

        return result;
    }






















    public static String returnTypeOfBread(){

        int breadInput = Console.promptForInt("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                SELECT YOUR BREAD 🍞                  ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Freshly baked and ready for your sandwich!
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                🍞 BREAD OPTIONS
                                                                   [1] White Bread
                                                                   [2] Wheat Bread
                                                                   [3] Rye Bread
                                                                   [4] Wrap
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                👉 Enter your bread choice:
                """);
        String result = "";
        switch (breadInput){
            case 1:
                result = "White Bread";
                break;
            case 2:
                result = "Wheat Bread";
                break;
            case 3:
                result = "Rye Bread";
                break;
            case 4:
                result = "Wrap";
                break;
            default:
                break;
        }

        return result;
    }

    /**
     * This method takes as many Souses as the user would like to add and returns
     * a list with those souses listed.
     * @return
     */
    private static ArrayList<Sauses> listOfSouses() {

        ArrayList<Sauses> souseCondiment = new ArrayList<>();


        List<Sauses> availableSouses = new ArrayList<>(Arrays.asList(Sauses.values()));

        while (true) {
            int choice = Console.promptForInt(("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                     SAUCES 🥫                        ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                            
                                                                Add the perfect finishing touch to your sandwich!
                                                            
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                            
                                                                🥫 AVAILABLE SAUCES
                                                                   [1] Mayo
                                                                   [2] Mustard
                                                                   [3] Ketchup
                                                                   [4] Ranch
                                                                   [5] Thousand Island
                                                                   [6] Vinaigrette
                                                                   [0] Stop 
                                                            
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                            
                                                                👉 Select your sauces (you may choose multiple):
                    
                    """));

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    souseCondiment.add(availableSouses.getFirst());
                    break;
                case 2:
                    souseCondiment.add(availableSouses.get(1));
                    break;
                case 3:
                    souseCondiment.add(availableSouses.get(2));
                    break;
                case 4:
                    souseCondiment.add(availableSouses.get(3));
                    break;
                case 5:
                    souseCondiment.add(availableSouses.get(4));
                    break;
                case 6:
                    souseCondiment.add(availableSouses.get(5));
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid topping.");
                    break;
            }



        }
        return souseCondiment;



    }

    /**
     * @return a list of all the regular toppings that the customer has chosen
     */
    private static ArrayList<RegularToppings> regularToppings(){

        ArrayList<RegularToppings> additionalToppings = new ArrayList<>();

        //understand how this works
        List<RegularToppings> toppingInventory = new ArrayList<>(Arrays.asList(RegularToppings.values()));



        while(true){
            int choice = Console.promptForInt("""
                                                               ╔══════════════════════════════════════════════════════╗
                                                               ║              SELECT YOUR TOPPINGS 🥬                 ║
                                                               ╚══════════════════════════════════════════════════════╝
                                                            
                                                               Add fresh toppings to build your perfect sandwich!
                                                            
                                                               ════════════════════════════════════════════════════════
                                                            
                                                               🥬 AVAILABLE TOPPINGS
                                                                  [1] Lettuce
                                                                  [2] Pepper
                                                                  [3] Jalapeños
                                                                  [4] Onion
                                                                  [5] Tomatoes
                                                                  [6] Pickles
                                                                  [7] Guacamole
                                                                  [8] Mushrooms
                                                                  [0] Stop 
                                                            
                                                               ════════════════════════════════════════════════════════
                                                            
                                                               👉 Please enter your topping choices:
           """);

            if(choice == 0){
                break;
            }

            switch (choice) {
                case 1:
                    additionalToppings.add(toppingInventory.getFirst());
                    break;
                case 2:
                    additionalToppings.add(toppingInventory.get(1));
                    break;
                case 3:
                    additionalToppings.add(toppingInventory.get(2));
                    break;
                case 4:
                    additionalToppings.add(toppingInventory.get(3));
                    break;
                case 5:
                    additionalToppings.add(toppingInventory.get(4));
                    break;
                case 6:
                    additionalToppings.add(toppingInventory.get(5));
                    break;
                case 7:
                    additionalToppings.add(toppingInventory.get(6));
                    break;
                case 8:
                    additionalToppings.add(toppingInventory.get(7));
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid topping.");
                    break;
            }
        }


        return additionalToppings;

    }


    //give the ability to customers to select multiple meats
    //meat should be type meat
    private static ArrayList<String> typeOfMeat(){

        ArrayList<String> meatOnOrder = new ArrayList<>();


        System.out.println("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                 SELECT YOUR MEAT 🥩                  ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Choose your favorite meat for your sandwich!
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                🥩 AVAILABLE MEATS
                                                                   [1] Steak
                                                                   [2] Ham
                                                                   [3] Salami
                                                                   [4] Roast Beef
                                                                   [5] Chicken
                                                                   [6] Bacon
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                👉 Enter the meat you would like:
                """);

        int input = Console.promptForInt("""
                Please select your meat type:
                """);


        switch (input) {
            case 1:
                meatOnOrder.add("Steak");
                break;
            case 2:
                meatOnOrder.add("Ham");
                break;
            case 3:
                meatOnOrder.add("Salami");
                break;
            case 4:
                meatOnOrder.add("Roast Beef");
                break;
            case 5:
                meatOnOrder.add("Chicken");
                break;
            case 6:
                meatOnOrder.add("Bacon");
                break;
            default:
                break;

        }



        while (true){
            int inputExtra = Console.promptForInt("""
                                                            If you would like extra meat please select which one or type (0) to stop.
                                                            
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║              SELECT YOUR MEAT 🥩                     ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Pick one or more meats to build your perfect sandwich!
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                🥩 AVAILABLE MEATS
                                                                   [1] Steak
                                                                   [2] Ham
                                                                   [3] Salami
                                                                   [4] Roast Beef
                                                                   [5] Chicken
                                                                   [6] Bacon
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                   [0] 🛑 Stop Adding Meats
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                👉 Enter your choice:
                """);
            if(inputExtra == 0){
                break;
            }
            switch (inputExtra){
                case 1:
                    meatOnOrder.add("Steak");
                    break;
                case 2:
                    meatOnOrder.add("Ham");
                    break;
                case 3:
                    meatOnOrder.add("Salami");
                    break;
                case 4:
                    meatOnOrder.add("Roast Beef");
                    break;
                case 5:
                    meatOnOrder.add("Chicken");
                    break;
                case 6:
                    meatOnOrder.add("Bacon");
                    break;
                default:
                    break;

            }
        }
        return meatOnOrder;

        //        String[] typesOfMeat = Meat.getTypeOfMeat();
//        for(String m : typesOfMeat){
//            System.out.println(m.toString());
//        }


    }


    //give the ability to customers to select multiple Cheese
    //should be able to add many different types of cheese
    private static ArrayList<String> typeOfCheese(){
        ArrayList<String> cheeseOnOrder = new ArrayList<>();


        System.out.println("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                 SELECT YOUR CHEESE 🧀                ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Choose your favorite Cheese for your sandwich!
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                🧀 AVAILABLE Cheeses
                                                                   [1] American
                                                                   [2] Provolone
                                                                   [3] Cheddar
                                                                   [4] Swiss
                                                                   [5] Paneer
                                                                
                                                                ════════════════════════════════════════════════════════
                                                                
                                                                👉 Enter the meat you would like:
                                                                """);

        int input = Console.promptForInt("""
                Please select your Cheese type:
                """);


        switch (input) {
            case 1:
                cheeseOnOrder.add("American");
                break;
            case 2:
                cheeseOnOrder.add("Provolone");
                break;
            case 3:
                cheeseOnOrder.add("Cheddar");
                break;
            case 4:
                cheeseOnOrder.add("Swiss");
                break;
            case 5:
                cheeseOnOrder.add("Paneer");
                break;
            default:
                break;

        }



        while (true){
            int inputExtra = Console.promptForInt("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║              EXTRA CHEESE OPTIONS 🧀                 ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Add as much cheese as you like to perfect your sandwich!
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                🧀 AVAILABLE CHEESES
                                                                   [1] American
                                                                   [2] Provolone
                                                                   [3] Cheddar
                                                                   [4] Swiss
                                                                   [5] Paneer
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                   [0] 🛑 Stop Adding Cheese
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                            👉 If you would like extra cheese, please select an option:
                   
                """);
            if(inputExtra == 0){
                break;
            }
            switch (inputExtra) {
                case 1:
                    cheeseOnOrder.add("American");
                    break;
                case 2:
                    cheeseOnOrder.add("Provolone");
                    break;
                case 3:
                    cheeseOnOrder.add("Chedder");
                    break;
                case 4:
                    cheeseOnOrder.add("Swiss");
                    break;
                case 5:
                    cheeseOnOrder.add("Paneer");
                    break;
                default:
                    break;

            }
        }
        return cheeseOnOrder;
    }



}


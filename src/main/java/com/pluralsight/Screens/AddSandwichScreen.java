package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.OrderItems;
import com.pluralsight.ItemsInTheShop.Sandwich;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;
import com.pluralsight.ingredients.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddSandwichScreen extends OrderItems {

    //__________________Add Sandwich______________________________


    //3rd Screen here
    public static void AddSandwich() {

        //(1)ask the customer for the size of the sandwich
        String SizeOfSandwich = sandwichSize();
        //(2)first ask the customer for their bread type
        String breadInput = TypeOfBread();
        //(3)ask the user if they want sandwich toasted
        String shouldToast = shouldToast();
        //(4)list of meat
        ArrayList<ListOfMeats> meat = typeOfMeat();
        //(5)list of Cheese
        ArrayList<ListOfCheeses> cheese = typeOfCheese();
        //(6)regular toppings
        ArrayList<RegularToppings> regularTopping = regularToppings();
        //(7)list of souses
        ArrayList<Sauses> Sauces = listOfSouses();


        Sandwich sandwich = new Sandwich(SizeOfSandwich, breadInput, meat,  cheese, regularTopping,Sauces, shouldToast);

        //Should be able to add sandwich to the current order.
        StringBuilder sb = new StringBuilder();

        sb.append(sandwich.getSandwichSize());
        sb.append(sandwich.getTypeOfBread());
        sb.append( sandwich.isShouldToast());
        sb.append(sandwich.getSauses());
        sb.append(sandwich.getMeat());
        sb.append(sandwich.getCheese());
        sb.append(sandwich.getToppings());
        sb.append(sandwich.getWholeSandwichPrice());

        totalPrice += sandwich.getWholeSandwichPrice();
        currentOrder.put(sandwich, sb.toString());


    }

    //--------------------------Should Toast----------------------------------
    private static String shouldToast(){
        boolean result = false;

        System.out.println("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║              TOAST YOUR SANDWICH 🔥                  ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Make it warm, crispy, and extra delicious!
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                🔥 WOULD YOU LIKE YOUR SANDWICH TOASTED?
                                                                
                                                                   [1] Yes — Toast my sandwich 🔥
                                                                   [2] No  — Keep it fresh 🥗
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                
                """);
        int shouldToast = Console.promptForInt("👉 Enter your choice (1/2): " );

        switch (shouldToast){
            case 1:
                result = true;
                break;
            case 2:
                break;
            default:
                break;
        }
        return (!result) ? ("No") : ("Yes");
    }

    //--------------------------SandwichSize----------------------------------
    public static String sandwichSize(){

        String result = "";
        int sizeOfSandwich = 0;
        do {

            System.out.println("""
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
                                                                
                
                """);
            sizeOfSandwich = Console.promptForInt("👉 Please enter the corresponding number for your sandwich size:");


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
        while((sizeOfSandwich < 1) && (sizeOfSandwich > 3));

        return result;
    }



    //--------------------------returnTypeBread----------------------------------
    public static String TypeOfBread(){

        System.out.println("""
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
                                                                
                 
                """);
        int breadInput = Console.promptForInt("👉 Please enter the corresponding number for your response");
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


    //--------------------------listOfSauses----------------------------------
    /**
     * This method takes as many Souses as the user would like to add and returns
     * a list with those souses listed.
     * @return
     */
    private static ArrayList<Sauses> listOfSouses() {

        ArrayList<Sauses> sauceCondiment = new ArrayList<>();


        List<Sauses> availableSauce = new ArrayList<>(Arrays.asList(Sauses.values()));

        while (true) {
            System.out.println("""
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
                                                                   [7] No Sauce
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                   [0] 🛑 Stop Adding Sauce
                                                                
                                                               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                         
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                            
                                                                
                    
                    """);
            int choice = Console.promptForInt(("👉 Select your sauces (you may choose multiple): "));

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    sauceCondiment.add(availableSauce.getFirst());
                    break;
                case 2:
                    sauceCondiment.add(availableSauce.get(1));
                    break;
                case 3:
                    sauceCondiment.add(availableSauce.get(2));
                    break;
                case 4:
                    sauceCondiment.add(availableSauce.get(3));
                    break;
                case 5:
                    sauceCondiment.add(availableSauce.get(4));
                    break;
                case 6:
                    sauceCondiment.add(availableSauce.get(5));
                    break;
                case 7:
                    sauceCondiment.clear();
                default:
                    System.out.println("Invalid choice. Please select a valid topping.");
                    break;
            }



        }
        return sauceCondiment;



    }



    //--------------------------regularTopping----------------------------------
    /**
     * @return a list of all the regular toppings that the customer has chosen
     */
    private static ArrayList<RegularToppings> regularToppings(){

        ArrayList<RegularToppings> additionalToppings = new ArrayList<>();

        //understand how this works
        List<RegularToppings> toppingInventory = new ArrayList<>(Arrays.asList(RegularToppings.values()));



        while(true){
            System.out.println("""
                                                               ╔══════════════════════════════════════════════════════╗
                                                               ║              SELECT YOUR Veggie-Toppings 🥬          ║
                                                               ╚══════════════════════════════════════════════════════╝
                                                            
                                                               Add fresh toppings to build your perfect sandwich!
                                                            
                                                               ════════════════════════════════════════════════════════
                                                            
                                                               🥬 AVAILABLE Veggie-Toppings
                                                                  [1] Lettuce
                                                                  [2] Pepper
                                                                  [3] Jalapeños
                                                                  [4] Onion
                                                                  [5] Tomatoes
                                                                  [6] Pickles
                                                                  [7] Guacamole
                                                                  [8] Mushrooms
                                                                  [9] No Veggie-Topping
                                                                  
                                                               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                   [0] 🛑 Stop Adding Veggie-Toppings
                                                                
                                                               ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                            
                                                               ════════════════════════════════════════════════════════
                                                            
                                                               
           """);
            int choice = Console.promptForInt("👉 Please enter your topping choices:");

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
                case 9:
                    additionalToppings.clear();
                default:
                    System.out.println("Invalid choice. Please select a valid topping.");
                    break;
            }
        }


        return additionalToppings;

    }



    //--------------------------TypeOfMeat----------------------------------
    //give the ability to customers to select multiple meats
    //meat should be type meat
    private static ArrayList<ListOfMeats> typeOfMeat(){

        ArrayList<ListOfMeats> meatOnOrder = new ArrayList<>();


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
                                                                
                                                                
                """);

        int input = Console.promptForInt("""
                👉 Enter the meat you would like: 
                """);


        switch (input) {
            case 1:
                meatOnOrder.add(ListOfMeats.Steak);
                break;
            case 2:
                meatOnOrder.add(ListOfMeats.Ham);
                break;
            case 3:
                meatOnOrder.add(ListOfMeats.Salami);
                break;
            case 4:
                meatOnOrder.add(ListOfMeats.Roastbeef);
                break;
            case 5:
                meatOnOrder.add(ListOfMeats.Chicken);
                break;
            case 6:
                meatOnOrder.add(ListOfMeats.Bacon);
                break;
            default:
                break;

        }



        while (true){
            System.out.println("""
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
                                                                
                                                                
                """);
            int inputExtra = Console.promptForInt("👉 Enter your choice:");
            if(inputExtra == 0){
                break;
            }
            switch (inputExtra){
                case 1:
                    meatOnOrder.add(ListOfMeats.Steak);
                    break;
                case 2:
                    meatOnOrder.add(ListOfMeats.Ham);
                    break;
                case 3:
                    meatOnOrder.add(ListOfMeats.Salami);
                    break;
                case 4:
                    meatOnOrder.add(ListOfMeats.Roastbeef);
                    break;
                case 5:
                    meatOnOrder.add(ListOfMeats.Chicken);
                    break;
                case 6:
                    meatOnOrder.add(ListOfMeats.Bacon);
                    break;
                default:
                    break;

            }
        }
        return meatOnOrder;
    }


    //give the ability to customers to select multiple Cheese
    //should be able to add many different types of cheese
    private static ArrayList<ListOfCheeses> typeOfCheese(){
        ArrayList<ListOfCheeses> cheeseOnOrder = new ArrayList<>();


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
                                                                
                                                                
                                                                
                 """
        );

        int input = Console.promptForInt("""
                👉 Enter the meat you would like:
                """);


        switch (input) {
            case 1:
                cheeseOnOrder.add(ListOfCheeses.American);
                break;
            case 2:
                cheeseOnOrder.add(ListOfCheeses.Provolone);
                break;
            case 3:
                cheeseOnOrder.add(ListOfCheeses.Cheddar);
                break;
            case 4:
                cheeseOnOrder.add(ListOfCheeses.Swiss);
                break;
            case 5:
                cheeseOnOrder.add(ListOfCheeses.Paneer);
                break;
            default:
                break;

        }



        while (true){
            System.out.println("""
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
                                                                
                                                            
                   
                """);
            int inputExtra = Console.promptForInt("👉 If you would like extra cheese, please select an option: ");
            if(inputExtra == 0){
                break;
            }
            switch (inputExtra){

            case 1:
                cheeseOnOrder.add(ListOfCheeses.American);
                break;
            case 2:
                cheeseOnOrder.add(ListOfCheeses.Provolone);
                break;
            case 3:
                cheeseOnOrder.add(ListOfCheeses.Cheddar);
                break;
            case 4:
                cheeseOnOrder.add(ListOfCheeses.Swiss);
                break;
            case 5:
                cheeseOnOrder.add(ListOfCheeses.Paneer);
                break;
            default:
                break;

            }
        }
        return cheeseOnOrder;
    }



}
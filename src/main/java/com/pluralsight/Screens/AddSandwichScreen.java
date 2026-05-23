package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Sandwich;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;
import com.pluralsight.ingredients.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddSandwichScreen {

    //__________________Add Sandwich______________________________


    //3rd Screen here
    public static void AddSandwich() {

        System.out.println("""
                                                               ╔════════════════════════════════════════════════════════════════════════════════════════╗
                                                               ║                               BUILD YOUR SANDWICH 🥪                                  ║
                                                               ╚════════════════════════════════════════════════════════════════════════════════════════╝
                
                                                                                             Choose your perfect sandwich!
                
                                                               ══════════════════════════════════════════════════════════════════════════════════════════
                
                                                               📏 SIZES              🍞 BREAD TYPES         🥩 MEATS              🧀 CHEESE
                                                               ──────────────────    ───────────────────    ───────────────────    ───────────────────
                                                               [1] Small (4")        [1] White Bread        [1] Steak             [1] American
                                                               [2] Medium (8")       [2] Wheat Bread        [2] Ham               [2] Provolone
                                                               [3] Large (12")       [3] Rye Bread          [3] Salami            [3] Cheddar
                                                                                     [4] Wrap               [4] Roast Beef        [4] Swiss
                                                                                                            [5] Chicken           [5] Paneer
                                                                                                            [6] Turkey Bacon
                
                                                               ══════════════════════════════════════════════════════════════════════════════════════════
                
                                                               🥫 SAUCES             🥬 EXTRA TOPPINGS
                                                               ──────────────────    ───────────────────
                                                               [1] Mayo              [1] Pepper
                                                               [2] Mustard           [2] Onion
                                                               [3] Ketchup           [3] Pickles
                                                               [4] Ranch             [4] Jalapeño
                                                               [5] Thousand Island   [5] Guacamole
                                                               [6] Vinaigrette       [6] Tomatoes
                                                                                     [7] Mushrooms
                
                                                               ══════════════════════════════════════════════════════════════════════════════════════════
                
                                                               👉 Enter your selections below:
                                                                
                """);


        //ask the customer for the size of the sandwich
        int SizeOfSandwich = sandwichSize();
        //first ask the customer for their bread type
        String breadInput = returnBread();
        //ask the user if they want sandwich toasted
        boolean shouldToast = shouldToast();

        //fix the order

        //this is how the
        Sandwich sandwich = new Sandwich(SizeOfSandwich, breadInput, shouldToast, listOfSouses(), typeOfMeat(), typeOfCheese(), regularToppings());

        //should be able to add sandwich to the current order.

    }
    public static boolean shouldToast(){
        boolean shouldToast = Console.promptForYesNo("Do you want your Sandwich Toasted? (yes/no)");
        return shouldToast;
    }

    public static int sandwichSize(){

        int SizeOfSandwich = Console.promptForInt(("Please Enter your Sandwich Size"));
        int result = 0;

        if((SizeOfSandwich == 4) || (SizeOfSandwich == 8) || (SizeOfSandwich ==12)){
            result = SizeOfSandwich;

        }
        return result;
    }

    public static String returnBread(){

        String breadInput = Console.promptForString("Please Select your Bread Type: ");
        String result = "";
        if(breadInput.equalsIgnoreCase("White") ||
                (breadInput.equalsIgnoreCase("wheat") ||
                (breadInput.equalsIgnoreCase("rye") ||
                (breadInput.equalsIgnoreCase("wrap"))))){
            result = breadInput;

        }

        return result;
    }

    /**
     * This method takes as many Souses as the user would like to add and returns
     * a list with those souses listed.
     * @return
     */
    public static ArrayList<Sauses> listOfSouses(){

        ArrayList<Sauses> souseCondiment = new ArrayList<>();


        List<Sauses> availableSouses = new ArrayList<>(Arrays.asList(Sauses.values()));

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
                
                   ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                   👉 Select your sauces (you may choose multiple):
              
               """);

        String input = "";

        while (!input.equalsIgnoreCase("Stop")){


            input = Console.promptForString("Type the name of the souse or type <stop> to stop ");
            String turningFirstLetterToUpper = input.substring(0,1).toUpperCase();
            String joinBack = turningFirstLetterToUpper + input.substring(1);

            try{
                if(availableSouses.contains(Sauses.valueOf(joinBack))){
                    souseCondiment.add(Sauses.valueOf(joinBack));
                }


            }
            catch (Exception e){
                if(input.equalsIgnoreCase("stop")){
                    break;}
                System.out.println("Sorry your input is invalid try again");
            }
        }

        return souseCondiment;

    }

    /**
     * @return a list of all the regular toppings that the customer has chosen
     */
    public static ArrayList<RegularToppings> regularToppings(){

        ArrayList<RegularToppings> AdditionalToppings = new ArrayList<>();

        //understand how this works
        List<RegularToppings> ToppingInventory = new ArrayList<>(Arrays.asList(RegularToppings.values()));


        System.out.println("""
                  (Toppings)
                    lettuce
                    Pepper
                    jalapeños
                    onion
                    tomatoes
                    pickles
                    guacamole
                    mushrooms
               """);

        String input = "";

        do {
            input = Console.promptForString("Type the name of the topping or type (Stop) ");
            String turningFirstLetterToUpper = input.substring(0,1).toUpperCase();
            String joinBack = turningFirstLetterToUpper + input.substring(1);

            try{
                if(ToppingInventory.contains(RegularToppings.valueOf(joinBack))){
                    AdditionalToppings.add(RegularToppings.valueOf(joinBack));
                }
            }
            catch (Exception e){
                if(input.equalsIgnoreCase("stop")){
                    break;
                }
                System.out.println("Sorry wrong input try again with the listed inputs");
            }

        }
        while (!input.equalsIgnoreCase("Stop"));


        return AdditionalToppings;

    }


    /**
     * This method gets the size of the break and then returns the price of that size
     * not including anything else.
     * @param sizeBread the size that is provided by the user
     * @return the price of the size.
     */
    public double priceSandwichBasedOnSize(int sizeBread){
        double price = 0;
        switch (sizeBread){
            case 4:
                price = 5.50;
                break;
            case 8:
                price = 7.0;
                break;
            case 12:
                price = 12.0;
                break;
            default:
                break;
        }
        return price;
    }


    public ArrayList<String> sides(){
        //todo
        return null;
    }


    //give the ability to customers to select multiple meats
    //meat should be type meat
    public static String typeOfMeat(){
        System.out.println("Here is a list of our meat selections.");

        String[] typesOfMeat = Meat.getTypeOfMeat();
        for(String m : typesOfMeat){
            System.out.println(m.toString());
        }

        return Console.promptForString("What type of meat do you want? ");
    }



    //give the ability to customers to select multiple Cheese
    //should be able to add many different types of cheese
    public static String typeOfCheese(){
        System.out.println("Here is a list of our Cheese selections.");

        String[] typesOfCheese = Cheese.getTypeOfCheese();
        for(String m : typesOfCheese){
            System.out.println(m.toString());
        }

        return Console.promptForString("What type of Cheese do you want? ");
    }

}

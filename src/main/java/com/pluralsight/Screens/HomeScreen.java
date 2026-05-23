package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Sandwich;
import com.pluralsight.ingredients.Cheese;
import com.pluralsight.ingredients.Meat;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class HomeScreen <T>{

    ArrayList<T> CurrentOrder = new ArrayList<>();



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
                    orderScreen();
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
                    System.out.println("add sandwich");
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
    public void AddSandwich() {

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

        //first ask the customer for their bread type
        String breadInput = Console.promptForString("Please Select your Bread Type: ");


        //ask the customer for the size of the sandwich
        int SizeOfSandwich = Console.promptForInt(("Please Enter your Sandwich Size in (inches)"));

        //for toppings create another method and call it


        boolean shouldToast = Console.promptForYesNo("Do you want your Sandwich Toasted? (yes/no)");

        //here I am getting the type of meat



        //this is how the
        Sandwich sandwich = new Sandwich(SizeOfSandwich, breadInput, shouldToast, listOfSouses(), typeOfMeat(), typeOfCheese(), regularToppings());

        //while these are being added we sh

    }


    //give the ability to customers to select multiple meats
    public String typeOfMeat(){
        System.out.println("Here is a list of our meat selections.");

        List<String> typesOfMeat = Meat.getTypeOfMeat();
        for(String m : typesOfMeat){
            System.out.println(m.toString());
        }

         return Console.promptForString("What type of meat do you want? ");
    }



    //give the ability to customers to select multiple Cheese
    public String typeOfCheese(){
        System.out.println("Here is a list of our Cheese selections.");

        List<String> typesOfCheese = Cheese.getTypeOfCheese();
        for(String m : typesOfCheese){
            System.out.println(m.toString());
        }

        return Console.promptForString("What type of Cheese do you want? ");
    }









    /**
     * This method takes as many Souses as the user would like to add and returns
     * a list with those souses listed.
     * @return
     */
    public ArrayList<Sauses> listOfSouses(){

        ArrayList<Sauses> souseCondiment = new ArrayList<>();


        List<Sauses> availableSouses = new ArrayList<>(Arrays.asList(Sauses.values()));


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

            try{
                if(availableSouses.contains(Sauses.valueOf(joinBack))){
                    souseCondiment.add(Sauses.valueOf(joinBack));
                }
            }
            catch (Exception e){
                System.out.println("Sorry your input is invalid try again");
            }

        }
        while (!input.equalsIgnoreCase("Stop"));


        return souseCondiment;

    }


    /**
     * @return a list of all the regular toppings that the customer has chosen
     */
    public ArrayList<RegularToppings> regularToppings(){

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


    //__________________________________Drinks_______________________________________________














}

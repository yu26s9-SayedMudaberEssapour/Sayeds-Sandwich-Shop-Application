package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Drink;
import com.pluralsight.ItemsInTheShop.OrderItems;
import com.pluralsight.ui.Console;

public class AddDrink extends OrderItems {

    /**
     * This method will be in charge of adding the drink to the order of the customer.
     */
    public static void addDrink(){


        Drink drink = new Drink(drinkSize(), drinkFlavor(), customizeDrinkOption());

        StringBuilder sb = new StringBuilder();

        sb.append(drink.getSize());
        sb.append((drink.getFlavor()));
        sb.append(drink.getPrice());

        totalPrice += drink.getPrice();
        currentOrder.put(drink, sb.toString());

    }


    /**
     * This method will ask the user what size drink they want. It will return the size of the drink
     * in small, medium, large
     * @return the size of the drink
     */
    public static String drinkSize(){

        String result = "";
        int sizeOfDrink = 0;
        do {
            sizeOfDrink = Console.promptForInt(("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║               SELECT YOUR SIZE 📏                    ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Choose the perfect size for your Drink!
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                                                                📏 AVAILABLE SIZES
                                                                   [1] Small   - 16 oz
                                                                   [2] Medium  - 24 oz
                                                                   [3] Large   - 32 oz
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                👉 Please enter the corresponding number for your Drink size:
                """));


            switch (sizeOfDrink){
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
            if((sizeOfDrink == 1) || (sizeOfDrink == 2 )||(sizeOfDrink == 3)){
                break;
            }
        }
        while((sizeOfDrink != 1) || (sizeOfDrink != 2) || sizeOfDrink != 3);

        return result;
    }


    /**
     * This method will ask the user for what flavor of drink they want. It will return the flavor's name.
     * @return the name of the flavor of drink.
     */
    public static String drinkFlavor() {

        int flavor = Console.promptForInt("""
                                                                What flavor of drink do you want? 
                                                                 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                🥤 DRINK FLAVORS
                                                                   [1]  Coca-Cola
                                                                   [2]  Sprite
                                                                   [3]  Dr Pepper
                                                                   [4]  Fanta Orange
                                                                   [5]  Root Beer
                                                                   [6]  Lemonade
                                                                   [7]  Sweet Tea
                                                                   [8]  Unsweet Tea
                                                                   [9]  Mountain Dew
                                                                   [10] Pepsi
                                                                   [11] Cherry Coke
                                                                   [12] Fruit Punch
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                """);
        String result;

        switch (flavor) {
            case 1:
                result = "Coca-Cola";
                break;
            case 2:
                result = "Sprite";
                break;
            case 3:
                result = "Dr Pepper";
                break;
            case 4:
                result = "Fanta Orange";
                break;
            case 5:
                result = "Root Beer";
                break;
            case 6:
                result = "Lemonade";
                break;
            case 7:
                result = "Sweet Tea";
                break;
            case 8:
                result = "Unsweet Tea";
                break;
            case 9:
                result = "Mountain Dew";
                break;
            case 10:
                result = "Pepsi";
                break;
            case 11:
                result = "Cherry Coke";
                break;
            case 12:
                result = "Fruit Punch";
                break;
            default:
                result = "Invalid selection";
                break;
        }

        return result;
    }

    /**
     * This method will ask the user for the customization on their drink
     * @return No ice, Extra ice, or add lemon slice.
     */
    public static String customizeDrinkOption() {

        System.out.println("""
                                                        ╔══════════════════════════════════════════════════════╗
                                                        ║                  🥤 Customize DRINK OPTIONS          ║
                                                        ╚══════════════════════════════════════════════════════╝

                                                           Choose how you want your drink:

                                                              [1] ❄️  Extra Ice
                                                              [2] 🚫🧊 No Ice
                                                              [3] 🍋 Lemon Slice

                                                        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
        """);

        int extras = Console.promptForInt("Enter your response here: ");


        String customization = "";

        switch (extras) {
            case 1:
                customization = "❄️  Extra Ice";
                break;
            case 2:
                customization = "🚫🧊 No Ice";
                break;
            case 3:
                customization = "🍋 Lemon Slice";
                break;
            default:
                break;
        }


        return customization;


    }

}
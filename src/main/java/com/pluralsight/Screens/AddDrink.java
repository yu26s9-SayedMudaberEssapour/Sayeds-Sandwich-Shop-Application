package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Drink;
import com.pluralsight.ItemsInTheShop.OrderItems;
import com.pluralsight.ui.Console;

public class AddDrink extends OrderItems {

    public static void addDrink(){

        System.out.println("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                 CHOOSE YOUR DRINK 🥤                ║
                                                                ╚══════════════════════════════════════════════════════╝
                                                                
                                                                Cool, refreshing, and the perfect match for your meal!
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                📏 AVAILABLE SIZES
                                                                   [1] Small   - 16 oz
                                                                   [2] Medium  - 24 oz
                                                                   [3] Large   - 32 oz
                                                                
                                                               
                                                                
                                                                🧊 EXTRAS
                                                                   [1] Extra Ice
                                                                   [2] No Ice
                                                                   [3] Lemon Slice
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                👉 Please enter your choices below:
                """);

        //should get the size

        String size = drinkSize();

        String flavor = Console.promptForString("""
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

        String extras = Console.promptForString("""
                                                                   Choose one of the options for how you want your drink:
                                                                   [1] Extra Ice
                                                                   [2] No Ice
                                                                   [3] Lemon Slice
                """);

        Drink drink = new Drink(size, flavor, extras);

        System.out.println("The price of the drink is: " + drink.getPrice());;


        StringBuilder sb = new StringBuilder();

        sb.append(drink.getSize());
        sb.append((drink.getFlavor()));
        sb.append(drink.getPrice());

        totalPrice += drink.getPrice();
        currentOrder.put(drink, sb.toString());

    }



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
}
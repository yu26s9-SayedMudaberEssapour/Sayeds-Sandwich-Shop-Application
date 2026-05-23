package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Drink;
import com.pluralsight.ui.Console;

public class AddDrink {

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
                
                🧊 EXTRAS
                   [1] Extra Ice
                   [2] No Ice
                   [3] Lemon Slice
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                👉 Please enter your choices below:
                """);

        //should get the size

        String size = Console.promptForString("What size drink do you want enter the corresponding number: ");

        String flavor = Console.promptForString("What flavor of drink do you want? ");

        String extras = Console.promptForString("""
                   Choose one of the options for how you want your drink:
                   [1] Extra Ice
                   [2] No Ice
                   [3] Lemon Slice
                """);

        Drink drink = new Drink(size, flavor, extras);

    }
}

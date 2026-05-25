package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Chips;
import com.pluralsight.ui.Console;

public class AddChips {

    public static void addChips(){
        System.out.println("""
               
                ╔══════════════════════════════════════════════════════╗
                ║                     ADD CHIPS 🍟                    ║
                ╚══════════════════════════════════════════════════════╝
                
                Crunch time! Pick your favorite side.
                
                ════════════════════════════════════════════════════════
                
                🍟 AVAILABLE CHIPS
                   [1] Classic Lay’s (Original)
                   [2] BBQ Chips
                   [3] Sour Cream & Onion
                   [4] Salt & Vinegar
                   [5] Doritos Nacho Cheese
                   [6] Doritos Cool Ranch
                   [7] Cheetos Crunchy
                   [8] Ruffles Cheddar & Sour Cream
                
                ════════════════════════════════════════════════════════
                
                👉 Enter your choice:
                """);


        String input = Console.promptForString("Please enter the type of chips you want for your order: ");

        Chips chips = new Chips(input);
        System.out.println("The price of chips is: " + chips.getPrice());
    }

}

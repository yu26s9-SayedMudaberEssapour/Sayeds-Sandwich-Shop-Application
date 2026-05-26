package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.Chips;
import com.pluralsight.ItemsInTheShop.OrderItems;
import com.pluralsight.ui.Console;

public class AddChips extends OrderItems {

    public static void addChips(){
        System.out.println("""
               
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                     ADD CHIPS 🍟                     ║
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
                
                
                """);


        int input = Console.promptForInt("👉 Please enter the type of chips you want for your order: ");


        String result;

        switch (input) {
            case 1:
                result = "Classic Lay’s (Original)";
                break;
            case 2:
                result = "BBQ Chips";
                break;
            case 3:
                result = "Sour Cream & Onion";
                break;
            case 4:
                result = "Salt & Vinegar";
                break;
            case 5:
                result = "Doritos Nacho Cheese";
                break;
            case 6:
                result = "Doritos Cool Ranch";
                break;
            case 7:
                result = "Cheetos Crunchy";
                break;
            case 8:
                result = "Ruffles Cheddar & Sour Cream";
                break;
            default:
                result = "Invalid selection";
                break;
        }

        Chips chips = new Chips(result);

        System.out.println(chips.getPrice());




        StringBuilder sb = new StringBuilder();
        sb.append(chips.getTypeOfChips());
        sb.append(chips.getPrice());

        totalPrice += chips.getPrice();
        currentOrder.put(chips, sb.toString());
    }

}
package com.pluralsight.Screens;

import com.pluralsight.ui.Console;

import static com.pluralsight.Screens.AddChips.addChips;
import static com.pluralsight.Screens.AddDrink.addDrink;
import static com.pluralsight.Screens.AddSandwichScreen.AddSandwich;

public class OrderScreen {

    public static void orderScreen(){


        while(true){

            System.out.println("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                    ORDER SCREEN 🛒                  ║
                                                                ╚══════════════════════════════════════════════════════╝
                
                                                                Welcome! What would you like to do?
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                   [1] 🥪 Add Sandwich
                                                                   [2] 🥤 Add Drink
                                                                   [3] 🍟 Add Chips
                                                                   [4] 💳 Check Out
                                                                   [5] ❌ Cancel Order
                                                                
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                
                                                                👉 Enter your choice:
                """);

            String input = Console.promptForString("Please enter your response here: ");

            switch (input){

                case "1":
                    AddSandwich();
                    break;

                case "2":
                    addDrink();
                    break;

                case "3":
                    addChips();
                    break;

                case "4":
                    System.out.println("CheckOut");
                    break;

                case "5":
                    //here I should delete everything.
                    System.out.println("""
                            Your Order Has been Canceled 😞
                            Returning back to Home Screen 🚶‍♂️
                            """);
                    return; //this should return me to home page

                default:
                    System.out.println("Invalid option.");
                    break;}
        }

    }
}

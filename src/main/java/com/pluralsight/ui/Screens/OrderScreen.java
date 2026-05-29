package com.pluralsight.ui.Screens;

import com.pluralsight.model.order.Order;
import com.pluralsight.ui.Console;

import static com.pluralsight.ui.Screens.ChipScreens.addChips;
import static com.pluralsight.ui.Screens.DrinkScreens.addDrink;
import static com.pluralsight.ui.Screens.SandwichScreens.AddSandwich;
import static com.pluralsight.ui.Screens.CheckOutScreens.checkOut;
import static com.pluralsight.ui.Screens.SpecialSandwichScreens.addSpecialSandwich;

public class OrderScreen extends Order {

    public static void orderScreen() {

        while (true) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                   ORDER SCREEN 🛒                    ║
                ╚══════════════════════════════════════════════════════╝
                
                Build your perfect meal! What would you like to add?
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                   [1] 🥪 Add Sandwich
                   [2] 🥤 Add Drink
                   [3] 🍟 Add Chips
                   [4] 💳 Check Out
                   [5] ❌ Cancel Order
                   [6] special sandwich
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

            String input = Console.promptForString("👉 Please enter your response here: ");
            Order order = new Order();
            switch (input) {
                case "1" -> order.addItem(AddSandwich());
                case "2" -> order.addItem(addDrink());
                case "3" -> order.addItem(addChips());
                case "4" -> {
                    checkOut();
                    return;
                }
                case "5" -> {
                    // here I should delete everything.
                    System.out.println("""
                        Your Order Has been Canceled 😞
                        Returning back to Home Screen 🚶‍♂️
                        """);
                    return; // this should return me to home page
                }
                case "6" -> order.addItem(addSpecialSandwich());
                default -> System.out.println("⚠️ Invalid option. Please select a number from 1 to 5.\n");
            }
        }
    }
}
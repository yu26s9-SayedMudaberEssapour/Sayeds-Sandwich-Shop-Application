package com.pluralsight.ui.Screens;

import com.pluralsight.ui.Console;
import static com.pluralsight.ui.Screens.OrderScreen.orderScreen;

/**
 * Handles the main entry point screen for the application's user interface.
 */
public class HomeScreen {

    /**
     * Launches the home menu loop, welcoming users and directing them to start an order or exit.
     */
    public static void StartOrder() {

        while (true) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║          WELCOME TO SAYED'S SANDWICH SHOP 🥪         ║
                ╚══════════════════════════════════════════════════════╝
                
                Fresh ingredients. Perfect sandwiches. Made your way.
                
                We're happy to serve you today!
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                   [1] 🛒 Start New Order
                   [0] 🚪 Exit Application
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

            int input = Console.promptForInt("👉 Please enter your response here: ");

            switch (input) {
                case 1 -> orderScreen();
                case 0 -> {
                    System.out.println("You have exited the application 😞. Come back soon!");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice. Please choose [1] or [0].\n");
            }
        }
    }
}
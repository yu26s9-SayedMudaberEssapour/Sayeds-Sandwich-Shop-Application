package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.OrderItems;
import com.pluralsight.ui.Console;
import com.pluralsight.Screens.HomeScreen;

public class CheckOut extends OrderItems {

    //figure out how to implement this class.

    public static void checkOut(){

        //here I should display order details and price
        //for me to do this I should figure out how to store the order details and calculate the price first

        currentOrder.forEach((key, value) -> {
            System.out.println(key);
        });

        System.out.println("Total Price is: " + totalPrice);


        System.out.println("""
                                        ╔══════════════════════════════════════════════════════╗
                                        ║                    CHECKOUT 💳                      ║
                                        ╚══════════════════════════════════════════════════════╝

                                        Please review your order before continuing.

                                        ════════════════════════════════════════════════════════

                                           [1] ✅ Confirm Order
                                           [2] ❌ Cancel Order

                                        ════════════════════════════════════════════════════════

                                        Enter your choice 👇.
                """);

        int input  = Console.promptForInt("Please enter your response: ");

        switch (input){
            case 1:
                System.out.println("you have checked out");
                break;
            case 2:
                System.out.println("you have deleted order and returned back home");
                //currentOrder.clear();
                break;
            default:
                break;
        }

    }

}

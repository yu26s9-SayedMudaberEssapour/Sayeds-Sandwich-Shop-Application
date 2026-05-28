package com.pluralsight.ui.Screens;

import com.pluralsight.model.order.Order;
import com.pluralsight.model.order.OrderItem;
import com.pluralsight.ui.Console;

public class CheckOutScreens extends Order {

    //figure out how to implement this class.

    public static void checkOut(){

        double total = 0;
        for(OrderItem o : getItems()){
            System.out.println(o.getDescription());
            total += o.getPrice();

        }
        System.out.println("""
                Total price is: -%d
                """ + total);


        System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                    CHECKOUT 💳                       ║
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
            case 1 -> System.out.println("hi");
            case 2 -> System.out.println("you have deleted order, returning to Home Screen");

        }

    }



}

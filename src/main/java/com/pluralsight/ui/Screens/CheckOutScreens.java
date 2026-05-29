package com.pluralsight.ui.Screens;

import com.pluralsight.model.order.Order;
import com.pluralsight.model.order.OrderItem;
import com.pluralsight.ui.Console;
import com.pluralsight.services.ReceiptBuilder;

import java.util.ArrayList;
import java.util.List;

public class CheckOutScreens extends Order {

    //figure out how to implement this class.

    public static void checkOut(){

        List<OrderItem> items = getItems();
        double total = 0;
        for(OrderItem o : items){
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
            case 1 :
                ReceiptBuilder.saveReceiptString();
                System.out.println("Thanks for shopping with us. ");
            case 2 :
                items.clear();
                System.out.println("returning back to home screen.");



        }

    }



}

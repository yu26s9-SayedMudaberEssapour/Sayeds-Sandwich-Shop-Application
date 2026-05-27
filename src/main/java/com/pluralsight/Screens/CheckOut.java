package com.pluralsight.Screens;

import com.pluralsight.ItemsInTheShop.OrderItem;
import com.pluralsight.ui.Console;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut extends OrderItem {

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
            case 1:
                checkOutReceipt();
                break;
            case 2:
                System.out.println("you have deleted order, returning to Home Screen");
                currentOrder.clear();
                break;
            default:
                break;
        }

    }

    public static void checkOutReceipt(){
        //yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)
        try{
            LocalDateTime date = LocalDateTime.now();

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

            String formattedDate = date.format(myFormatObj);


            FileWriter fr = new FileWriter("src/main/java/com/pluralsight/Receipt/" + formattedDate + ".txt");

            fr.write("""
                                    ╔══════════════════════════════════════════════════════╗
                                    ║                 Sayed's Sandwich Shop                ║
                                    ║                 2245 8th st Washington DC            ║
                                    ║                 555-989-4532                         ║
                                    ╚══════════════════════════════════════════════════════╝
                    
                    """

            );

            fr.write(currentOrder.keySet().toString() + "\n");
            fr.write("Total:  " + String.valueOf(totalPrice));


            fr.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }

}

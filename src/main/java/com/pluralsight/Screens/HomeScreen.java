package com.pluralsight.Screens;

import com.pluralsight.ui.Console;
import java.util.ArrayList;

import static com.pluralsight.Screens.OrderScreen.orderScreen;


public class HomeScreen <T>{

    public ArrayList<T> CurrentOrder = new ArrayList<>();



    public void StartOrder(){

        while(true){
            System.out.println("""
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║          WELCOME TO SAYED'S SANDWICH SHOP 🥪         ║
                                                                ╚══════════════════════════════════════════════════════╝
                        
                                                                Fresh ingredients. Perfect sandwiches. Made your way.
                    
                                                                We’re happy to serve you today!
                    
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                    
                                                                   [1] 🛒 Start New Order
                                                                   [0] 🚪 Exit Application
                    
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                    
                                                                👉 Please select an option:
                """);

            int input = Console.promptForInt("Please enter your response here: ");

            switch (input){
                case 1:
                    orderScreen();
                    break;
                case 0:
                    System.out.println("You have exited the application 😞");
                    return;
                default:
                    break;}
        }

    }

}

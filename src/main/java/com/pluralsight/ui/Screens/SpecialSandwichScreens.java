package com.pluralsight.ui.Screens;

import com.pluralsight.enums.CheeseTypes;
import com.pluralsight.enums.MeatTypes;
import com.pluralsight.enums.RegularToppingsType;
import com.pluralsight.enums.SauceTypes;
import com.pluralsight.model.sandwich.*;
import com.pluralsight.ui.Console;

import java.util.ArrayList;

public class SpecialSandwichScreens {

    public static SayedSignitureSandwich addSpecialSandwich() {
        SayedSignitureSandwich sandwich = null;

        System.out.println("""
            ╔══════════════════════════════════════════════════════╗
            ║              SIGNATURE SANDWICHES 👑                 ║
            ╚══════════════════════════════════════════════════════╝
            
            Pick from our premium, chef-designed recipes:
            
               [1] Sayed's Special Sandwich 👑
               [2] Monster Sandwich         👹
            
            ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
            """);

        int input = Console.promptForInt("👉 Please enter your response: ");

        switch (input) {
            case 1 -> {
                System.out.println("""
                    ❓ Would you like to customize your sandwich's toppings? 
                    
                       [1] Yes - Customize it 🥬
                       [2] No  - Give it to me as it is ⭐
                    
                    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                    """);
                int input2 = Console.promptForInt("👉 Your Response: ");

                switch (input2) {
                    case 1 -> {
                        System.out.println("🔧 Customizing the sandwich...");
                        sandwich = customize();
                    }
                    case 2 -> {
                        System.out.println("✅ The standard Sayed Special has been created!");
                        sandwich = SayedSpecialSandwich();
                    }
                    default -> System.out.println("⚠️ Sorry, you picked an invalid option.");
                }
            }
            case 2 -> {
                System.out.println("👹 Monster sandwich selected!");
                // assumed method call for Monster Sandwich down the line:
                // sandwich = MonsterSandwich();
            }
            default -> System.out.println("⚠️ Invalid signature sandwich choice.");
        }

        // Print description only if a sandwich was successfully built
        if (sandwich != null) {
            System.out.println(sandwich.getDescription());
        }

        return sandwich;
    }

    private static SayedSignitureSandwich customize(){
        SayedSignitureSandwich sayedSandwich = new SayedSignitureSandwich();


        // (4) list of meat
        ArrayList<MeatTypes> listOfMeats = selectMeat("Large");

        for (int i = 0; i < listOfMeats.size(); i++) {
            if (i == 0) {
                sayedSandwich.addTopping(new Meat(listOfMeats.get(i), "Large", false));
            } else {
                sayedSandwich.addTopping(new Meat(listOfMeats.get(i), "Large", true));
            }
        }

        // (5) list of Cheese
        ArrayList<CheeseTypes> listOfCheese = selectCheese("Large");

        for (int i = 0; i < listOfCheese.size(); i++) {
            if (i == 0) {
                sayedSandwich.addTopping(new Cheese(listOfCheese.get(i), "Large", false));
            } else {
                sayedSandwich.addTopping(new Cheese(listOfCheese.get(i), "Large", true));
            }
        }

        // (6) regular toppings
        selectRegularTopping().forEach(topping -> sayedSandwich.addTopping(new RegularTopping(topping)));

        // (7) list of sauces
        selectSauce().forEach(sauce -> sayedSandwich.addTopping(new Sauces(sauce)));

        System.out.println(sayedSandwich.getDescription());

        return sayedSandwich;

    }



    /**
     *
     * @return a custom-made Sayed's Sandwich
     */
    private static SayedSignitureSandwich SayedSpecialSandwich(){

        SayedSignitureSandwich sayedSandwich = new SayedSignitureSandwich();

        sayedSandwich.addTopping(new Meat(MeatTypes.Steak, "Large", false) );
        sayedSandwich.addTopping(new Meat(MeatTypes.Chicken, "Large", true));

        sayedSandwich.addTopping(new Cheese(CheeseTypes.Cheddar, "Large", false));

        sayedSandwich.addTopping(new RegularTopping(RegularToppingsType.Lettuce));
        sayedSandwich.addTopping(new RegularTopping(RegularToppingsType.Onion));
        sayedSandwich.addTopping(new RegularTopping(RegularToppingsType.Pepper));

        sayedSandwich.addTopping(new Sauces(SauceTypes.Mayo));




        return sayedSandwich;
    }


    // --- Select Sauce ---
    private static ArrayList<SauceTypes> selectSauce() {
        ArrayList<SauceTypes> sauceList = new ArrayList<>();

        while (true) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                  SELECT YOUR SAUCE 🥫                ║
                ╚══════════════════════════════════════════════════════╝
                
                🥫 AVAILABLE SAUCES
                   [1] Mayo             🥛
                   [2] Mustard          💛
                   [3] Ketchup          🍅
                   [4] Ranch            🌿
                   [5] Thousand Island  🟠
                   [6] Vinaigrette      🏺
                   [7] Clear All Sauces ❌
          
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                   
                   [0] 🛑 Stop Adding Sauce
                   
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

            int input = Console.promptForInt("👉 Enter your sauce choice: ");

            if (input == 0) {
                break;
            }

            switch (input) {
                case 1 -> sauceList.add(SauceTypes.Mayo);
                case 2 -> sauceList.add(SauceTypes.Mustard);
                case 3 -> sauceList.add(SauceTypes.Ketchup);
                case 4 -> sauceList.add(SauceTypes.Ranch);
                case 5 -> sauceList.add(SauceTypes.Thousandisland);
                case 6 -> sauceList.add(SauceTypes.Vinaigrette);
                case 7 -> sauceList.clear();
            }
        }

        return sauceList;
    }

    // --- Select Regular Topping ---
    private static ArrayList<RegularToppingsType> selectRegularTopping() {
        ArrayList<RegularToppingsType> regularTopping = new ArrayList<>();

        while (true) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║            SELECT YOUR VEGGIE TOPPING 🥬             ║
                ╚══════════════════════════════════════════════════════╝
                
                🥬 AVAILABLE TOPPINGS
                   [1] Lettuce    🥬
                   [2] Pepper     🫑
                   [3] Jalapeños  🌶️
                   [4] Onion      🧅
                   [5] Tomatoes   🍅
                   [6] Pickles    🥒
                   [7] Guacamole  🥑
                   [8] Mushrooms  🍄
                   
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                   
                   [0] 🛑 Stop Adding Toppings
                   
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

            int input = Console.promptForInt("👉 Enter your topping choice: ");

            if (input == 0) {
                break;
            }

            switch (input) {
                case 1 -> regularTopping.add(RegularToppingsType.Lettuce);
                case 2 -> regularTopping.add(RegularToppingsType.Pepper);
                case 3 -> regularTopping.add(RegularToppingsType.Jalapeños);
                case 4 -> regularTopping.add(RegularToppingsType.Onion);
                case 5 -> regularTopping.add(RegularToppingsType.Tomatoes);
                case 6 -> regularTopping.add(RegularToppingsType.Pickles);
                case 7 -> regularTopping.add(RegularToppingsType.Guacamole);
                case 8 -> regularTopping.add(RegularToppingsType.Mushrooms);
            }
        }

        return regularTopping;
    }

    // --- Select Meat ---
    private static ArrayList<MeatTypes> selectMeat(String sizeOfSandwich) {
        ArrayList<MeatTypes> meatList = new ArrayList<>();

        while (true) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                 SELECT YOUR MEAT 🥩                  ║
                ╚══════════════════════════════════════════════════════╝
                
                Choose your favorite meat for your sandwich!
                
                ════════════════════════════════════════════════════════
                
                🥩 AVAILABLE MEATS
                   [1] Steak      🥩
                   [2] Ham        🍖
                   [3] Salami     🥓
                   [4] Roast Beef 🐂
                   [5] Chicken    🍗
                   [6] Bacon      🥓
                
                ════════════════════════════════════════════════════════
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                  
                   [0] 🛑 Stop Adding Meats
                  
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

            int input = Console.promptForInt("👉 Enter the meat you would like: \n");

            if (input == 0) {
                break;
            }

            switch (input) {
                case 1:
                    meatList.add(MeatTypes.Steak);
                    break;
                case 2:
                    meatList.add(MeatTypes.Ham);
                    break;
                case 3:
                    meatList.add(MeatTypes.Salami);
                    break;
                case 4:
                    meatList.add(MeatTypes.Roastbeef);
                    break;
                case 5:
                    meatList.add(MeatTypes.Chicken);
                    break;
                case 6:
                    meatList.add(MeatTypes.Bacon);
                    break;
                default:
                    break;
            }
        }

        return meatList;
    }

    // --- Select Cheese ---
    private static ArrayList<CheeseTypes> selectCheese(String sizeOfSandwich) {
        ArrayList<CheeseTypes> cheeseList = new ArrayList<>();
        double extraCounter = 0;

        while (true) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                 SELECT YOUR CHEESE 🧀                ║
                ╚══════════════════════════════════════════════════════╝
                
                Choose your favorite Cheese for your sandwich!
                
                ════════════════════════════════════════════════════════
                
                🧀 AVAILABLE CHEESES
                   [1] American  🇺🇸
                   [2] Provolone 🧀
                   [3] Cheddar   🟡
                   [4] Swiss     🕳️
                   [5] Paneer    🧊
                
                ════════════════════════════════════════════════════════
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                 
                   [0] 🛑 Stop Adding Cheese
                 
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

            int input = Console.promptForInt("👉 Enter the cheese you would like:\n");
            extraCounter++;

            if (input == 0) {
                break;
            }
            switch (input) {
                case 1:
                    cheeseList.add(CheeseTypes.American);
                    break;
                case 2:
                    cheeseList.add(CheeseTypes.Provolone);
                    break;
                case 3:
                    cheeseList.add(CheeseTypes.Cheddar);
                    break;
                case 4:
                    cheeseList.add(CheeseTypes.Swiss);
                    break;
                case 5:
                    cheeseList.add(CheeseTypes.Paneer);
                    break;
                default:
                    break;
            }
        }
        return cheeseList;
    }
}

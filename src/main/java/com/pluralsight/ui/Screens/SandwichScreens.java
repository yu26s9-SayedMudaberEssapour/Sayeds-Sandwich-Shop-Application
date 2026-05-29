package com.pluralsight.ui.Screens;

import com.pluralsight.model.sandwich.*;
import com.pluralsight.enums.RegularToppingsType;
import com.pluralsight.enums.SauceTypes;
import com.pluralsight.ui.Console;
import com.pluralsight.enums.*;

import com.pluralsight.model.order.OrderItem;

import java.util.ArrayList;

/**
 * Handles the step-by-step user interface menus for configuring and assembling a custom sandwich.
 */
public class SandwichScreens {

    /**
     * Orchestrates the full creation sequence of a custom sandwich item from size choice to sauces.
     * @return a fully configured custom Sandwich object populated with user selections
     */
    public static Sandwich AddSandwich() {
        String SizeOfSandwich = sandwichSize();
        String sizeofSandwich = SizeOfSandwich;

        Bread breadInput = SelectBread();

        String shouldToast = shouldToast();

        Sandwich sandwich = new Sandwich(SizeOfSandwich, breadInput, shouldToast);

        ArrayList<MeatTypes> listOfMeats = selectMeat(sizeofSandwich);

        for (int i = 0; i < listOfMeats.size(); i++) {
            if (i == 0) {
                sandwich.addTopping(new Meat(listOfMeats.get(i), sizeofSandwich, false));
            } else {
                sandwich.addTopping(new Meat(listOfMeats.get(i), sizeofSandwich, true));
            }
        }

        ArrayList<CheeseTypes> listOfCheese = selectCheese(sizeofSandwich);

        for (int i = 0; i < listOfCheese.size(); i++) {
            if (i == 0) {
                sandwich.addTopping(new Cheese(listOfCheese.get(i), sizeofSandwich, false));
            } else {
                sandwich.addTopping(new Cheese(listOfCheese.get(i), sizeofSandwich, true));
            }
        }

        selectRegularTopping().forEach(topping -> sandwich.addTopping(new RegularTopping(topping)));

        selectSauce().forEach(sauce -> sandwich.addTopping(new Sauces(sauce)));

        System.out.println(sandwich.getDescription());

        return sandwich;
    }

    /**
     * Displays options and tracks user input for whether the sandwich should be toasted.
     * @return a "Yes" or "No" preference string
     */
    private static String shouldToast() {
        boolean result = false;
        boolean choiceMade = false;

        while (!choiceMade) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║               TOAST YOUR SANDWICH 🔥                 ║
                ╚══════════════════════════════════════════════════════╝
                
                Make it warm, crispy, and extra delicious!
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                
                🔥 WOULD YOU LIKE YOUR SANDWICH TOASTED?
                
                   [1] Yes — Toast my sandwich 🔥
                   [2] No  — Keep it fresh 🥗
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);
            int shouldToast = Console.promptForInt("👉 Enter your choice (1/2): ");

            switch (shouldToast) {
                case 1:
                    result = true;
                    choiceMade = true;
                    break;
                case 2:
                    choiceMade = true;
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Please pick [1] or [2].\n");
                    break;
            }
        }
        return (!result) ? ("No") : ("Yes");
    }

    /**
     * Displays size configurations and loops until a valid menu option is resolved.
     * @return a size string designation ("Small", "Medium", "Large")
     */
    public static String sandwichSize() {
        String result = "";
        int sizeOfSandwich = 0;
        do {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                SELECT YOUR SIZE 📏                   ║
                ╚══════════════════════════════════════════════════════╝
                
                Choose the perfect size for your sandwich!
                
                ════════════════════════════════════════════════════════
                
                📏 AVAILABLE SIZES
                   [1] Small   - 4 Inches  🥪
                   [2] Medium  - 8 Inches  🥖
                   [3] Large   - 12 Inches 👑
                
                ════════════════════════════════════════════════════════
                """);
            sizeOfSandwich = Console.promptForInt("👉 Please enter the corresponding number for your sandwich size: ");

            switch (sizeOfSandwich) {
                case 1:
                    result = "Small";
                    break;
                case 2:
                    result = "Medium";
                    break;
                case 3:
                    result = "Large";
                    break;
                default:
                    System.out.println("⚠️ Invalid selection. Please choose [1], [2], or [3].\n");
                    break;
            }
            if ((sizeOfSandwich == 1) || (sizeOfSandwich == 2) || (sizeOfSandwich == 3)) {
                break;
            }
        } while (true);

        return result;
    }

    /**
     * Displays structural base choices and loops until a valid bread selection is finalized.
     * @return a constructed Bread object matching structural selections
     */
    public static Bread SelectBread() {
        BreadType breadType = null;

        while (breadType == null) {
            System.out.println("""
                    ╔══════════════════════════════════════════════════════╗
                    ║                 SELECT YOUR BREAD 🍞                 ║
                    ╚══════════════════════════════════════════════════════╝
                    
                    Freshly baked and ready for your sandwich!
                    
                    ════════════════════════════════════════════════════════
                    
                    🍞 BREAD OPTIONS
                       [1] White Bread 🤍
                       [2] Wheat Bread 🤎
                       [3] Rye Bread   🌾
                       [4] Wrap        🌯
                    
                    ════════════════════════════════════════════════════════
                    """);
            int input = Console.promptForInt("👉 Enter your Bread choice: ");

            switch (input) {
                case 1 -> breadType = BreadType.WhiteBread;
                case 2 -> breadType = BreadType.WheatBread;
                case 3 -> breadType = BreadType.RyeBread;
                case 4 -> breadType = BreadType.Wrap;
                default -> System.out.println("⚠️ Invalid selection. Please pick a number from 1 to 4.\n");
            }
        }

        return new Bread(breadType);
    }

    /**
     * Accumulates selected sauce options until explicit termination via menu commands.
     * @return a tracking list containing designated sauce variations
     */
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
                default -> System.out.println("⚠️ Invalid option. Please select from 0 to 7.\n");
            }
        }

        return sauceList;
    }

    /**
     * Accumulates specified fresh vegetable toppings until explicit termination via menu commands.
     * @return a tracking list containing chosen vegetable variations
     */
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
                default -> System.out.println("⚠️ Invalid option. Please select from 0 to 8.\n");
            }
        }

        return regularTopping;
    }

    /**
     * Accumulates chosen premium meat selections until explicit termination via menu commands.
     * @param sizeOfSandwich the designated scale modifier matching base metrics
     * @return a tracking list containing premium meat variants
     */
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
                    System.out.println("⚠️ Invalid option. Please select from 0 to 6.\n");
                    break;
            }
        }

        return meatList;
    }

    /**
     * Accumulates premium cheese variants until explicit termination via menu commands.
     * @param sizeOfSandwich the structural size context used for billing metrics
     * @return a tracking list containing premium cheese selections
     */
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
                    System.out.println("⚠️ Invalid option. Please select from 0 to 5.\n");
                    break;
            }
        }
        return cheeseList;
    }
}
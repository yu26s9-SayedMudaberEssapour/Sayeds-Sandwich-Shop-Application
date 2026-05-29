package com.pluralsight.ui.Screens;

import com.pluralsight.enums.CheeseTypes;
import com.pluralsight.enums.MeatTypes;
import com.pluralsight.enums.RegularToppingsType;
import com.pluralsight.enums.SauceTypes;
import com.pluralsight.model.sandwich.*;
import com.pluralsight.ui.Console;

import java.util.ArrayList;

/**
 * Handles the configuration and deployment screens for chef-designed signature sandwiches.
 */
public class SpecialSandwichScreens {

    /**
     * Guides the user through choosing a premium chef recipe and selecting custom or default builds.
     * Continues looping until a valid sandwich creation route is successfully resolved.
     * * @return a completed Sandwich object matching signature specifications
     */
    public static Sandwich addSpecialSandwich() {
        Sandwich sandwich = null;

        while (sandwich == null) {
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
                    boolean validSubChoice = false;
                    while (!validSubChoice) {
                        System.out.println("""
                            Corporate / Signature Customization 👑
                            ❓ Would you like to customize your sandwich's toppings? 
                            
                               [1] Yes - Customize it 🥬
                               [2] No  - Give it to me as it is ⭐
                            
                            ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                            """);
                        int input2 = Console.promptForInt("👉 Your Response: ");

                        switch (input2) {
                            case 1 -> {
                                System.out.println("🔧 Customizing the sandwich...");
                                sandwich = customizeSig();
                                validSubChoice = true;
                            }
                            case 2 -> {
                                System.out.println("✅ The standard Sayed Special has been created!");
                                sandwich = SayedSpecialSandwich();
                                validSubChoice = true;
                            }
                            default -> System.out.println("⚠️ Sorry, you picked an invalid option. Please enter 1 or 2.\n");
                        }
                    }
                }
                case 2 -> {
                    boolean validSubChoice = false;
                    while (!validSubChoice) {
                        System.out.println("""
                            Monster Customization 👹
                            ❓ Would you like to customize your sandwich's toppings? 
                            
                               [1] Yes - Customize it 🥬
                               [2] No  - Give it to me as it is ⭐
                            
                            ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                            """);
                        int input3 = Console.promptForInt("👉 Your Response: ");

                        switch (input3) {
                            case 1 -> {
                                System.out.println("🔧 Customizing the sandwich...");
                                sandwich = customMonster();
                                validSubChoice = true;
                            }
                            case 2 -> {
                                System.out.println("✅ The standard Monster Sandwich has been created!");
                                sandwich = monsterSandwich();
                                validSubChoice = true;
                            }
                            default -> System.out.println("⚠️ Sorry, you picked an invalid option. Please enter 1 or 2.\n");
                        }
                    }
                }
                default -> System.out.println("⚠️ Invalid signature sandwich choice. Please choose [1] or [2].\n");
            }
        }

        // Print description only if a sandwich was successfully built
        if (sandwich != null) {
            System.out.println(sandwich.getDescription());
        }

        return sandwich;
    }

    /**
     * Compiles a newly constructed baseline signature setup with user-selected custom ingredients.
     * * @return a customized SayedSignatureSandwich instance
     */
    private static SayedSignitureSandwich customizeSig(){
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

        return sayedSandwich;
    }

    /**
     * Generates a structural baseline layout matching standard preset details for Sayed's Special.
     * * @return a standard built configuration of SayedSignatureSandwich
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

    /**
     * Generates a structural baseline layout matching standard preset details for the Monster Sandwich.
     * * @return a standard built configuration of MonsterSandwich
     */
    private static MonsterSandwich monsterSandwich(){
        MonsterSandwich monsterSandwich = new MonsterSandwich();

        monsterSandwich.addTopping(new Meat(MeatTypes.Steak, "Large", false) );
        monsterSandwich.addTopping(new Meat(MeatTypes.Chicken, "Large", true));
        monsterSandwich.addTopping(new Meat(MeatTypes.Ham, "Large", true));
        monsterSandwich.addTopping(new Meat(MeatTypes.Salami, "Large", true));

        monsterSandwich.addTopping(new Cheese(CheeseTypes.Cheddar, "Large", false));
        monsterSandwich.addTopping(new Cheese(CheeseTypes.Swiss, "Large", true));

        monsterSandwich.addTopping(new RegularTopping(RegularToppingsType.Lettuce));
        monsterSandwich.addTopping(new RegularTopping(RegularToppingsType.Onion));
        monsterSandwich.addTopping(new RegularTopping(RegularToppingsType.Pepper));

        monsterSandwich.addTopping(new Sauces(SauceTypes.Mayo));
        monsterSandwich.addTopping(new Sauces(SauceTypes.Mustard));
        monsterSandwich.addTopping(new Sauces(SauceTypes.Ranch));

        return monsterSandwich;
    }

    /**
     * Compiles a newly constructed baseline Monster sandwich setup with user-selected custom ingredients.
     * * @return a customized MonsterSandwich instance
     */
    private static MonsterSandwich customMonster(){
        MonsterSandwich monsterSandwich = new MonsterSandwich();

        // (4) list of meat
        ArrayList<MeatTypes> listOfMeats = selectMeat("Large");

        for (int i = 0; i < listOfMeats.size(); i++) {
            if (i == 0) {
                monsterSandwich.addTopping(new Meat(listOfMeats.get(i), "Large", false));
            } else {
                monsterSandwich.addTopping(new Meat(listOfMeats.get(i), "Large", true));
            }
        }

        // (5) list of Cheese
        ArrayList<CheeseTypes> listOfCheese = selectCheese("Large");

        for (int i = 0; i < listOfCheese.size(); i++) {
            if (i == 0) {
                monsterSandwich.addTopping(new Cheese(listOfCheese.get(i), "Large", false));
            } else {
                monsterSandwich.addTopping(new Cheese(listOfCheese.get(i), "Large", true));
            }
        }

        // (6) regular toppings
        selectRegularTopping().forEach(topping -> monsterSandwich.addTopping(new RegularTopping(topping)));

        // (7) list of sauces
        selectSauce().forEach(sauce -> monsterSandwich.addTopping(new Sauces(sauce)));

        return monsterSandwich;
    }

    /**
     * Accumulates selected sauce choices until terminated via exit menu options.
     * * @return a tracking list containing chosen sauce variations
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
     * Accumulates specified fresh vegetable choices until explicitly terminated.
     * * @return a tracking list containing chosen vegetable toppings
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
     * Accumulates designated meat variants with automated volume pricing metrics.
     * * @param sizeOfSandwich scale tracker variable matching basic sizing values
     * @return tracking collection layer holding choice values
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
                case 1 -> meatList.add(MeatTypes.Steak);
                case 2 -> meatList.add(MeatTypes.Ham);
                case 3 -> meatList.add(MeatTypes.Salami);
                case 4 -> meatList.add(MeatTypes.Roastbeef);
                case 5 -> meatList.add(MeatTypes.Chicken);
                case 6 -> meatList.add(MeatTypes.Bacon);
                default -> System.out.println("⚠️ Invalid option. Please select from 0 to 6.\n");
            }
        }

        return meatList;
    }

    /**
     * Accumulates choice structures defining chosen premium cheese modifications.
     * * @param sizeOfSandwich layout context flag applied against currency increments
     * @return tracking array of premium cheese modifications
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
                case 1 -> cheeseList.add(CheeseTypes.American);
                case 2 -> cheeseList.add(CheeseTypes.Provolone);
                case 3 -> cheeseList.add(CheeseTypes.Cheddar);
                case 4 -> cheeseList.add(CheeseTypes.Swiss);
                case 5 -> cheeseList.add(CheeseTypes.Paneer);
                default -> System.out.println("⚠️ Invalid option. Please select from 0 to 5.\n");
            }
        }
        return cheeseList;
    }
}
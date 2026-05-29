package com.pluralsight.ui.Screens;

import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.model.drink.Drink;
import com.pluralsight.ui.Console;

/**
 * Handles the user interface screens for choosing drink sizes, flavors, and ice customizations.
 */
public class DrinkScreens {

    /**
     * Guides the user through configuration options to construct and add a drink to their order.
     * @return a fully constructed Drink item matching customer choices
     */
    public static Drink addDrink() {
        DrinkSize drinkSize = drinkSize();
        DrinkFlavor flavor = drinkFlavor();
        String customization = customizeDrinkOption();

        Drink drink = new Drink(drinkSize, flavor, customization);

        System.out.println(drink.getDescription());
        return drink;
    }

    /**
     * Displays the size selection menu and loops until a valid drink size selection is processed.
     * @return the selected DrinkSize enum value
     */
    public static DrinkSize drinkSize() {
        DrinkSize result = null;
        int sizeOfDrink = 0;

        do {
            sizeOfDrink = Console.promptForInt(("""
                ╔══════════════════════════════════════════════════════╗
                ║                SELECT YOUR SIZE 📏                   ║
                ╚══════════════════════════════════════════════════════╝
                
                Choose the perfect size for your Drink!
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

                📏 AVAILABLE SIZES
                   [1] Small   - 16 oz 🥤
                   [2] Medium  - 24 oz 🧋
                   [3] Large   - 32 oz 👑
                
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """));

            switch (sizeOfDrink) {
                case 1 -> result = DrinkSize.Small;
                case 2 -> result = DrinkSize.Medium;
                case 3 -> result = DrinkSize.Large;
                default -> System.out.println("⚠️ Invalid size choice. Please pick [1], [2], or [3].\n");
            }
            if ((sizeOfDrink == 1) || (sizeOfDrink == 2) || (sizeOfDrink == 3)) {
                break;
            }
        } while (true);

        return result;
    }

    /**
     * Displays the refreshment menu and loops until a valid drink flavor selection is processed.
     * @return the selected DrinkFlavor enum value
     */
    public static DrinkFlavor drinkFlavor() {
        DrinkFlavor result = null;

        while (result == null) {
            int flavor = Console.promptForInt("""
                    ╔══════════════════════════════════════════════════════╗
                    ║                SELECT YOUR FLAVOR 🥤                 ║
                    ╚══════════════════════════════════════════════════════╝
                    
                    Choose your favorite refreshment!
                    
                    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                    
                    🥤 DRINK FLAVORS
                       [1]  Coca-Cola       🥤
                       [2]  Sprite          🍋‍🟩
                       [3]  Dr Pepper       🤎
                       [4]  Fanta Orange    🍊
                       [5]  Root Beer       🍺
                       [6]  Lemonade        🍋
                       [7]  Sweet Tea       🫖
                       [8]  Unsweet Tea     🍃
                       [9]  Mountain Dew    🟢
                       [10] Pepsi           🔵
                       [11] Cherry Coke     🍒
                       [12] Fruit Punch     🍓
                    
                    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                    """);

            switch (flavor) {
                case 1 -> result = DrinkFlavor.COCA_COLA;
                case 2 -> result = DrinkFlavor.SPRITE;
                case 3 -> result = DrinkFlavor.DR_PEPPER;
                case 4 -> result = DrinkFlavor.FANTA_ORANGE;
                case 5 -> result = DrinkFlavor.ROOT_BEER;
                case 6 -> result = DrinkFlavor.LEMONADE;
                case 7 -> result = DrinkFlavor.SWEET_TEA;
                case 8 -> result = DrinkFlavor.UNSWEET_TEA;
                case 9 -> result = DrinkFlavor.MOUNTAIN_DEW;
                case 10 -> result = DrinkFlavor.PEPSI;
                case 11 -> result = DrinkFlavor.CHERRY_COKE;
                case 12 -> result = DrinkFlavor.FRUIT_PUNCH;
                default -> System.out.println("⚠️ Invalid drink selection. Please choose a valid number from the menu.\n");
            }
        }

        return result;
    }

    /**
     * Displays preparation choices and loops until a valid custom drink variation string is assigned.
     * @return custom text descriptor string indicating preparation extras
     */
    public static String customizeDrinkOption() {
        String customization = null;

        while (customization == null) {
            System.out.println("""
                    ╔══════════════════════════════════════════════════════╗
                    ║                CUSTOMIZE DRINK OPTIONS 🧊            ║
                    ╚══════════════════════════════════════════════════════╝
    
                    Choose how you want your drink prepared:
    
                       [1] ❄️  Extra Ice
                       [2] 🚫🧊 No Ice
                       [3] 🍋 Lemon Slice
    
                    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                    """);

            int extras = Console.promptForInt("👉 Enter your response here: ");

            switch (extras) {
                case 1 -> customization = "❄️  Extra Ice";
                case 2 -> customization = "🚫🧊 No Ice";
                case 3 -> customization = "🍋 Lemon Slice";
                default -> System.out.println("⚠️ Invalid input. Please select a number from 1 to 3.\n");
            }
        }

        return customization;
    }
}
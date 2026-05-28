package com.pluralsight.ui.Screens;

import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.model.drink.Drink;
import com.pluralsight.ui.Console;

public class DrinkScreens {

    /**
     * This method will be in charge of adding the drink to the order of the customer.
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
     * This method will ask the user what size drink they want. It will return the size of the drink
     * in small, medium, large
     * @return the size of the drink
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
                default -> { }
            }
            if ((sizeOfDrink == 1) || (sizeOfDrink == 2) || (sizeOfDrink == 3)) {
                break;
            }
        } while ((sizeOfDrink != 1) || (sizeOfDrink != 2) || sizeOfDrink != 3);

        return result;
    }

    /**
     * This method will ask the user for what flavor of drink they want. It will return the flavor's name.
     * @return the name of the flavor of drink.
     */
    public static DrinkFlavor drinkFlavor() {
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
        DrinkFlavor result = null;

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
            default -> System.out.println("⚠️ Invalid drink selection.");
        }

        return result;
    }

    /**
     * This method will ask the user for the customization on their drink
     * @return No ice, Extra ice, or add lemon slice.
     */
    public static String customizeDrinkOption() {
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
        String customization = "";

        switch (extras) {
            case 1 -> customization = "❄️  Extra Ice";
            case 2 -> customization = "🚫🧊 No Ice";
            case 3 -> customization = "🍋 Lemon Slice";
            default -> System.out.println("⚠️ Invalid input");
        }

        return customization;
    }
}
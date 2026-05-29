package com.pluralsight.ui.Screens;

import com.pluralsight.enums.ChipFlavor;
import com.pluralsight.model.chips.Chips;
import com.pluralsight.ui.Console;

/**
 * Handles the user interface screens for selecting and adding chips to an order.
 */
public class ChipScreens {

    /**
     * Guides the user through adding a chips side item to their order.
     * @return a fully constructed Chips item containing the selected flavor
     */
    public static Chips addChips() {
        Chips chips = new Chips(kindOfChips());
        System.out.println(chips.getDescription());
        return chips;
    }

    /**
     * Displays the chips selection menu and processes user flavor choices with input validation.
     * @return the selected ChipFlavor enum value
     */
    public static ChipFlavor kindOfChips() {
        ChipFlavor result = null;

        while (result == null) {
            System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                     ADD CHIPS 🍟                     ║
                ╚══════════════════════════════════════════════════════╝
                
                Crunch time! Pick your favorite side.
                
                ════════════════════════════════════════════════════════
                
                🍟 AVAILABLE CHIPS
                   [1] Classic Lay's (Original)     🥔
                   [2] BBQ Chips                    🔥
                   [3] Sour Cream & Onion           🧅
                   [4] Salt & Vinegar               🧂
                   [5] Doritos Nacho Cheese         🧀
                   [6] Doritos Cool Ranch           🤠
                   [7] Cheetos Crunchy              🐆
                   [8] Ruffles Cheddar & Sour Cream 🟡
                
                ════════════════════════════════════════════════════════
                """);

            int input = Console.promptForInt("👉 Please enter the type of chips you want for your order: ");

            switch (input) {
                case 1 -> result = ChipFlavor.CLASSIC_LAYS_ORIGINAL;
                case 2 -> result = ChipFlavor.BBQ_CHIPS;
                case 3 -> result = ChipFlavor.SOUR_CREAM_AND_ONION;
                case 4 -> result = ChipFlavor.SALT_AND_VINEGAR;
                case 5 -> result = ChipFlavor.DORITOS_NACHO_CHEESE;
                case 6 -> result = ChipFlavor.DORITOS_COOL_RANCH;
                case 7 -> result = ChipFlavor.CHEETOS_CRUNCHY;
                case 8 -> result = ChipFlavor.RUFFLES_CHEDDAR_AND_SOUR_CREAM;
                default -> System.out.println("⚠️ Invalid selection. Please choose a valid number from the menu.\n");
            }
        }

        return result;
    }
}
package com.pluralsight.model.chips;

import com.pluralsight.enums.ChipFlavor;
import com.pluralsight.model.order.OrderItem;

/**
 * Represents a side item of chips in an order.
 */
public class Chips implements OrderItem {
    private ChipFlavor typeOfChips;

    double price;

    /**
     * Gets the flavor type of the chips.
     * @return the chip flavor enum
     */
    public ChipFlavor getTypeOfChips() {
        return typeOfChips;
    }

    /**
     * Sets the flavor type of the chips.
     * @param typeOfChips the chip flavor enum to set
     */
    public void setTypeOfChips(ChipFlavor typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    /**
     * Gets the fixed price of the chips side item.
     * @return the price as a double
     */
    public double getPrice(){
        return 1.50;
    }

    /**
     * Generates a detailed console display block for the chips selection.
     * @return formatted console string banner
     */
    @Override
    public String getDescription() {

        return """
                ╔══════════════════════════════════════════════════════╗
                ║                 🍟 Chips DETAILS                     ║
                ╚══════════════════════════════════════════════════════╝
    
                """
                + line("Type:", String.valueOf(typeOfChips), getPrice()) + "\n"
                + """
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """;


    }

    /**
     * Formats the chips data cleanly into a single row line item for the final receipt.
     * @return a columns-aligned string for receipt formatting
     */
    public String forReceipt() {

        return String.format("   %-12s %-28s $%6.2f%n",
                "Chips:",
                typeOfChips.toString(),
                getPrice()
        );
    }

    /**
     * Constructs a Chips object with a specified flavor.
     * @param typeOfChips the initial flavor selection enum
     */
    public Chips(ChipFlavor typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    /**
     * Formats a single specification line matching standard column rules.
     */
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

    /**
     * Returns an expanded string layout of the chips details for display.
     * @return a detailed text block containing total costs
     */
    @Override
    public String toString() {
        return                                                  """
                                                            ╔══════════════════════════════════════════════════════╗
                                                            ║                 🍟 Chips DETAILS                     ║
                                                            ╚══════════════════════════════════════════════════════╝

                                                            """
                + line("Type:", String.valueOf(typeOfChips), getPrice())
                + line("Type:", String.valueOf(typeOfChips), 0.00) + "\n\n"
                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n"
                + """
                                                            ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                            """;
    }

}

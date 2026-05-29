package com.pluralsight.model.drink;

import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.model.order.OrderItem;

/**
 * Represents a drink item included in a customer's order.
 */
public class Drink implements OrderItem {
    private DrinkSize size; //small, medium, large
    private DrinkFlavor flavor; //Coke, Fanta, Sprite, RootBeer etc...
    private String extras;

    //-----------------------getters and setters and constructor-------------------------------------------

    /**
     * Gets the size of the drink.
     * @return the drink size enum
     */
    public DrinkSize getSize() {
        return size;
    }

    /**
     * Sets the size of the drink.
     * @param size the drink size enum to set
     */
    public void setSize(DrinkSize size) {
        this.size = size;
    }

    /**
     * Gets the flavor of the drink.
     * @return the drink flavor enum
     */
    public DrinkFlavor getFlavor() {
        return flavor;
    }

    /**
     * Sets the flavor of the drink.
     * @param flavor the drink flavor enum to set
     */
    public void setFlavor(DrinkFlavor flavor) {
        this.flavor = flavor;
    }

    /**
     * Gets any added customizations for the drink.
     * @return the customization text string
     */
    public String getExtras() {
        return extras;
    }

    /**
     * Sets any customizations for the drink.
     * @param extras the customization text string to set
     */
    public void setExtras(String extras) {
        this.extras = extras;
    }

    /**
     * Constructs a Drink object with a specified size, flavor, and customization.
     * @param size the chosen drink size enum
     * @param flavor the chosen drink flavor enum
     * @param extras the customization text string
     */
    public Drink(DrinkSize size, DrinkFlavor flavor, String extras) {
        this.size = size;
        this.flavor = flavor;
        this.extras = extras;
    }

    //-------------------these methods are the ones that are inside of OrderItem interface.-----------------------------

    /**
     * Calculates the price of the drink based on its designated size.
     * @return the price of the size selection as a double
     */
    @Override
    public double getPrice(){

        DrinkSize size = getSize();

        double priceSize = 0;

        switch (size){
            case DrinkSize.Small ->  priceSize += 2.00;
            case DrinkSize.Medium -> priceSize += 2.50;
            case DrinkSize.Large -> priceSize += 3.00;
            default -> System.out.println("Wrong selection");

        }

        return priceSize;
    }

    /**
     * Generates a detailed console display block for the drink summary.
     * @return formatted console string banner
     */
    @Override
    public String getDescription() {
        return """
                            ╔══════════════════════════════════════════════════════╗
                            ║                  🥤 Drink DETAILS                    ║
                            ╚══════════════════════════════════════════════════════╝
                
                            """
                + line("📏 Size:", String.valueOf(size), getPrice()) + "\n"
                + line("\uD83E\uDD64 Flavor:", String.valueOf(flavor), 0.00) + "\n"
                + line("⚙\uFE0F Customize:", String.valueOf(extras), 0.00) + "\n\n"
                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n"
                + """
                            ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                            """;
    }

    /**
     * Formats the drink data cleanly into a single row line item for the final receipt.
     * @return a columns-aligned string for receipt formatting
     */
    public String forReceipt() {
        // Combines size, flavor, and extras into a readable single-line item description
        String itemDetails = String.format("%s %s (%s)", size, flavor, extras);

        // Aligns perfectly with the columns in your sandwich and chips receipt items
        return String.format("   %-12s %-28s $%6.2f%n",
                "Drink:",
                itemDetails,
                getPrice()
        );
    }

    //-----------------------------------------------------Showcase-----------------------------------------------------

    /**
     * Formats a single specification line matching standard column rules.
     */
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

    /**
     * Returns an expanded string layout of the drink details for customer review.
     * @return a detailed text block containing size, flavor, extras, and total cost
     */
    @Override
    public String toString() {
        return """
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                  🥤 Drink DETAILS                    ║
                                                                ╚══════════════════════════════════════════════════════╝

                                                                """
                + line("📏 Size:", String.valueOf(size), getPrice()) + "\n"
                + line("\uD83E\uDD64 Flavor:", String.valueOf(flavor), 0.00) + "\n"
                + line("⚙\uFE0F Customize:", String.valueOf(extras), 0.00) + "\n\n"
                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n"
                + """
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                                                                """;
    }
}
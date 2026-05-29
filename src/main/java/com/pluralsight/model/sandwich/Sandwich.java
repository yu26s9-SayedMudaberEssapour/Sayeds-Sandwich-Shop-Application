package com.pluralsight.model.sandwich;

import com.pluralsight.enums.*;
import com.pluralsight.model.order.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Represents a customizable sandwich item within an order.
 */
public class Sandwich implements OrderItem {

    // --- Fields ---
    private String sandwichSize; // ask the user for 4" 8" 12"
    private Bread typeOfBread;
    private List<Toppings> toppings;
    protected String shouldToast; // yes = true, no = false

    // --- Constructor ---
    /**
     * Constructs a custom Sandwich with a size, bread type, and toasting preference.
     * @param sandwichSize the chosen size of the sandwich (e.g., Small, Medium, Large)
     * @param typeOfBread the type of bread wrapper object
     * @param shouldToast the user response indicating if the sandwich should be toasted
     */
    public Sandwich(String sandwichSize, Bread typeOfBread, String shouldToast) {
        this.sandwichSize = sandwichSize;
        this.typeOfBread = typeOfBread;
        this.shouldToast = shouldToast;
        this.toppings = new ArrayList<>();
    }

    // --- Getters & Setters ---
    /**
     * Gets the size designation of the sandwich.
     * @return the size string
     */
    public String getSandwichSize() {
        return sandwichSize;
    }

    /**
     * Gets the raw bread type enum value.
     * @return the bread type enum
     */
    public BreadType getTypeOfBread() {
        return typeOfBread.breadType;
    }

    /**
     * Gets the list of toppings added to this sandwich.
     * @return a list of toppings
     */
    public List<Toppings> getToppings() {
        return toppings;
    }

    /**
     * Gets the toast option preference string.
     * @return the toast choice string
     */
    public String getShouldToast() {
        return shouldToast;
    }

    // --- Public Business Logic Methods ---
    /**
     * Adds a specific topping to the sandwich's topping tracker list.
     * @param topping the topping instance to add
     */
    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    /**
     * Determines the base price tier depending on the size of the sandwich.
     * @return the base size price as a double
     */
    public double priceOfSize() {
        String sizeOfBread = getSandwichSize();
        double priceSize = 0;
        switch (sizeOfBread) {
            case "Small" -> priceSize += 5.50;
            case "Medium" -> priceSize += 7.00;
            case "Large" -> priceSize += 8.50;
        }
        return priceSize;
    }

    /**
     * Calculates the combined price accumulated from all added premium toppings.
     * @return total premium toppings cost
     */
    public double getPriceToppings() {
        double total = 0;
        for (Toppings topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    // --- Overridden Methods ---
    /**
     * Calculates the grand total price of the sandwich (base size price + toppings).
     * @return total sandwich price as a double
     */
    @Override
    public double getPrice() {
        return priceOfSize() + getPriceToppings();
    }

    /**
     * Generates a detailed console display interface summary block of the sandwich.
     * @return formatted console display string
     */
    @Override
    public String getDescription() {
        StringBuilder toppingDetails = new StringBuilder();

        for (Toppings topping : toppings) {
            toppingDetails.append(
                    String.format(
                            "   • %-12s %-28s $%6.2f%n",
                            topping.getClass().getSimpleName() + ":",
                            topping.toString(),
                            topping.getPrice()
                    )
            );
        }

        return """
                ╔══════════════════════════════════════════════════════╗
                ║                 🥪 SANDWICH DETAILS                  ║
                ╚══════════════════════════════════════════════════════╝
                """
                + line("📏 Size:", String.valueOf(sandwichSize), priceOfSize()) + "\n"
                + line("🍞 Bread:", String.valueOf(typeOfBread.breadType), 0) + "\n"
                + line("🔥 Toasted:", String.valueOf(shouldToast), 0) + "\n"
                + "   🥬 Toppings:\n"
                + toppingDetails + "\n"
                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n";
    }

    /**
     * Formats the sandwich data and nested toppings breakdown strictly for final receipt generation.
     * @return columns-aligned receipt output text block
     */
    public String forReceipt() {
        StringBuilder receiptBuilder = new StringBuilder();

        // 1. Core Sandwich Line Item
        String sandwichCore = String.format("%s, %s", sandwichSize, typeOfBread.breadType);
        receiptBuilder.append(String.format("   %-12s %-28s $%6.2f%n",
                "Sandwich:",
                sandwichCore,
                priceOfSize()
        ));

        // 2. Prep Option Line (Toasted)
        receiptBuilder.append(String.format("     ↳ %-36s $%.2f%n",
                "Toasted: " + shouldToast,
                0.00
        ));

        // 3. Loop Through and Append Every Topping
        for (Toppings topping : toppings) {
            receiptBuilder.append(String.format("     • %-8s %-26s $%6.2f%n",
                    topping.getClass().getSimpleName() + ":",
                    topping.toString().trim(),
                    topping.getPrice()
            ));
        }

        return receiptBuilder.toString();
    }

    // --- Private Helper Methods ---
    /**
     * Formats a single specification line matching standard column rules.
     */
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }
}
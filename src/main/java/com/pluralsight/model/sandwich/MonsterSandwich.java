package com.pluralsight.model.sandwich;

import com.pluralsight.enums.BreadType;

import java.util.ArrayList;
import java.util.List;

public class MonsterSandwich extends Sandwich{
    // --- Fields ---
    private final String Name = "Monster-Sandwich";
    private final boolean shouldToast = true;
    private final String sandwichSize = "Large";
    private List<Toppings> toppingsList;

    public MonsterSandwich() {
        super("Large", new Bread(BreadType.WhiteBread), "Yes");
        this.toppingsList = new ArrayList<>();



    }


    // --- Getters ---
    /**
     * Gets the name of the signature sandwich.
     * @return the sandwich name string
     */
    public String getName() {
        return Name;
    }

    /**
     * Checks if the sandwich is set to be toasted.
     * @return true if toasted, false otherwise
     */
    public boolean isShouldToast() {
        return shouldToast;
    }

    // --- Overridden Methods ---
    /**
     * Gets the custom toppings list for this signature sandwich.
     * @return list of toppings
     */
    @Override
    public List<Toppings> getToppings() {
        return toppingsList;
    }

    /**
     * Calculates the total price of the sandwich including toppings.
     * @return total price
     */
    @Override
    public double getPrice() {
        return priceOfSize() + getPriceToppings();
    }

    /**
     * Determines the base price depending on the sandwich size.
     * @return base price of the size
     */
    @Override
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
     * Calculates the combined price of all added toppings.
     * @return total toppings cost
     */
    @Override
    public double getPriceToppings() {
        double total = 0;
        for (Toppings topping : toppingsList) {
            total += topping.getPrice();
        }
        return total;
    }

    /**
     * Gets the bread type chosen for this sandwich from the parent class.
     * @return bread type enum
     */
    @Override
    public BreadType getTypeOfBread() {
        return super.getTypeOfBread();
    }

    /**
     * Gets the designated size of the sandwich.
     * @return size string
     */
    @Override
    public String getSandwichSize() {
        return sandwichSize;
    }

    /**
     * Adds a topping directly to this signature sandwich's tracker.
     * @param topping the topping to add
     */
    @Override
    public void addTopping(Toppings topping) {
        this.toppingsList.add(topping);
    }

    /**
     * Generates a detailed console display menu for the sandwich summary.
     * @return formatted console string
     */
    @Override
    public String getDescription() {
        StringBuilder toppingDetails = new StringBuilder();

        for (Toppings topping : toppingsList) {
            toppingDetails.append(
                    String.format(
                            "   • %-12s %-28s $%6.2f%n",
                            topping.getClass().getSimpleName() + ":",
                            topping.toString().trim(),
                            topping.getPrice()
                    )
            );
        }

        return """
            ╔══════════════════════════════════════════════════════╗
            ║            👹 Monster SANDWICH DETAILS               ║
            ╚══════════════════════════════════════════════════════╝
            """
                + line("📏 Size:", sandwichSize, priceOfSize()) + "\n"
                + line("🍞 Bread:", String.valueOf(super.getTypeOfBread()), 0) + "\n"
                + line("🔥 Toasted:", String.valueOf(shouldToast ? "yes" : "no"), 0) + "\n"
                + "   🥬 Toppings:\n"
                + toppingDetails + "\n"
                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n";
    }

    /**
     * Formats the signature sandwich breakdown strictly for receipt printing.
     * @return formatted receipt block
     */
    @Override
    public String forReceipt() {
        StringBuilder receiptBuilder = new StringBuilder();

        String sandwichCore = String.format("%s, %s", sandwichSize, super.getTypeOfBread());
        receiptBuilder.append(String.format("   %-12s %-28s $%6.2f%n",
                "Sandwich:",
                sandwichCore,
                priceOfSize()
        ));

        receiptBuilder.append(String.format("     ↳ %-36s $%.2f%n",
                "Toasted: " + shouldToast,
                0.00
        ));

        for (Toppings topping : toppingsList) {
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

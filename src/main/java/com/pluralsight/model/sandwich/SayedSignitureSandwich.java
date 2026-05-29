package com.pluralsight.model.sandwich;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class SayedSignitureSandwich extends Sandwich{
    private final String Name = "Sayed's-Signature-Sandwich";
    private final boolean shouldToast = true;
    private final String sandwichSize = "Large"; // ask the user for 4" 8" 12"
    private final BreadType typeOfBread = BreadType.WheatBread;

    private List<Toppings> topping;

    public SayedSignitureSandwich() {
        super("Large", new Bread(BreadType.WhiteBread), "Yes");

        this.topping = new ArrayList<>();

    }



    public String getName() {
        return Name;
    }

    @Override
    public List<Toppings> getToppings() {
        return topping;
    }

    @Override
    public BreadType getTypeOfBread() {
        return typeOfBread;
    }

    @Override
    public String getSandwichSize() {
        return sandwichSize;
    }

    public boolean isShouldToast() {
        return shouldToast;
    }

    @Override
    public void addTopping(Toppings topping) {
        super.addTopping(topping);
    }



    @Override
    public String getDescription() {
        StringBuilder toppingDetails = new StringBuilder();

        // Loop through the inherited toppings list
        for (Toppings topping : getToppings()) {
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
            ║            👑 SIGNATURE SANDWICH DETAILS             ║
            ╚══════════════════════════════════════════════════════╝
            """
                + String.format("   %-12s %-30s $%.2f%n", "📏 Size:", getSandwichSize(), priceOfSize())
                + String.format("   %-12s %-30s $%.2f%n", "🍞 Bread:", "WheatBread", 0.00) // Adjust if dynamic
                + String.format("   %-12s %-30s $%.2f%n", "🔥 Toasted:", getShouldToast(), 0.00)
                + "   🥬 Toppings:\n"
                + (toppingDetails.length() == 0 ? "     (No toppings added)\n" : toppingDetails) + "\n"
                + String.format("   💲 %-42s $%.2f%n", "TOTAL:", getPrice());
    }

    // --- Private Helper Methods ---
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

}

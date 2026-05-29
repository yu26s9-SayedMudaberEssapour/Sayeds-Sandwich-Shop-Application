package com.pluralsight.model.sandwich;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class SayedSignitureSandwich extends Sandwich{
    private final String Name = "Sayed's-Signature-Sandwich";
    private final boolean shouldToast = true;
    private final String sandwichSize = "Large"; // ask the user for 4" 8" 12"
    private BreadType typeOfBread;

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
    public double getPrice(){
        return priceOfSize() + getPriceToppings();
    }
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

    @Override
    public double getPriceToppings() {
        double total = 0;
        for (Toppings topping : topping) {
            total += topping.getPrice();
        }
        return total;
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
                + line("📏 Size:", String.valueOf(sandwichSize), priceOfSize()) + "\n"
                + line("🍞 Bread:", String.valueOf(getTypeOfBread()), 0) + "\n"
                + line("🔥 Toasted:", String.valueOf(shouldToast), 0) + "\n"
                + "   🥬 Toppings:\n"
                + toppingDetails + "\n"
                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n";
    }

    // --- Private Helper Methods ---
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

}

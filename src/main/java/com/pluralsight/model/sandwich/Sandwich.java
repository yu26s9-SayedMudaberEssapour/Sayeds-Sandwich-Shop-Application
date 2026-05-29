package com.pluralsight.model.sandwich;

import com.pluralsight.enums.*;
import com.pluralsight.model.order.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Sandwich implements OrderItem {

    // --- Fields ---
    private String sandwichSize; // ask the user for 4" 8" 12"
    private Bread typeOfBread;
    private List<Toppings> toppings;
    protected String shouldToast; // yes = true, no = false

    // --- Constructor ---
    public Sandwich(String sandwichSize, Bread typeOfBread, String shouldToast) {
        this.sandwichSize = sandwichSize;
        this.typeOfBread = typeOfBread;
        this.shouldToast = shouldToast;
        this.toppings = new ArrayList<>();

    }

    // --- Getters & Setters ---
    public String getSandwichSize() {
        return sandwichSize;
    }

    public BreadType getTypeOfBread() {
        return typeOfBread.breadType;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public String getShouldToast() {
        return shouldToast;
    }

    // --- Public Business Logic Methods ---
    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

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

    public double getPriceToppings() {
        double total = 0;
        for (Toppings topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    public double getPriceMeatInSandwich() {
        double regular = 0;
        double extra = 0;
        double meatCounter = 0;

        for (Toppings topping : toppings) {
            if (topping.isPremium() && (topping instanceof Meat)) {
                Meat meat = (Meat) topping;
                meatCounter++;
                if (meatCounter < 1) {
                    regular += meat.getPrice();
                } else {
                    extra += meat.getPriceForExtra();
                }
            }
        }
        return regular + extra;
    }

    public void toppingPrice() {
        for (Toppings t : toppings) {
            if (t.isPremium() && t instanceof Meat) {
                // Left empty as in original code
            }
        }
    }

    public String toReceiptString() {
        return null;
    }

    // --- Overridden Methods ---
    @Override
    public double getPrice() {
        return priceOfSize() + getPriceToppings();
    }

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
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

//    @Override
//    public String toString() {
//        return """
//                                                                ╔══════════════════════════════════════════════════════╗
//                                                                ║                 🥪 SANDWICH DETAILS                  ║
//                                                                ╚══════════════════════════════════════════════════════╝
//
//                                                                """
//                                                                + line("📏 Size:", String.valueOf(sandwichSize), priceOfSize()) + "\n"
//                                                                + line("🍞 Bread:", String.valueOf(typeOfBread), 0) + "\n"
//                                                                + line("🔥 Toasted:", String.valueOf(shouldToast), 0) + "\n"
//                                                                + line("🥩 Meat:", String.valueOf(Meat.getMeatType()), 0) + "\n"
//                                                                + line("🧀 Cheese:", String.valueOf(Cheese.getType()), 0) + "\n"
//                                                                + line("🥫 Sauces:", String.valueOf(Sauces.getSauce()), 0) + "\n"
//                                                                + line("🥬 Toppings:", String.valueOf(toppings), 0) + "\n\n"
//                                                                + String.format("   💲 %-42s $%.2f", "TOTAL:", getPrice()) + "\n"
//                                                                + """
//                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
//        """;
//    }
}
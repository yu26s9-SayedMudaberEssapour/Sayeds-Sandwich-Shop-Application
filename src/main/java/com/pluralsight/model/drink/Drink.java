package com.pluralsight.model.drink;

import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.model.order.OrderItem;

public class Drink implements OrderItem {
    private DrinkSize size; //small, medium, large
    private DrinkFlavor flavor; //Coke, Fanta, Sprite, RootBeer etc...
    private String extras;


    //-----------------------getters and setters and constructor-------------------------------------------


    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(DrinkFlavor flavor) {
        this.flavor = flavor;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Drink(DrinkSize size, DrinkFlavor flavor, String extras) {
        this.size = size;
        this.flavor = flavor;
        this.extras = extras;
    }

    //-------------------these methods are the ones that are inside of OrderItem interface.-----------------------------
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
    //check this method
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }
    //this would be for the sake of showcasing to customers
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
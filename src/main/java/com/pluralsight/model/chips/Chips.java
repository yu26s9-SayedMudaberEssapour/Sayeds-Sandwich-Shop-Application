package com.pluralsight.model.chips;

import com.pluralsight.enums.ChipFlavor;
import com.pluralsight.model.order.OrderItem;

public class Chips implements OrderItem {
    private ChipFlavor typeOfChips;

    double price;

    public ChipFlavor getTypeOfChips() {
        return typeOfChips;
    }

    public void setTypeOfChips(ChipFlavor typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    public double getPrice(){
        return 1.50;
    }




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

    public String forReceipt() {

        return String.format("   %-12s %-28s $%6.2f%n",
                "Chips:",
                typeOfChips.toString(),
                getPrice()
        );
    }





    public Chips(ChipFlavor typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    //check this method
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

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

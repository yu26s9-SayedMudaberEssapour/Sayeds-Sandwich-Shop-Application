package com.pluralsight.ItemsInTheShop;

public class Chips extends OrderItems{
    private String typeOfChips;

    double price;

    public String getTypeOfChips() {
        return typeOfChips;
    }

    public void setTypeOfChips(String typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    public Chips(String typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    public double getPrice(){
        return 1.50;
    }

    //check this method
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }

    @Override
    public String toString() {
        return                                                  """
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                 🥪 SANDWICH DETAILS                  ║
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

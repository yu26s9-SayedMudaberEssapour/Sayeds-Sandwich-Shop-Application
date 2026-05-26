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

    @Override
    public String toString() {
        return """
    ===== Chips =====
    Type of Chips: %s
    Price: $%.2f
    
    """.formatted(
                typeOfChips,
                getPrice()
        );
    }

}

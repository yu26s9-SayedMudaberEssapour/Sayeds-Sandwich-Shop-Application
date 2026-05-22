package com.pluralsight.ItemsInTheShop;

public abstract class Chips {
    private String typeOfChips;


    public String getTypeOfChips() {
        return typeOfChips;
    }

    public void setTypeOfChips(String typeOfChips) {
        this.typeOfChips = typeOfChips;
    }

    public Chips(String typeOfChips) {
        this.typeOfChips = typeOfChips;
    }
}

package com.pluralsight.ItemsInTheShop;

public class Chips {
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

}

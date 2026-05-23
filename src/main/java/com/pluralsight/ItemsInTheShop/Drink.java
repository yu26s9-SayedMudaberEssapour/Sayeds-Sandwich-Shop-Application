package com.pluralsight.ItemsInTheShop;

public class Drink {
    private String size; //small, medium, large
    private String flavor; //Coke, Fanta, Sprite, RootBeer etc...
    private String extras;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Drink(String size, String flavor, String extras){
        this.flavor = flavor;
        this.size = size;
        this.extras = extras;
    }
}

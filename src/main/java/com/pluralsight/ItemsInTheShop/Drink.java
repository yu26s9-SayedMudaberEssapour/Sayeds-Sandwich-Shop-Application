package com.pluralsight.ItemsInTheShop;

public abstract class Drink {
    private String size; //small, medium, large
    private String flavor; //Coke, Fanta, Sprite, RootBeer etc...

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

    public Drink(String size, String flavor){
        this.flavor = flavor;
        this.size = size;
    }
}

package com.pluralsight.model.sandwich;

import com.pluralsight.enums.SauceTypes;

public class Sauces extends Toppings{

    private SauceTypes sauce;

    public Sauces(SauceTypes sauce) {
        this.sauce = sauce;
    }

    public SauceTypes getSauce() {
        return sauce;
    }

    @Override
    public String toString() {
        return
                sauce + " ";

    }
}

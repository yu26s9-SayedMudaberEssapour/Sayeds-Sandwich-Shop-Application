package com.pluralsight.model.sandwich;

import com.pluralsight.enums.SauceTypes;

public class Sauces extends Toppings{
    /**
     * field for sauce
     */
    private SauceTypes sauce;

    /**
     * getter for sause
     * @return the sauce in class
     */
    public SauceTypes getSauce() {
        return sauce;
    }
    /**
     * constructor
     * @param sauce
     */
    public Sauces(SauceTypes sauce) {
        this.sauce = sauce;
    }


    /**
     * to string method
     * @return
     */
    @Override
    public String toString() {
        return
                sauce + " ";

    }
}

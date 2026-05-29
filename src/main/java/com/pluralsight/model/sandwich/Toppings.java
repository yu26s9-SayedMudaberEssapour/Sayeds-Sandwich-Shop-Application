package com.pluralsight.model.sandwich;

import com.pluralsight.enums.CheeseTypes;
import com.pluralsight.enums.MeatTypes;
import com.pluralsight.enums.RegularToppingsType;
import com.pluralsight.enums.SauceTypes;

import java.util.ArrayList;

/**
 * Represents an abstract base topping for a sandwich.
 */
public abstract class Toppings {

    private boolean isPremium;

    private boolean isExtra;

    /**
     * Checks if the topping is classified as a premium add-on.
     * @return true if premium, false otherwise
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * Checks if this is an extra portion of the topping.
     * @return true if an extra portion, false otherwise
     */
    public boolean isExtra() {
        return isExtra;
    }

    /**
     * Generates a text description for the topping.
     * @return an empty description string by default
     */
    public String description(){
        return "";
    }

    /**
     * Calculates the price of the topping.
     * @return 0.00 by default unless overridden by specific topping tiers
     */
    public double getPrice(){
        return 0;
    }

}
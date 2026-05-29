package com.pluralsight.model.sandwich;

import com.pluralsight.enums.*;
import java.util.ArrayList;

/**
 * Represents a cheese premium topping for a sandwich.
 */
public class Cheese extends PremiumTopping {

    // --- Fields ---
    private CheeseTypes type;
    private String cheeseSize;
    private boolean isExtra;

    // --- Constructor ---
    /**
     * Constructs a Cheese topping with a specific type, size, and extra status.
     * @param type the type of cheese enum
     * @param cheeseSize the size of the sandwich/topping string
     * @param isExtra true if the customer ordered extra cheese, false otherwise
     */
    public Cheese(CheeseTypes type, String cheeseSize, boolean isExtra) {
        this.type = type;
        this.cheeseSize = cheeseSize;
        this.isExtra = isExtra;
    }

    // --- Getters & Setters ---
    /**
     * Gets the specific type of cheese.
     * @return the cheese type enum
     */
    public CheeseTypes getType() {
        return type;
    }

    /**
     * Gets the sandwich size designation for this topping.
     * @return the size string
     */
    public String getCheeseSize() {
        return cheeseSize;
    }

    /**
     * Checks if this cheese is an extra portion.
     * @return true if extra portion, false otherwise
     */
    public boolean getIsExtra() {
        return isExtra;
    }

    /**
     * Sets whether this cheese is an extra portion.
     * @param isExtra true for an extra portion, false for regular
     */
    public void setIsExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }

    // --- Overridden Methods ---
    /**
     * Calculates the price of the cheese based on the sandwich size and extra status.
     * @return the total price of the cheese portion as a double
     */
    @Override
    public double getPrice() {
        if (getIsExtra()) {
            return getPriceForExtra();
        } else {
            double price = 0;
            switch (getCheeseSize()) {
                case "Small", "small" -> price = 0.75;
                case "Medium", "medium" -> price = 1.50;
                case "Large", "large" -> price = 2.25;
            }
            return price;
        }
    }

    /**
     * Determines the standalone surcharge for adding an extra portion of cheese.
     * @return the extra cheese price as a double
     */
    @Override
    public double getPriceForExtra() {
        double extraPrice = 0;
        switch (getCheeseSize()) {
            case "Small", "small" -> extraPrice = 0.30;
            case "Medium", "medium" -> extraPrice = 0.60;
            case "Large", "large" -> extraPrice = 0.90;
        }
        return extraPrice;
    }

    /**
     * Returns the string presentation of the cheese type name.
     * @return the cheese type string with a trailing space
     */
    @Override
    public String toString() {
        return type + " ";
    }
}
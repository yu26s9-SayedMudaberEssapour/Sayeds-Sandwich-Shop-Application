package com.pluralsight.model.sandwich;

import com.pluralsight.enums.*;

/**
 * Represents a meat premium topping for a sandwich.
 */
public class Meat extends PremiumTopping {

    // --- Fields ---
    private MeatTypes MeatTypes;
    private String MeatSize;
    private boolean isExtra;

    // --- Constructor ---
    /**
     * Constructs a Meat topping with a specific type, size, and extra status.
     * @param MeatTypes the type of meat enum
     * @param MeatSize the size of the sandwich/topping string
     * @param isExtra true if the customer ordered extra meat, false otherwise
     */
    public Meat(MeatTypes MeatTypes, String MeatSize, boolean isExtra) {
        this.MeatTypes = MeatTypes;
        this.MeatSize = MeatSize;
        this.isExtra = isExtra;
    }

    // --- Getters ---
    /**
     * Checks if this meat is an extra portion.
     * @return true if extra portion, false otherwise
     */
    @Override
    public boolean isExtra() {
        return isExtra;
    }

    /**
     * Gets the specific type of meat.
     * @return the meat type enum
     */
    public MeatTypes getMeatType() {
        return MeatTypes;
    }

    /**
     * Gets the sandwich size designation for this topping.
     * @return the size string
     */
    public String getMeatSize() {
        return MeatSize;
    }

    // --- Overridden Methods ---
    /**
     * Calculates the price of the meat based on the sandwich size and extra status.
     * @return the total price of the meat portion as a double
     */
    @Override
    public double getPrice() {
        if (isExtra()) {
            return getPriceForExtra();
        } else {
            double price = 0;
            switch (getMeatSize()) {
                case "Small", "small" -> price = 1.0;
                case "Medium", "medium" -> price = 2.0;
                case "Large", "large" -> price = 3.0;
            }
            return price;
        }
    }

    /**
     * Determines the standalone surcharge for adding an extra portion of meat.
     * @return the extra meat price as a double
     */
    @Override
    public double getPriceForExtra() {
        double extraPrice = 0;
        switch (getMeatSize()) {
            case "Small", "small" -> extraPrice = 0.50;
            case "Medium", "medium" -> extraPrice = 1.00;
            case "Large", "large" -> extraPrice = 1.50;
        }
        return extraPrice;
    }

    /**
     * Returns the string presentation of the meat type name.
     * @return the meat type string with a trailing space
     */
    @Override
    public String toString() {
        return MeatTypes + " ";
    }
}
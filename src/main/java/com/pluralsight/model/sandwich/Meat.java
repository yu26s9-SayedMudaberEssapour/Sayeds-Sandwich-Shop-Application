package com.pluralsight.model.sandwich;

import com.pluralsight.enums.*;

public class Meat extends PremiumTopping {

    // --- Fields ---
    private MeatTypes MeatTypes;
    private String MeatSize;
    private boolean isExtra;

    // --- Constructor ---
    public Meat(MeatTypes MeatTypes, String MeatSize, boolean isExtra) {
        this.MeatTypes = MeatTypes;
        this.MeatSize = MeatSize;
        this.isExtra = isExtra;
    }

    // --- Getters ---
    @Override
    public boolean isExtra() {
        return isExtra;
    }

    public MeatTypes getMeatType() {
        return MeatTypes;
    }

    public String getMeatSize() {
        return MeatSize;
    }

    // --- Overridden Methods ---
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

    @Override
    public String toString() {
        return MeatTypes + " ";
    }
}
package com.pluralsight.model.sandwich;

import com.pluralsight.enums.*;
import java.util.ArrayList;

public class Cheese extends PremiumTopping {

    // --- Fields ---
    private CheeseTypes type;
    private String cheeseSize;
    private boolean isExtra;

    // --- Constructor ---
    public Cheese(CheeseTypes type, String cheeseSize, boolean isExtra) {
        this.type = type;
        this.cheeseSize = cheeseSize;
        this.isExtra = isExtra;
    }

    // --- Getters & Setters ---
    public CheeseTypes getType() {
        return type;
    }

    public String getCheeseSize() {
        return cheeseSize;
    }

    public boolean getIsExtra() {
        return isExtra;
    }

    public void setIsExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }

    // --- Overridden Methods ---
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

    @Override
    public String toString() {
        return type + " ";
    }
}
package com.pluralsight.ingredients;

import java.util.List;

public class Cheese implements PremiumTopping{

    private static final String[] typeOfCheese = {"american", "provolone", "chedder", "swiss" , "paneer"};

    public static String[] getTypeOfCheese() {
        return typeOfCheese;
    }


    @Override
    public double priceForRegular(int sizeCheese){
        double price = 0;
        switch (sizeCheese){
            case 4:
                price = .75;
                break;
            case 8:
                price = 1.5;
                break;
            case 12:
                price = 2.25;
                break;
            default:
                break;
        }
        return price;
    }

    @Override
    public float priceForExtra(int size) {
        float finalPrice = 0;
        switch (size){
            case 4:
                finalPrice += 0.30f;
                break;
            case 8:
                finalPrice += 0.60f;
                break;
            case 12:
                finalPrice += 0.90f;
                break;
            default:
                break;
        }
        return finalPrice;
    }
}

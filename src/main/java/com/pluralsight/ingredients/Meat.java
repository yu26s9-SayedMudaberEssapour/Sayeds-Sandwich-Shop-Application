package com.pluralsight.ingredients;

import java.util.ArrayList;
import java.util.List;

public class Meat implements PremiumTopping{
    private static final String[] typeOfMeat = {"steam", "ham", "salami", "roast beef", "chicken", "bacon"};


    @Override
    public double priceForRegular(int sizeMeat){
        double price = 0;
        switch (sizeMeat){
            case 4:
                price = 1.0;
                break;
            case 8:
                price = 2.0;
                break;
            case 12:
                price = 3.0;
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
                finalPrice += 0.50f;
                break;
            case 8:
                finalPrice += 1.00f;
                break;
            case 12:
                finalPrice += 1.50f;
                break;
            default:
                break;
        }
        return finalPrice;
    }

    public static String[] getTypeOfMeat() {
        return typeOfMeat;
    }
}

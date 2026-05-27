package com.pluralsight.ingredients;

public class Cheese implements PremiumTopping {
    private ListOfMeats type;

    @Override
    public double getPriceForRegular(int size){
        double price = 0;
        switch (size){
            case 4:
                price = 0.75;
                break;
            case 8:
                price = 1.50;
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
    public float getPriceForExtra(int size) {
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

    @Override
    public Object getType(Object type) {
        return type;
    }
}

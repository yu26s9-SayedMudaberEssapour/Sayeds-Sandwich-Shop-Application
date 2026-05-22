package com.pluralsight.ingredients;

import java.util.List;

public class Meat implements Ingredients{
    private List<String> typeOfMeat;


    private void loadMeat(){
        typeOfMeat.add("steam");
        typeOfMeat.add("ham");
        typeOfMeat.add("salami");
        typeOfMeat.add("roast beef");
        typeOfMeat.add("chicken");
        typeOfMeat.add("bacon");
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

}

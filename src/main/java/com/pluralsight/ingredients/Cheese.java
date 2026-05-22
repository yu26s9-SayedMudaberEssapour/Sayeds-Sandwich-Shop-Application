package com.pluralsight.ingredients;

import java.util.List;

public class Cheese implements PremiumTopping{

    private List<String> typeOfCheese;


    /**
     * This method is a class level method and it is used to load typeOfCheese List.
     */
    private void loadCheese(){
        typeOfCheese.add("american");
        typeOfCheese.add("provolone");
        typeOfCheese.add("chedder");
        typeOfCheese.add("swiss");
        typeOfCheese.add("paneer");
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

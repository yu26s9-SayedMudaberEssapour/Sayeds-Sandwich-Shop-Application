package com.pluralsight;

import java.util.List;

public class Ingredients {


    //these are premiums
    private List<String> typeOfMeat;
    private List<String> typeOfCheese;

    //these are regular
    private List<String> typeOfSouse;
    private List<String> otherToppings;


    private void loadMeat(){
        typeOfMeat.add("steam");
        typeOfMeat.add("ham");
        typeOfMeat.add("salami");
        typeOfMeat.add("roast beef");
        typeOfMeat.add("chicken");
        typeOfMeat.add("bacon");
    }

    private void loadCheese(){
        typeOfCheese.add("american");
        typeOfCheese.add("provolone");
        typeOfCheese.add("chedder");
        typeOfCheese.add("swiss");
        typeOfCheese.add("paneer");
    }

    private void loadSause(){
        typeOfSouse.add("mayo");
        typeOfSouse.add("mustard");
        typeOfSouse.add("ketchup");
        typeOfSouse.add("ranch");
        typeOfSouse.add("thousand island");
        typeOfSouse.add("vinaigrette");
    }

    private void loadOtherToppings(){
        otherToppings.add("au jus");
    }

    public float PriceForExtraMeat(int size){

        float finalPrice = 0;
        switch (size){
            case 4:
                finalPrice += 0.50;
                break;
            case 8:
                finalPrice += 1;
                break;
            case 12:
                finalPrice += 1.5;
                break;
            default:
                break;
        }
        return finalPrice;
    }


    public float PriceForExtraCheese(int size){

        float finalPrice = 0;
        switch (size){
            case 4:
                finalPrice += 0.30;
                break;
            case 8:
                finalPrice += 0.60;
                break;
            case 12:
                finalPrice += .90;
                break;
            default:
                break;
        }
        return finalPrice;
    }

}

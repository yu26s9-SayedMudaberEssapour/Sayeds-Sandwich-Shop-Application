package com.pluralsight.ItemsInTheShop;


import com.pluralsight.ingredients.Cheese;
import com.pluralsight.ingredients.Meat;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sandwich {
    private String sandwichSize; //ask the user for 4" 8" 12"
    private String typeOfBread;
    private double price;
    private ArrayList<String> meat; //figure our how to do meat type later
    private ArrayList<String> cheese;


    //There are 4 types of bread

    protected boolean shouldToast; //yes= True, no=false

    public ArrayList<String> getMeat() {
        return this.meat;
    }

    public ArrayList<String> getCheese() {
        return this.cheese;
    }

    public Sandwich(String sandwichSize, String typeOfBread, boolean shouldToast, ArrayList<Sauses> souse, ArrayList<String> meat, ArrayList<String> cheese, ArrayList<RegularToppings> additionalTopping){
        this.sandwichSize = sandwichSize;
        this.typeOfBread = typeOfBread;
        this.shouldToast = shouldToast;
        this.meat = meat;
        this.cheese = cheese;
        //make it type meat
        //make it type cheese

    }

    public String getSandwichSize() {
        return sandwichSize;
    }

    //there should be two kinds of pricing one should be with meal and one without.
    //let figure out how to just do it without the meal
    public double getPrice(){

        double priceSize = 0;
        double priceMeat = 0;
        double priceCheese = 0;

        String sizeOfBread = getSandwichSize();

        switch (sizeOfBread){
            case "Small":
                priceSize += 5.50;
                break;
            case "Medium":
                priceSize += 7.00;
                break;
            case "Large":
                priceSize += 8.50;
                break;
            default:
                break;
        }

        priceMeat += priceOfMeat();
        priceCheese += priceOfCheese();

        return priceSize + priceMeat + priceCheese;



    }

    public double priceOfMeat(){

        double total = 0;

        if(getMeat().size() > 1){
            for(int i = 1; i < getMeat().size(); i++){
                switch (getSandwichSize()){
                    case "Small":
                        total += .50;
                        break;
                    case "Medium":
                        total += 1.00;
                        break;
                    case "Large":
                        total += 1.50;
                        break;
                    default:
                        break;
                }
            }
        }

        switch (getSandwichSize()){
            case "Small":
                total += 1.00;
                break;
            case "Medium":
                total += 2.00;
                break;
            case "Large":
                total += 3.00;
                break;
            default:
                break;
        }
        return total;

    }


    public double priceOfCheese(){

        double total = 0;

        if(getCheese().size() > 1){
            for(int i = 1; i < getCheese().size(); i++){
                switch (getSandwichSize()){
                    case "Small":
                        total += .30;
                        break;
                    case "Medium":
                        total += .60;
                        break;
                    case "Large":
                        total += .90;
                        break;
                    default:
                        break;
                }
            }
        }

        switch (getSandwichSize()){
            case "Small":
                total += .75;
                break;
            case "Medium":
                total += 1.50;
                break;
            case "Large":
                total += 2.25;
                break;
            default:
                break;
        }
        return total;

    }

}

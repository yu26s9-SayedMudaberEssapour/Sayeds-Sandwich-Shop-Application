package com.pluralsight.ItemsInTheShop;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sandwich {
    protected int sandwichSize; //ask the user for 4" 8" 12"
    protected String typeOfBread;


    //There are 4 types of bread

    protected boolean shouldToast; //yes= True, no=false




    public Sandwich(int sandwichSize, String typeOfBread, boolean shouldToast){
        this.sandwichSize = sandwichSize;
        this.typeOfBread = typeOfBread;
        this.shouldToast = shouldToast;
    }

    public void additionalTopping(String topping){
        if(topping.equalsIgnoreCase("meat") || topping.equalsIgnoreCase("cheese")){
            System.out.println("call the premium topping method");
        }
    }




}

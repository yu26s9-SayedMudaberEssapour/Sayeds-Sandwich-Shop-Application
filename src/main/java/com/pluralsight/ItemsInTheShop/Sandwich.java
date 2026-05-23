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
    protected int sandwichSize; //ask the user for 4" 8" 12"
    protected String typeOfBread;
    protected double price;
    protected  String meat; //figure our how to do meat type later
    protected String cheese;


    //There are 4 types of bread

    protected boolean shouldToast; //yes= True, no=false


    public Sandwich(int sandwichSize, String typeOfBread, boolean shouldToast, ArrayList<Sauses> souse, String meat, String cheese, ArrayList<RegularToppings> additionalTopping){
        this.sandwichSize = sandwichSize;
        this.typeOfBread = typeOfBread;
        this.shouldToast = shouldToast;
        this.meat = meat;
        this.cheese = cheese;

    }


    }

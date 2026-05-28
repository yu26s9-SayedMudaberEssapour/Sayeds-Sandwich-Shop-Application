package com.pluralsight.model.sandwich;

import com.pluralsight.enums.CheeseTypes;
import com.pluralsight.enums.MeatTypes;
import com.pluralsight.enums.RegularToppingsType;
import com.pluralsight.enums.SauceTypes;

import java.util.ArrayList;

public abstract class Toppings {


    private boolean isPremium;

    private boolean isExtra;


    public boolean isPremium() {
        return isPremium;
    }

    public boolean isExtra() {

        return isExtra;
    }


    public String description(){
        return "";
    }


    public double getPrice(){
        return 0;
    }



}

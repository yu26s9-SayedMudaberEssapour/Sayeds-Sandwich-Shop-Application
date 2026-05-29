package com.pluralsight.model.sandwich;

import com.pluralsight.enums.BreadType;

public class Bread {

    /**
     * field for type of bread
     */
    BreadType breadType;

    /**
     * Constructor for the type of bread
     * @param breadType
     */
    public Bread(BreadType breadType){
        this.breadType = breadType;
    }
}

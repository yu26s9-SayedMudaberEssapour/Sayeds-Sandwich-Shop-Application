package com.pluralsight.model.sandwich;

import com.pluralsight.enums.RegularToppingsType;

public class RegularTopping extends Toppings{
    /**
     * field for regular topping
     */
    private RegularToppingsType regularTopping;


    /**
     *
     * @return the getter
     */
    public RegularToppingsType getRegularTopping() {
        return regularTopping;
    }

    /**
     *  constructor
     * @param regularTopping
     */
    public RegularTopping(RegularToppingsType regularTopping)
    {
        this.regularTopping = regularTopping;

    }

    /**
     * to String for this class
     * @return
     */
    @Override
    public String toString() {
        return
                 "" + regularTopping;
    }
}

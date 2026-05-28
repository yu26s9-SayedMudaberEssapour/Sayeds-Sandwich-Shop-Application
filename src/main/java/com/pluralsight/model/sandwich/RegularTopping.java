package com.pluralsight.model.sandwich;

import com.pluralsight.enums.RegularToppingsType;

public class RegularTopping extends Toppings{
    private RegularToppingsType regularTopping;


    public RegularToppingsType getRegularTopping() {
        return regularTopping;
    }

    public RegularTopping(RegularToppingsType regularTopping)
    {
        this.regularTopping = regularTopping;

    }

    @Override
    public String toString() {
        return
                 "" + regularTopping;
    }
}

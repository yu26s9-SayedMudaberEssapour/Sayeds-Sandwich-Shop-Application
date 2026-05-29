package com.pluralsight.model.sandwich;

public abstract class PremiumTopping extends Toppings{


    /**
     *
     * @return the price
     */
    public abstract double getPrice();

    /**
     *
     * @return price for extra of meat or cheese
     */
    public abstract double getPriceForExtra();
}

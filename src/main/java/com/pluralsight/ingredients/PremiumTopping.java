package com.pluralsight.ingredients;

public interface PremiumTopping <T>{


    public double getPriceForRegular(int size);

    public float getPriceForExtra(int size);

    public T getType(T type);



}

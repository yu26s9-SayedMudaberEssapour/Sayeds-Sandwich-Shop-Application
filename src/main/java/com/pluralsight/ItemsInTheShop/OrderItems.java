package com.pluralsight.ItemsInTheShop;

import java.util.HashMap;

public abstract class OrderItems {
    public static HashMap<OrderItems, String> currentOrder = new HashMap<>();
    public static double totalPrice;


    @Override
    public String toString() {
        return "OrderItems{}";
    }
}

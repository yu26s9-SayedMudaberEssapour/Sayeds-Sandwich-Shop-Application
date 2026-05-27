package com.pluralsight.ItemsInTheShop;

import java.util.HashMap;

public abstract class OrderItem {
    public static HashMap<OrderItem, String> currentOrder = new HashMap<>();
    public static double totalPrice;


    @Override
    public String toString() {
        return "OrderItems{}";
    }
}

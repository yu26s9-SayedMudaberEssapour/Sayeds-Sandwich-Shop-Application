package com.pluralsight.ItemsInTheShop;

import java.util.List;

public abstract class Order {
    protected List<OrderItem> orderItem;



    public abstract double getPrice();
}

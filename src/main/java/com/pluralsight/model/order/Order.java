package com.pluralsight.model.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's order containing multiple items.
 */
public class Order {

    private static List<OrderItem> items = new ArrayList<>();

    /**
     * Adds an item to the global order list.
     * @param item the order item to add
     */
    public void addItem(OrderItem item) {
        items.add(item);
    }

    /**
     * Gets the list of all items currently in the order.
     * @return a list of order items
     */
    public static List<OrderItem> getItems() {
        return items;
    }

    /**
     * Calculates the cumulative total price of all items in the order.
     * @return the total price of the order as a double
     */
    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getPrice();
        }

        return total;
    }
}
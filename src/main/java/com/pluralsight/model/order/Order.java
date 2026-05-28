package com.pluralsight.model.order;


import java.util.ArrayList;
import java.util.List;

public class Order {

    private static List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public static List<OrderItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public String receipt() {
        StringBuilder sb = new StringBuilder();

        sb.append("===== ORDER RECEIPT =====\n");

        for (OrderItem item : items) {
            sb.append(item.getDescription())
                    .append(" - $")
                    .append(String.format("%.2f", item.getPrice()))
                    .append("\n");
        }

        sb.append("------------------------\n");
        sb.append("TOTAL: $")
                .append(String.format("%.2f", calculateTotal()));

        return sb.toString();
    }
}

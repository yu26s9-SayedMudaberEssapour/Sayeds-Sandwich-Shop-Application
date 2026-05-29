package com.pluralsight.model.order;

public interface OrderItem{

    /**
     *
     * @return the price
     */
    public double getPrice();

    /**
     *
     * @return this will return the description so that you can print to the user
     */
    public String getDescription();

    /**
     *
     * @return Description for the Receipt
     */
    public String forReceipt();


}

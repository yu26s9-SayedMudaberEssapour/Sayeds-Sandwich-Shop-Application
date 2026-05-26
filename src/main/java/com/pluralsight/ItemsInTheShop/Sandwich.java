package com.pluralsight.ItemsInTheShop;

import com.pluralsight.ingredients.Cheeses;
import com.pluralsight.ingredients.Meats;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;

import java.util.ArrayList;

public class Sandwich extends OrderItems {

    private String sandwichSize; // ask the user for 4" 8" 12"
    private String typeOfBread;
    private double price;

    private ArrayList<Meats> meat;
    private ArrayList<Cheeses> cheese;
    private ArrayList<Sauses> sauses;
    private ArrayList<RegularToppings> toppings;

    protected String shouldToast; // yes = true, no = false

    // Constructor
    public Sandwich(
            String sandwichSize,
            String typeOfBread,
            ArrayList<Meats> meat,
            ArrayList<Cheeses> cheese,
            ArrayList<RegularToppings> toppings,
            ArrayList<Sauses> sauses,
            String shouldToast
    ) {
        this.sandwichSize = sandwichSize;
        this.typeOfBread = typeOfBread;
        this.meat = meat;
        this.cheese = cheese;
        this.toppings = toppings;
        this.sauses = sauses;
        this.shouldToast = shouldToast;
    }

    // Getters
    public String getSandwichSize() {
        return sandwichSize;
    }

    public String getTypeOfBread() {
        return typeOfBread;
    }

    public String isShouldToast() {
        return shouldToast;
    }

    public ArrayList<Meats> getMeat() {
        return this.meat;
    }

    public ArrayList<Cheeses> getCheese() {
        return this.cheese;
    }

    public ArrayList<Sauses> getSauses() {
        return sauses;
    }

    public ArrayList<RegularToppings> getToppings() {
        return toppings;
    }

    // Pricing
    public double getPrice() {

        double priceSize = 0;
        double priceMeat = 0;
        double priceCheese = 0;

        String sizeOfBread = getSandwichSize();

        switch (sizeOfBread) {
            case "Small":
                priceSize += 5.50;
                break;
            case "Medium":
                priceSize += 7.00;
                break;
            case "Large":
                priceSize += 8.50;
                break;
            default:
                break;
        }

        priceMeat += priceOfMeat();
        priceCheese += priceOfCheese();

        return priceSize + priceMeat + priceCheese;
    }

    public double priceOfMeat() {

        double total = 0;

        if (getMeat().size() > 1) {
            for (int i = 1; i < getMeat().size(); i++) {
                switch (getSandwichSize()) {
                    case "Small":
                        total += 0.50;
                        break;
                    case "Medium":
                        total += 1.00;
                        break;
                    case "Large":
                        total += 1.50;
                        break;
                    default:
                        break;
                }
            }
        }

        switch (getSandwichSize()) {
            case "Small":
                total += 1.00;
                break;
            case "Medium":
                total += 2.00;
                break;
            case "Large":
                total += 3.00;
                break;
            default:
                break;
        }

        return total;
    }

    public double priceOfCheese() {

        double total = 0;

        if (getCheese().size() > 1) {
            for (int i = 1; i < getCheese().size(); i++) {
                switch (getSandwichSize()) {
                    case "Small":
                        total += 0.30;
                        break;
                    case "Medium":
                        total += 0.60;
                        break;
                    case "Large":
                        total += 0.90;
                        break;
                    default:
                        break;
                }
            }
        }

        switch (getSandwichSize()) {
            case "Small":
                total += 0.75;
                break;
            case "Medium":
                total += 1.50;
                break;
            case "Large":
                total += 2.25;
                break;
            default:
                break;
        }

        return total;
    }

    @Override
    public String toString() {
        return """
        ===== SANDWICH =====
        Size: %s
        Bread: %s
        Toasted: %s
        Meat: %s
        Cheese: %s
        Sauces: %s
        Toppings: %s
        Price: $%.2f
        """.formatted(
                sandwichSize,
                typeOfBread,
                shouldToast,
                meat,
                cheese,
                sauses,
                toppings,
                getPrice()
        );
    }
}
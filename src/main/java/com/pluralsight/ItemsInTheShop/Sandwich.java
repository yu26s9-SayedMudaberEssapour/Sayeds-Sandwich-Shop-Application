package com.pluralsight.ItemsInTheShop;

import com.pluralsight.ingredients.ListOfCheeses;
import com.pluralsight.ingredients.ListOfMeats;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;

import java.util.ArrayList;

public class Sandwich extends OrderItems {

    private String sandwichSize; // ask the user for 4" 8" 12"
    private String typeOfBread;
    private double price;

    private ArrayList<ListOfMeats> meat;
    private ArrayList<ListOfCheeses> cheese;
    private ArrayList<Sauses> sauses;
    private ArrayList<RegularToppings> toppings;

    protected String shouldToast; // yes = true, no = false


    private double priceOfRegularMeat;
    private double priceOfExtraMeat;

    private double priceOfRegularCheese;
    private double priceOfExtraCheese;


    // Constructor
    public Sandwich(
            String sandwichSize,
            String typeOfBread,
            ArrayList<ListOfMeats> meat,
            ArrayList<ListOfCheeses> cheese,
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

    public ArrayList<ListOfMeats> getMeat() {
        return this.meat;
    }

    public ArrayList<ListOfCheeses> getCheese() {
        return this.cheese;
    }

    public ArrayList<Sauses> getSauses() {
        return sauses;
    }

    public ArrayList<RegularToppings> getToppings() {
        return toppings;
    }

    public double getPriceOfExtraCheese() {
        return priceOfExtraCheese;
    }

    public double getPriceOfRegularCheese() {
        return priceOfRegularCheese;
    }

    public double getPriceOfExtraMeat() {
        return priceOfExtraMeat;
    }

    public double getPriceOfRegularMeat() {
        return priceOfRegularMeat;
    }



    // Pricing
    public double getWholeSandwichPrice() {

        return priceOfSize() + priceOfMeat() + priceOfCheese();
    }

    public double priceOfMeat() {

//        double total = 0;
        priceOfRegularMeat = 0;
        priceOfExtraMeat = 0;

        if (getMeat().size() > 1) {
            for (int i = 1; i < getMeat().size(); i++) {
                switch (getSandwichSize()) {
                    case "Small":
//                        total += 0.50;
                        priceOfExtraMeat += 0.50;
                        break;
                    case "Medium":
//                        total += 1.00;
                        priceOfExtraMeat += 1.00;
                        break;
                    case "Large":
//                        total += 1.50;
                        priceOfExtraMeat += 1.50;
                        break;
                    default:
                        break;
                }
            }
        }

        switch (getSandwichSize()) {
            case "Small":
//                total += 1.00;
                priceOfRegularMeat += 1.00;
                break;
            case "Medium":
//                total += 2.00;
                priceOfRegularMeat += 2.00;
                break;
            case "Large":
//                total += 3.00;
                priceOfRegularMeat += 3.00;
                break;
            default:
                break;
        }

        return priceOfRegularMeat + priceOfExtraMeat;
    }

    public double priceOfCheese() {

//        double total = 0;

        priceOfRegularCheese = 0;
        priceOfExtraCheese = 0;

        if (getCheese().size() > 1) {
            for (int i = 1; i < getCheese().size(); i++) {
                switch (getSandwichSize()) {
                    case "Small":
                        //total += 0.30;
                        priceOfExtraCheese += 0.30;
                        break;
                    case "Medium":
                        //total += 0.60;
                        priceOfExtraCheese += 0.60;
                        break;
                    case "Large":
                        //total += 0.90;
                        priceOfExtraCheese += 0.90;
                        break;
                    default:
                        break;
                }
            }
        }

        switch (getSandwichSize()) {
            case "Small":
                //total += 0.75;
                priceOfRegularCheese += 0.75;
                break;
            case "Medium":
                //total += 1.50;
                priceOfRegularCheese += 1.50;
                break;
            case "Large":
                //total += 2.25;
                priceOfRegularCheese += 2.25;
                break;
            default:
                break;
        }

        return priceOfRegularCheese + priceOfExtraCheese;
    }

    public double priceOfSize(){
        String sizeOfBread = getSandwichSize();
        double priceSize = 0;
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
        return priceSize;
    }


    //check this method
    private String line(String label, String value, double price) {
        return String.format("   %-12s %-30s $%.2f", label, value, price);
    }




    @Override
    public String toString() {
        return """
                                                                ╔══════════════════════════════════════════════════════╗
                                                                ║                 🥪 SANDWICH DETAILS                  ║
                                                                ╚══════════════════════════════════════════════════════╝

                                                                """
                                                                + line("📏 Size:", String.valueOf(sandwichSize), priceOfSize()) + "\n"
                                                                + line("🍞 Bread:", String.valueOf(typeOfBread), 0) + "\n"
                                                                + line("🔥 Toasted:", String.valueOf(shouldToast), 0) + "\n"
                                                                + line("🥩 Meat:", String.valueOf(meat), priceOfMeat()) + "\n"
                                                                + line("🧀 Cheese:", String.valueOf(cheese), priceOfCheese()) + "\n"
                                                                + line("🥫 Sauces:", String.valueOf(sauses), 0) + "\n"
                                                                + line("🥬 Toppings:", String.valueOf(toppings), 0) + "\n\n"
                                                                + String.format("   💲 %-42s $%.2f", "TOTAL:", getWholeSandwichPrice()) + "\n"
                                                                + """
                                                                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
        """;
    }
}
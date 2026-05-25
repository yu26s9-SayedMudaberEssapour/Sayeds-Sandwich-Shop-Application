package com.pluralsight;

import com.pluralsight.ItemsInTheShop.Sandwich;
import com.pluralsight.Screens.AddSandwichScreen;
import com.pluralsight.Screens.HomeScreen;
import com.pluralsight.ingredients.RegularToppings;
import com.pluralsight.ingredients.Sauses;
import com.pluralsight.ui.Console;

import java.util.ArrayList;

public class UserInterface {
    static void main() {

        HomeScreen hs = new HomeScreen();

        hs.StartOrder();

//        ArrayList<Sauses> sause= new ArrayList<>();
//        sause.add(Sauses.Vinaigrette);
//
//        ArrayList<String> meat = new ArrayList<>();
//        meat.add("Bacon");
//        meat.add("Chicken");
//        meat.add("ham");
//        meat.add("salami");
//
//        ArrayList<String> cheese = new ArrayList<>();
//        cheese.add("American");
//        cheese.add("Provolone");
//        cheese.add("Cheddar");
//
//        ArrayList<RegularToppings> rt= new ArrayList<>();
//        rt.add(RegularToppings.Lettuce);
//        rt.add(RegularToppings.Mushrooms);
//
//        Sandwich s = new Sandwich("Small", "Wheat", true, sause, meat, cheese, rt);
//
//        ;
//        System.out.println(s.getPrice());








}}
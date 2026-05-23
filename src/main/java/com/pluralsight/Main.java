package com.pluralsight;

import com.pluralsight.Screens.AddSandwichScreen;
import com.pluralsight.Screens.HomeScreen;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        HomeScreen hs = new HomeScreen();

        AddSandwichScreen as = new AddSandwichScreen();

        hs.StartOrder();


}}
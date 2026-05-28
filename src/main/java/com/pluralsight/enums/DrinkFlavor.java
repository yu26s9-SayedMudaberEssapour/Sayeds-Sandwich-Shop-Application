package com.pluralsight.enums;

public enum DrinkFlavor {

    COCA_COLA("Coca-Cola"),
    SPRITE("Sprite"),
    DR_PEPPER("Dr Pepper"),
    FANTA_ORANGE("Fanta Orange"),
    ROOT_BEER("Root Beer"),
    LEMONADE("Lemonade"),
    SWEET_TEA("Sweet Tea"),
    UNSWEET_TEA("Unsweet Tea"),
    MOUNTAIN_DEW("Mountain Dew"),
    PEPSI("Pepsi"),
    CHERRY_COKE("Cherry Coke"),
    FRUIT_PUNCH("Fruit Punch");

    private final String displayName;

    DrinkFlavor(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

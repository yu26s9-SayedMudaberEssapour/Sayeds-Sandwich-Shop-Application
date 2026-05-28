package com.pluralsight.enums;

public enum SandwichSize {
    Small(1.00, 0.5),
    Medium(2.00, 1.00),
    Large(3.00, 1.50);

    private final double baseMeatPrice;
    private final double extraMeatPrice;

    SandwichSize(double baseMeatPrice, double extraMeatPrice) {
        this.baseMeatPrice = baseMeatPrice;
        this.extraMeatPrice = extraMeatPrice;
    }

    public double getBaseMeatPrice() {
        return baseMeatPrice;
    }

    public double getExtraMeatPrice() {
        return extraMeatPrice;
    }
}

;




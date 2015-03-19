package com.twu.refactor;

/**
 * Created by kaustavc on 3/17/2015.
 */
public enum MoviePricingCategory {
    CHILDRENS(1.5, 1.5, 3),
    REGULAR(2, 1.5, 2),
    NEW_RELEASE(0, 3, 0);

    private double upfrontCost;
    private double perDayCost;
    private int upfrontValidity;

    MoviePricingCategory(double upfrontCost, double perDayCost, int upfrontValidity) {

        this.upfrontCost = upfrontCost;
        this.perDayCost = perDayCost;
        this.upfrontValidity = upfrontValidity;
    };

    public double getCostFor(int numberOfDays) {
        double rentalAmount = upfrontCost;

        if (numberOfDays > upfrontValidity) {
            rentalAmount += (numberOfDays - upfrontValidity) * perDayCost;
        }

        return rentalAmount;
    }
}

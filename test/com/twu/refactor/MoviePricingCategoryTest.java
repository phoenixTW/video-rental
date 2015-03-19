package com.twu.refactor;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MoviePricingCategoryTest extends TestCase {
    public void testPricingCatagoryGivesCorrectCostForNumberOfDays() {
        double actualCost = MoviePricingCategory.CHILDRENS.getCostFor(4);
        double regular = MoviePricingCategory.REGULAR.getCostFor(4);
        double newRelease = MoviePricingCategory.NEW_RELEASE.getCostFor(2);
        assertEquals(3, actualCost, 0.0);
        assertEquals(5, regular, 0.0);
        assertEquals(6, newRelease, 0.0);
    }

    public void testKidsCategoryGivesCorrectCostForLessThan3days() {
        double actualCostFor1Day = MoviePricingCategory.CHILDRENS.getCostFor(1);
        double actualCostFor2Day = MoviePricingCategory.CHILDRENS.getCostFor(2);
        assertEquals(1.5, actualCostFor1Day);
        assertEquals(1.5, actualCostFor2Day);
    }

    public void testRegularCategoryGivesCorrectCostForLessThan2days() {
        double actualCostFor1Day = MoviePricingCategory.CHILDRENS.getCostFor(1);
        assertEquals(1.5, actualCostFor1Day);
    }
}
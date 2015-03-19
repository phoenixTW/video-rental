package com.twu.refactor;

import java.util.List;

/**
 * Created by kaustavc on 3/19/2015.
 * Billable interface for biling to the customer
 */
public interface Billable {
    String getName();

    int getTotalFrequentRentalPoint();

    double totalAmount();

    List<Rental> getRentalList();
}

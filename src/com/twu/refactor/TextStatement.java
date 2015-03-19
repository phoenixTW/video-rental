package com.twu.refactor;

/**
 * Created by kaustavc on 3/19/2015.
 * Text Statement generator for a customer's billing
 */
public class TextStatement {

    private static String getHeader(Billable billable) {

        return "Rental Record for " + billable.getName() + "\n";
    }

    private static String getFooterLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    public static String statement(Customer customer) {
        double totalAmount;
        int frequentRenterPoints;
        String result = getHeader(customer);

        frequentRenterPoints = customer.getTotalFrequentRentalPoint();

        for (Rental rental : customer.rentalList) {
            result += customer.getRentalSubtotal(rental);
        }

        totalAmount = customer.totalAmount();

        result += getFooterLines(totalAmount, frequentRenterPoints);
        return result;
    }
}

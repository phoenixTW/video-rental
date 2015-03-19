package com.twu.refactor;

/**
 * Created by kaustavc on 3/19/2015.
 */
public class HTMLStatement {
    public static String getHTML(Customer customer) {
        double totalAmount = 0.0;
        int frequentRenterPoints = 0;
        String HTML = getHeader(customer);
        String body = "";

        for (Rental rental : customer.rentalList) {
            double rentalAmount = rental.getAmountRental();

            frequentRenterPoints += rental.getFrequentPoints();

            body = eachRentalDetail(body, rental, rentalAmount);

            totalAmount += rentalAmount;
        }

        body = getParagraph(body) + getFooter(totalAmount, frequentRenterPoints);

        return HTML + body;
    }

    private static String getFooter(double totalAmount, int frequentRenterPoints) {
        String body = getParagraph("You owe <EM>" + totalAmount + "</EM>");
        body += getFrequentPointStatement(frequentRenterPoints);
        return body;
    }

    private static String getFrequentPointStatement(int frequentRenterPoints) {
        String body = "On this rental you earned <EM>" +
                frequentRenterPoints + "</EM> frequent renter points";

        return getParagraph(body);
    }

    private static String getParagraph(String body) {
        return "<P>" + body + "</P>";
    }

    private static String getHeader(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1>";
    }

    private static String eachRentalDetail(String body, Rental rental, double rentalAmount) {
        body += rental.getMovie().getTitle() + ": "
                + String.valueOf(rentalAmount) + "<BR>";
        return body;
    }
}

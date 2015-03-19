package com.twu.refactor;

/**
 * Created by kaustavc on 3/19/2015
 * Generating HTML Statement.
 */
public class HTMLStatement {
    public static String getHTML(Customer customer) {
        int frequentRenterPoints = customer.getTotalFrequentRentalPoint();
        String body = "";

        for (Rental rental : customer.rentalList)
            body += rental.eachRentalDetail() + "<BR>";

        double totalAmount = customer.totalAmount();

        body = getParagraph(body) + getFooter(totalAmount, frequentRenterPoints);

        return getHeader(customer) + body;
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
}

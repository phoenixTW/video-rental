package com.twu.refactor;

/**
 * Created by kaustavc on 3/19/2015
 * Generating HTML Statement.
 */

public class HTMLStatement {

    public static String getHTML(Customer customer) {
        int frequentRenterPoints = customer.getTotalFrequentRentalPoint();
        double totalAmount = customer.totalAmount();

        String body = getParagraph(getHTMLBody(customer)) + getFooter(totalAmount, frequentRenterPoints);

        return getHeader(customer) + body;
    }

    private static String getHTMLBody(Customer customer) {
        String body = "";

        for (Rental rental : customer.rentalList)
            body += rental.eachRentalDetail() + HTMLTags.BREAK;

        return body;
    }

    private static String getFooter(double totalAmount, int frequentRenterPoints) {
        String body = getParagraph("You owe " + HTMLTags.EMOpening + totalAmount + HTMLTags.EMClosing);
        body += getFrequentPointStatement(frequentRenterPoints);
        return body;
    }

    private static String getFrequentPointStatement(int frequentRenterPoints) {
        String body = "On this rental you earned " + HTMLTags.EMOpening +
                frequentRenterPoints + HTMLTags.EMClosing + " frequent renter points";

        return getParagraph(body);
    }

    private static String getParagraph(String body) {
        return HTMLTags.PARAGRAPHOpening + body + HTMLTags.PARAGRAPHClosing;
    }

    private static String getHeader(Customer customer) {
        return HTMLTags.HEADINGOpen + "Rentals for " +
                HTMLTags.EMOpening + customer.getName() + HTMLTags.EMClosing
                + HTMLTags.HEADINGClose;
    }
}

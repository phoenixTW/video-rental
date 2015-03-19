package com.twu.refactor;

/**
 * Created by kaustavc on 3/19/2015
 * Generating HTML Statement.
 */

public class HTMLStatement {
    private static final String BREAK = "<BR>";
    private static final String EMOpening = "<EM>";
    private static final String EMClosing = "</EM>";
    private static final String PARAGRAPHOpening = "<P>";
    private static final String PARAGRAPHClosing = "</P>";
    private static final String HEADINGOpen = "<H1>";
    private static final String HEADINGClose = "</H1>";

    public static String getHTML(Customer customer) {
        int frequentRenterPoints = customer.getTotalFrequentRentalPoint();
        double totalAmount = customer.totalAmount();

        String body = getParagraph(getHTMLBody(customer)) + getFooter(totalAmount, frequentRenterPoints);

        return getHeader(customer) + body;
    }

    private static String getHTMLBody(Customer customer) {
        String body = "";

        for (Rental rental : customer.rentalList)
            body += rental.eachRentalDetail() + BREAK;

        return body;
    }

    private static String getFooter(double totalAmount, int frequentRenterPoints) {
        String body = getParagraph("You owe " + EMOpening + totalAmount + EMClosing);
        body += getFrequentPointStatement(frequentRenterPoints);
        return body;
    }

    private static String getFrequentPointStatement(int frequentRenterPoints) {
        String body = "On this rental you earned " + EMOpening +
                frequentRenterPoints + EMClosing + " frequent renter points";

        return getParagraph(body);
    }

    private static String getParagraph(String body) {
        return PARAGRAPHOpening + body + PARAGRAPHClosing;
    }

    private static String getHeader(Customer customer) {
        return HEADINGOpen + "Rentals for " +
                EMOpening + customer.getName() + EMClosing + HEADINGClose;
    }
}

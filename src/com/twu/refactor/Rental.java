package com.twu.refactor;

public class Rental {
    private static final int ONE_DAY = 1;
    private static final int TWO_DAY = 2;
    private static final int THREE_DAY = 3;

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {

        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmountFor() {
        return movie.getCostForMovie((daysRented));
    }

    private double calculateCost(double rentalAmount) {

        return rentalAmount;
    }

    public int getFrequentPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;

        if (movie.isNewRelease() && daysRented > ONE_DAY)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }

    public double getAmountRental() {
        return movie.getCostForMovie(daysRented);
    }
}
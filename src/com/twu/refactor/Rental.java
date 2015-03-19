package com.twu.refactor;

public class Rental {
    private static final int ONE_DAY = 1;

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmountFor() {
        return movie.getCostForMovie((daysRented));
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

    public String eachRentalDetail() {
        return movie.getTitle() + ": "
                + String.valueOf(getAmountRental());
    }
}
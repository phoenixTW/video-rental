package com.twu.refactor;

public class Movie {

    private String title;
	private MoviePricingCategory priceCode;


	public Movie(String title, MoviePricingCategory priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public MoviePricingCategory getPriceCode() {
		return priceCode;
	}

//	public void setPriceCode(int arg) {
//    	priceCode = arg;
//	}

	public String getTitle () {
		return title;
	}

    public boolean isNewRelease() {
        return priceCode == MoviePricingCategory.NEW_RELEASE;
    }

    public double getCostForMovie(int daysRented) {
        return priceCode.getCostFor(daysRented);
    }
}


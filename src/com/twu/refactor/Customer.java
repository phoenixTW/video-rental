package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Billable {

    private String name;
	public List<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

    public int getTotalFrequentRentalPoint() {
        int frequentRentarPoint = 0;

        for (Rental rental : rentalList) {
            frequentRentarPoint += rental.getFrequentPoints();
        }

        return  frequentRentarPoint;
    }

    public double totalAmount() {
        double totalAmount = 0.0;
        for (Rental rental : rentalList) {
            totalAmount += rental.getAmountFor();
        }
        return totalAmount;
    }

    public String getRentalSubtotal(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(rental.getAmountFor()) + "\n";
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }
}

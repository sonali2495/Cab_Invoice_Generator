package com.bridgelabz.cabinvoiceservice;

public enum CabRide {
    NORMAL_RIDES(10.0, 1, 5.0), PREMIUM_RIDES(15.0, 2, 20.0);

    private final double costPreKm;
    private final int costPerMin;
    private final double minFarePerRide;

    CabRide(double costPreKm, int costPerMin, double minFare) {
        this.costPreKm = costPreKm;
        this.costPerMin = costPerMin;
        this.minFarePerRide = minFare;
    }

    public double calcCostOfCabFare(Ride ride) {
        double totalFare = ride.distance * costPreKm + ride.time * costPerMin;
        return Math.max(totalFare, minFarePerRide);
    }
}

package com.bridgelabz.cabinvoiceservice;

/**
 * Purpose : To generate multiple rides
 */
public class Ride {
    public final int time;
    public final double distance;
    public CabRide cabRide;

    public Ride(CabRide cabRide, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }
}

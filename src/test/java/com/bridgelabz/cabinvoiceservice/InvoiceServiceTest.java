package com.bridgelabz.cabinvoiceservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;
    Ride[] rides = null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository = null;

    @BeforeEach
    void setUp() throws Exception{
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL_RIDES, 2.0, 5),
                new Ride(CabRide.PREMIUM_RIDES, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        assertEquals(summary, expectedInvoiceSummary);
        String userId = "abc101";
        invoiceService.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary("abc101");
        assertEquals(invoiceSummary, expectedInvoiceSummary);
    }




}

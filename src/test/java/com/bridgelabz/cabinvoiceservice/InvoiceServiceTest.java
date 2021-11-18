package com.bridgelabz.cabinvoiceservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double fare = invoiceService.calculateFare(RideCategories.NORMAL_RIDES, 2.0, 5);
        assertEquals(25.0, fare);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double fare = invoiceService.calculateFare(RideCategories.NORMAL_RIDES, 0.1, 1);
        assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)
        };
        double fare = invoiceService.calculateFare(RideCategories.NORMAL_RIDES, rides);
        assertEquals(30, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateFareSummary(RideCategories.NORMAL_RIDES, rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides("abc101", rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(RideCategories.NORMAL_RIDES, "abc101");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenDistanceAndTime_ForPremiumRides_ReturnTotalFare() {
        double fare = invoiceService.calculateFare(RideCategories.PREMIUM_RIDES, 2.0, 5);
        assertEquals(40, fare);
    }

    @Test
    public void givenLessDistanceOrTime_ForPremiumRides_ShouldReturnMinFare() {
        double fare = invoiceService.calculateFare(RideCategories.PREMIUM_RIDES, 0.1, 1);
        assertEquals(20, fare);
    }

    @Test
    public void givenMultipleRides_ForPremiumRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceService.calculateFare(RideCategories.PREMIUM_RIDES, rides);
        assertEquals(60, fare);
    }

    @Test
    public void givenUserIdAndRide_ForPremiumRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides("abc102", rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(RideCategories.PREMIUM_RIDES, "abc102");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}

package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.InvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.Ride;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @BeforeEach
    void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double fare = invoiceGenerator.calculateFare(2.0, 5);
        assertEquals(25.0, fare);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double fare = invoiceGenerator.calculateFare(0.1, 1);
        assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)
                        };
        double fare = invoiceGenerator.calculateFare(rides);
        assertEquals(30, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}

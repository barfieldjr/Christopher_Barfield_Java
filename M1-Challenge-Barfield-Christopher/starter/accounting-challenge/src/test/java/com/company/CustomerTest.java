package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testGetBalance() {
        Customer customer = new Customer();
        AccountRecord charge1 = new AccountRecord(10, "01/01/2021");
        AccountRecord charge2 = new AccountRecord(20, "01/02/2021");
        AccountRecord charge3 = new AccountRecord(30, "01/03/2021");
        customer.addCharge(charge1);
        customer.addCharge(charge2);
        customer.addCharge(charge3);
        assertEquals(60, customer.getBalance());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Smith");
        AccountRecord charge = new AccountRecord(50, "01/01/2021");
        customer.addCharge(charge);
        assertEquals("ID: 1, Name: John Smith, Balance: 50", customer.toString());
    }

}

package com.company;

import java.util.ArrayList;
import java.util.List;

// Update the getBalance() method in the Customer class to sum all charges.
// Update the toString() method in the Customer class to print the customer ID, customer name, and customer balance.

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int totalBalance = 0;
        for (AccountRecord charge : charges) {
            totalBalance += charge.getCharge();
        }
        return totalBalance;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }
    public List<AccountRecord> getCharges() {
        return charges;
    }
    public void setCharges(List<AccountRecord> charges) {
        this.charges = charges;
    }

    public void addCharge(AccountRecord charge) {
        List<AccountRecord> updatedCharges = this.charges;
        updatedCharges.add(charge);
        this.charges = updatedCharges;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Balance: " + getBalance();
    }

}

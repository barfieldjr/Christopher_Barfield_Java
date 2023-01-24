package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Update the main() method in the Main class.
// Iterate through a List<String[]> that contains multiple records for each Customer, converting it into List<Customer> where there is only one copy of each customer (Integer.parseInt() converts a String to an integer).
public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int balance = Integer.parseInt(data[2]);
            String date = data[3];

            boolean customerExist = false;
            for(Customer c : customers){
                if(c.getId() == id){
                    customerExist = true;
                    AccountRecord newCharge = new AccountRecord(balance, date);
                    c.addCharge(newCharge);
                    break;
                }
            }

            if(!customerExist){
                Customer customer = new Customer();
                customer.setId(id);
                customer.setName(name);
                customer.setBalance(balance);

                AccountRecord initialCharge = new AccountRecord(balance, date);
                customer.addCharge(initialCharge);
                customers.add(customer);
            }
        }

        System.out.println("Positive accounts:");
        for (Customer c : customers) {
            if (c.getBalance() > 0) {
                System.out.println(c);
            }
        }

        System.out.println("Negative accounts:");
        for (Customer c : customers) {
            if (c.getBalance() < 0) {
                System.out.println(c);
            }
        }
    }


}

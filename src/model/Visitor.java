package model;
/*
Project: LBMS
File: Visitor
Author: Group 4
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Visitor implements Person{

    /**
     * First Name of Visitor
     */
    private String firstName;

    /**
     * Last Name of Visitor
     */
    private String lastName;

    /**
     * Address of Visitor
     */
    private String address;

    /**
     * Phone Number of Visitor
     */
    private long phoneNumber;

    /**
     * Unique 10 digit visitor ID
     */
    private String visitorID;

    /**
     *Keeps a list of all transactions (checked out boks) of a user
     */
    private ArrayList<Transaction> transactions;

    /**
     * Moneyed owed from late books
     */
    private int balance;


    public Visitor(String firstName, String lastName, String address, long phoneNumber, String visitorID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.visitorID = visitorID;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Gets firstName
     * @return visitor firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets all Transactions
     * @return visitors transactions
     */
    public ArrayList<Transaction> getTransactions() { return transactions; }

    /**
     * Gets lastName
     * @return visitor lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets address
     * @return visitor Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets phoneNumber
     * @return visitor phoneNumber
     */
    public long getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Gest ID
     * @return visitorID
     */
    public String getID(){
        return visitorID;
    }


    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }


    public void addBalance(int added) {
        this.balance += added;
    }


    public void payBalance(int paid){
        this.balance -= paid;
    }

    public int getBalance(){
        return this.balance;
    }
}




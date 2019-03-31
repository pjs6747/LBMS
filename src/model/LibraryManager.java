package model;

/*
Project: LBMS
File: LibraryManager
Author: Group 4
 */

import java.util.ArrayList;

public class LibraryManager implements Person{

    /**
     * First Name of Manager
     */
    private String firstName;

    /**
     * Last Name of Manager
     */
    private String lastName;

    /**
     * Address of Manager
     */
    private String address;

    /**
     * Phone Number of Manager
     */
    private long phoneNumber;

    /**
     * Unique 10 digit visitor ID
     */
    private String managerID;

    /**
     *Keeps a list of all transactions (checked out boks) of a user
     */
    private ArrayList<Transaction> transactions;

    /**
     * Moneyed owed from late books
     */
    private int balance;


    public LibraryManager(String firstName, String lastName, String address, long phoneNumber, String managerID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.managerID = managerID;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Gets firstName
     * @return manager firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets all Transactions
     * @return manager transactions
     */
    public ArrayList<Transaction> getTransactions() { return transactions; }

    /**
     * Gets lastName
     * @return manager lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets address
     * @return manager Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets phoneNumber
     * @return manager phoneNumber
     */
    public long getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Gest ID
     * @return visitorID
     */
    public String getID(){
        return managerID;
    }


    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
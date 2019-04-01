package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Visitor{

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
  private long visitorID;

  /**
   *Keeps a list of all transactions (checked out books) of a user
   */
  private ArrayList<Transaction> transactions;

  /**
   * Balance a visitor owes
   */
  private int balance;

  /**
   * Username of visitor
   */
  private String userName;

  /**
   * Password for account
   */
  private String password;


  public Visitor(String firstName, String lastName, String address, long phoneNumber, String userName, String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.userName = userName;
    this.password = password;
    this.visitorID = new UniqueIDGenerator().generateID();
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
  public String getVisitorID(){
    return Long.toString(this.visitorID);
  }


  public void addBalance(int amount){
    this.balance += amount;
  }

  public String getPassword(){return this.password;}

  public int getBalance(){return this.balance;}

  public String getID(){return Long.toString(this.visitorID);}

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}

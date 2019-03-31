package model;

import java.util.ArrayList;

public interface Person{

  /**
   * Gets firstName
   * @return visitor firstName
   */
  String getFirstName();


  /**
   * Gets all Transactions
   * @return visitors transactions
   */
  ArrayList<Transaction> getTransactions();


  /**
   * Gets lastName
   * @return visitor lastName
   */
  String getLastName();


  /**
   * Gets address
   * @return visitor Address
   */
  String getAddress();


  /**
   * Gets phoneNumber
   * @return visitor phoneNumber
   */
  long getPhoneNumber();


  /**
   * Gest ID
   * @return visitorID
   */
  String getID();


  /**
   * Override to string method
   * @return the string that corresponds to the object
   */
  String toString();
}

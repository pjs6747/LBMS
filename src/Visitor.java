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


  public Visitor(String firstName, String lastName, String address, long phoneNumber, long visitorID){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.visitorID = visitorID;
  }

  /**
   * Gets firstName
   * @return visitor firstName
   */
  public String getFirstName() {
    return firstName;
  }

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
  public long getVisitorID(){
    return visitorID;
  }


  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}

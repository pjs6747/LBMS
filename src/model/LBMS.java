package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LBMS {

  //Library that holds all the books
  private Library library;

  //Visits after the visitor leaves
  private ArrayList<Visit> oldVisits;

  //All registered visitors
  private ArrayList<Visitor> visitors;

  //Visits when visitor has not left
  private ArrayList<Visit> openVisits;

  //List of all customer transactions
  private ArrayList<Transaction> transactions;

  //Text File containing all book information
  private File bookStoreFile;

  //Original Time of start up
  private Time startTime;

  //Current System time
  private Time currentTime;

  //Unique ID for next new visitor
  private String newUserID;



  public LBMS(){
    library = new Library();
    oldVisits = new ArrayList<>();
    visitors = new ArrayList<>();
    openVisits = new ArrayList<>();
    transactions = new ArrayList<>();
    bookStoreFile = new File("SRC\\Files\\books");
    newUserID = "0000000001";
    this.startTime = new Time();
    this.currentTime = new Time();
    //this.currentTime.run();     //Currently allows nothing else to run
  }


  /**
   * Registers a Visitor to the system
   * @param firstName First Name
   * @param lastName Last Name
   * @param address Address
   * @param phoneNumber Phone Number
   */
  public void registerVisitor(String firstName, String lastName, String address, long phoneNumber){
    Visitor visitor = new Visitor(firstName, lastName, address, phoneNumber, this.newUserID);
    int temp = Integer.parseInt(this.newUserID);
    temp++;
    this.newUserID = String. format("%010d", temp);
    this.visitors.add(visitor);
  }


  /**
   * Starts a visit for a specified id
   * @param ID User ID to start
   */
  public void startVisit(String ID){
    this.openVisits.add(new Visit(findVisitor(ID), currentTime.getDate(),currentTime.getTime()));
  }


  /**
   * Ends a visit for a specified id
   * @param ID User ID to end
   */
  public void endVisit(String ID) {
    for (Visit visit : openVisits) {
      if (visit.getVisitor().getID().equals(ID)) {
        visit.endVisit(currentTime.getTime());
        openVisits.remove(visit);
        oldVisits.add(visit);
        return;
      }
    }
  }


  /**
   * Buys listed books
   * @param ids book isbns to buy
   * @param quantity number of each book to buy
   * @throws FileNotFoundException If the file containing book info
   */
  public void buyBooks(List ids, int quantity) throws FileNotFoundException {
    Scanner sc = new Scanner(bookStoreFile);
    ArrayList<Book> booksToAdd = new ArrayList<>();
    int counter = ids.size();
    while (sc.hasNextLine() && counter > 0) {
      String line = sc.nextLine();
      String[] lineArray = line.split(",");
      if (ids.contains(Long.parseLong(lineArray[0]))){
        long isbn = Long.parseLong(lineArray[0]);
        String title = lineArray[1];
        String author = lineArray[2];
        String publisher = lineArray[3];
        String date = lineArray[4];
        int pageNumber = Integer.parseInt(lineArray[5]);
        Book newBook = new Book(isbn, title, author, publisher, date, pageNumber, quantity);
        booksToAdd.add(newBook);
        counter--;
      }
    }
    library.addBooks(booksToAdd);
  }


  /**
   * Borrows books listed for specified id
   * @param id ID of the visitor borrowing
   * @param books Books to borrow
   */
  public void borrowBook(String id, ArrayList<Long> books){
    Visitor visitor = findVisitor(id);
    Visit visit = findVisit(visitor);
    ArrayList<Book> booksToBorrow = library.borrowBooks(books);
    for (Book bookToBorrow : booksToBorrow){
      if (bookToBorrow.checkBook() && visit != null) {
        Transaction newTrans = new Transaction(bookToBorrow, visit);
        this.transactions.add(newTrans);
      }
    }
  }


  /**
   * Finds books that are checked out
   * @return listed of checked out books
   */
  public ArrayList<Transaction> findBorrowedBooks(){
    ArrayList<Transaction> checkedOut = new ArrayList<>();
    for (Transaction t : transactions){
      if (!t.isReturned()){
        checkedOut.add(t);
      }
    }
    return checkedOut;
  }


  /**
   * Returns specified book for specified user ID
   * @param id user ID that returned
   * @param books list of isbns to return
   */
  public void returnBooks(String id, ArrayList<Long> books){
    ArrayList<Transaction> transactions = findTransactions(id, books);
    for (Transaction t : transactions){
      t.returnBook(this.currentTime);
    }
  }


  /**
   * Changes time by days and hours
   * @param days Days to skip
   * @param hours Hours to skip
   */
  public void changeTime(long days, int  hours){
    this.currentTime.plusDays(days);
    this.currentTime.plusHours(hours);
  }


  /**
   * Pays fine for the visitor ID
   * @param ID Visitor that payed their fine
   * @param amount Amount the visitor payed
   */
  public int payFine(String ID, int amount){
    Visitor visitor = findVisitor(ID);
    if (visitor != null) {
      visitor.payBalance(amount);
      return visitor.getBalance();
    }
    return -1;
  }


  /**
   * Gets the system time
   * @return current time object
   */
  public Time getTime(){
    return this.currentTime;
  }


  /**
   * Gets original start time
   * @return the time of start up
   */
  public Time getStartTime() {
    return startTime;
  }


  /**
   * Finds a visitor object from an ID
   * @param id Visitor ID to search for
   * @return Visitor object with the specified id
   */
  private Visitor findVisitor(String id){
    for (Visitor visitor : visitors){
      if (visitor.getID().equals(id)){
        return visitor;
      }
    }
    return null;
  }


  /**
   * Finds a visit from a visitor
   * @param visitor visitor to search for
   * @return the visit that contains specified visitor
   */
  private Visit findVisit (Visitor visitor){
    for (Visit visit : openVisits){
      if (visit.getVisitor().equals(visitor)){
        return visit;
      }
    }
    return null;
  }


  /**
   * Finds transaction object from userID and list of Books
   * @param id visitor ID to search for
   * @param books isbns to search for
   * @return the transactions that fit the search
   */
  private ArrayList<Transaction> findTransactions(String id, ArrayList<Long> books){
    ArrayList<Transaction> transactions = new ArrayList<>();
    for (Transaction t : this.transactions){
      if (t.getVisitor().getID().equals(id) && books.contains(t.getBook().getIsbn())){
        transactions.add(t);
      }
    }
    return transactions;
  }
}

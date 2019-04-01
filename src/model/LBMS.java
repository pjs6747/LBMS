package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LBMS {

  private static Library library;
  private static ArrayList<Visit> visits;
  private static ArrayList<Visitor> visitors;
  private static ArrayList<Visit> openVisits;
  private static ArrayList<Transaction> transactions;
  private static File bookStoreFile;
  private static Time startTime;
  private static Time currentTime;




  public LBMS() throws FileNotFoundException {
    library = new Library();
    visits = new ArrayList<>();
    visitors = new ArrayList<>();
    openVisits = new ArrayList<>();
    transactions = new ArrayList<>();
    bookStoreFile = new File("src\\Files\\books");
    startTime = new Time();
    currentTime = new Time();
    //this.currentTime.run();
//    populateLibrary(); not needed
  }


  public void registerVisitor(String fn, String ln, String address, long phoneNumber, String userName, String password){
    visitors.add(new Visitor(fn, ln, address, phoneNumber, userName, password));
  }


  public void startVisit(String ID){
    openVisits.add(new Visit(findVisitor(ID), currentTime.getDate(),currentTime.getTime()));
  }

  public void endVisit(String ID) {
    for (Visitor visitor : visitors) {
      if (visitor.getVisitorID() == ID) {
        for (Visit visit : openVisits){
          if (visit.getVisitor().getVisitorID() == ID){
            visit.endVisit(currentTime.getTime());
            openVisits.remove(visit);
            visits.add(visit);
            return;
          }
        }
      }
    }
  }

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

  public void buyBooksGoogle(String[] ids, int quantity) {
    library.addBooks(Request.buyBooksFromGoogle(ids, quantity));
  }

  public void borrowBook(String id, ArrayList<String> books){
    Visitor visitor = findVisitor(id);
    Visit visit = findVisit(visitor);
    ArrayList<Book> booksToBorrow = library.borrowBooks(books);
    for (Book bookToBorrow : booksToBorrow){
      if (bookToBorrow.checkBook()) {
        Transaction newTrans = new Transaction(bookToBorrow, visit);
        transactions.add(newTrans);
      }
    }

  }

  public ArrayList<Transaction> findBorrowedBooks(){
    return transactions;
  }


  public void changeTime(long days, int  hours){
    currentTime.plusDays(days);
    currentTime.plusHours(hours);
  }


  public Time getTime(){return currentTime;}



  public Visitor findVisitor(String id){
    for (Visitor visitor : visitors){
      if (visitor.getUserName().equals(id)){
        return visitor;
      }
    }
    return null;
  }

  private Visit findVisit (Visitor visitor){
    for (Visit visit : openVisits){
      if (visit.getVisitor().equals(visitor)){
        return visit;
      }
    }
    return null;
  }

  public ArrayList<Visitor> getVisitors(){
      return visitors;
  }

  private void populateLibrary() throws FileNotFoundException {
      Scanner sc = new Scanner(bookStoreFile);
      ArrayList<Book> booksToAdd = new ArrayList<>();
      while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] lineArray = line.split(",");
          long isbn = Long.parseLong(lineArray[0]);
          String title = lineArray[1];
          String author = lineArray[2];
          String publisher = lineArray[3];
          String date = lineArray[4];
          int pageNumber = Integer.parseInt(lineArray[5]);
          Book newBook = new Book(isbn, title, author, publisher, date, pageNumber, 1);
          booksToAdd.add(newBook);

      }
      library.addBooks(booksToAdd);
  }



}

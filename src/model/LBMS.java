package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LBMS {

  Library library;
  ArrayList<Visit> oldVisits;
  ArrayList<Visitor> visitors;
  ArrayList<Visit> openVisits;
  ArrayList<Transaction> transactions;
  File bookStoreFile;
  Time startTime;
  Time currentTime;
  String newUserID;



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
//    this.currentTime.run();
  }


  public void registerVisitor(String firstName, String lastName, String address, long phoneNumber){
    Visitor visitor = new Visitor(firstName, lastName, address, phoneNumber, this.newUserID);
    int temp = Integer.parseInt(this.newUserID);
    temp++;
    this.newUserID = String. format("%010d", temp);
    this.visitors.add(visitor);
  }


  public void startVisit(String ID){
    this.openVisits.add(new Visit(findVisitor(ID), currentTime.getDate(),currentTime.getTime()));
  }

  public void endVisit(String ID) {
    for (Visit visit : openVisits) {
      if (visit.getVisitor().getVisitorID() == ID) {
        visit.endVisit(currentTime.getTime());
        openVisits.remove(visit);
        oldVisits.add(visit);
        return;
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


  public void borrowBook(String id, ArrayList<Long> books){
    Visitor visitor = findVisitor(id);
    Visit visit = findVisit(visitor);
    ArrayList<Book> booksToBorrow = library.borrowBooks(books);
    for (Book bookToBorrow : booksToBorrow){
      if (bookToBorrow.checkBook()) {
        Transaction newTrans = new Transaction(bookToBorrow, visit);
        this.transactions.add(newTrans);
      }
    }

  }


  public ArrayList<Transaction> findBorrowedBooks(){
    ArrayList<Transaction> checkedOut = new ArrayList<>();
    for (Transaction t : transactions){
      if (!t.isReturned){
        checkedOut.add(t);
      }
    }
    return checkedOut;
  }


  public void returnBooks(String id, ArrayList<Long> books){
    ArrayList<Transaction> transactions = findTransactions(id, books);
    for (Transaction t : transactions){
      t.returnBook(this.currentTime);
    }
  }




  public void changeTime(long days, int  hours){
    this.currentTime.plusDays(days);
    this.currentTime.plusHours(hours);
  }


  public Time getTime(){return this.currentTime;}



  private Visitor findVisitor(String id){
    for (Visitor visitor : visitors){
      if (visitor.getVisitorID().equals(id)){
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

  private ArrayList<Transaction> findTransactions(String id, ArrayList<Long> books){
    ArrayList<Transaction> transactions = new ArrayList<>();
    for (Transaction t : this.transactions){
      if (t.getVisitor().getVisitorID() == id && books.contains(t.getBook().getIsbn())){
        transactions.add(t);
      }
    }
    return transactions;
  }



}

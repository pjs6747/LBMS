package model;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Transaction {

  /***
   * Book that will be checked out
   */
  private Book book;

  /***
   * Visitor that will be checking out a book
   */
  private Visitor visitor;

  /***
   * Dated that the book is checked out
   */
  private LocalDate checkOutDate;

  /***
   * Dated the book is due back
   */
  private LocalDate dueBack;

  /***
   * Is the book returned
   */
  boolean isReturned;

  public Transaction(Book book, Visit visit){
    this.book = book;
    this.visitor = visit.getVisitor();
    this.checkOutDate = visit.getDate();
    this.dueBack = checkOutDate.plusDays(7);
  }

  /**
   * Gets Book
   * @return a Book
   */
  public Book getBook(){ return book; }

  /**
   * Gets Visitor
   * @return a Visitor
   */
  public Visitor getVisitor() { return visitor; }

  /**
   * Gets DueBackDate
   * @return String dueBackDate
   */
  public LocalDate getDueBack() { return dueBack; }


  /**
   * Calculates the fine due
   * @param dateReturned the date the book was returned
   * @return the amount owed
   */
  public int getFine(LocalDate dateReturned) {
    long daysLate = DAYS.between(dueBack, dateReturned);
    //Book is returned one week late
    if (daysLate > 0 && daysLate <= 7){
      return 10;
    }
    //Book is returned more than one week late
    else if (daysLate > 7 && daysLate <= 17){
      long additionalCharge = 2*(daysLate-7);
      return 10 + (int) additionalCharge;
    }
    //Book reached its maximum fine
    else if (daysLate > 10){
      return 30;
    }
    //Book is not late
    else {
      return 0;
    }
  }

  /**
   * Returns the book and charges the visitor the amount owed
   * @param dateReturned the date the book was returned
   */
  public void returnBook(Time dateReturned){
    this.isReturned = true;
    int fineOwed = getFine(dateReturned.getDate());
    this.visitor.addBalance(fineOwed);
    this.book.returnBook();
  }
}

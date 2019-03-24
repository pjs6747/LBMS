package model;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Transaction {

    /***
     * Book that will be checked out
     */
    Book book;

    /***
     * Visitor that will be checking out a book
     */
    Visitor visitor;

    /***
     * Dated that the book is checked out
     */
    LocalDate checkOutDate;

    /***
     * Dated the book is due back
     */
    LocalDate dueBack;

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

  public long getFine(LocalDate dateReturned) {
      long daysLate = DAYS.between(dueBack, dateReturned);
      //Book is returned one week late
      if (daysLate > 0 && daysLate <= 7){
        return 10;
      }
      //Book is returned more than one week late
      else if (daysLate > 7 && daysLate <= 17){
        long additionalCharge = 2*(daysLate-7);
        return 10 + additionalCharge;
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
}

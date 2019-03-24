package model;

import java.time.LocalDate;
import java.util.ArrayList;

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
     * How much a visitor owes for a late book
     */
    int fine;

    /***
     * Is the book returned
     */
    boolean isReturned;

    public Transaction(Book book, Visit visit){
        this.book = book;
        this.visitor = visit.getVisitor();
        this.checkOutDate = visit.getDate();
        this.dueBack = checkOutDate.plusDays(7);
        this.fine = 0;


    }

    /**
     * Calculates the amount a visitor owes based on how many days
     * it is after the dueDate.
     */
//    public void increaseFine(){
//        if (date +1 over duedate){
//            fine += 10;
//        }else{
//            fine+=2;
//        }
//    }

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
}

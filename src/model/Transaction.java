package model;

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
    String checkOutDate;

    /***
     * Dated the book is due back
     */
    String dueBack;

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
        this.fine = 0;
        this.dueBack = this.calculateDueBack();
        //this.isReturned = false;
    }

    /**
     * Calculates the dueDate of a book based on the checked
     * out date. A visitor has 7 days to bring the book back.
     */
    public String calculateDueBack(){
        String [] date = checkOutDate.split("/");
        int [] intDate = new int [3];
        for (int i=0; i<3; i++){
            intDate[i] = (Integer.parseInt(date[i]));
        }
        intDate[1]+= 7;
        if (intDate[1]>30){
            intDate[0] +=1;
            intDate[1]-= 30;
        }
        if (intDate[0]> 12){
            intDate[2]+=1;
            intDate[0]-=12;
        }
        String dueDate = Integer.toString(intDate[0])+ "/" + Integer.toString(intDate[1])+ "/"+ Integer.toString(intDate[2]);
        return dueDate;
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
    public String getDueBack() { return dueBack; }
}

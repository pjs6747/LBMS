package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LBMS {

  Library library;
  ArrayList<Visit> visits;
  ArrayList<Visitor> visitors;
  ArrayList<Visit> openVisits;
  File bookStoreFile;



  public LBMS(){
    library = new Library();
    visits = new ArrayList<>();
    visitors = new ArrayList<>();
    openVisits = new ArrayList<>();
    bookStoreFile = new File("LBMS\\SRC\\Files\\books");
  }


  public void registerVisitor(Visitor visitor){
    this.visitors.add(visitor);
  }


  public void startVisit(long ID){
    for (Visitor visitor : visitors){
      if (visitor.getVisitorID() == ID){
        this.openVisits.add(new Visit(visitor, "Temp", "Temp"));
        return;
      }
    }
  }

  public void endVisit(long ID) {
    for (Visitor visitor : visitors) {
      if (visitor.getVisitorID() == ID) {
        for (Visit visit : openVisits){
          if (visit.getVisitor().getVisitorID() == ID){
            visit.endVisit("Temp");
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
  }



}

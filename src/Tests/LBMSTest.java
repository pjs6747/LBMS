package Tests;

import model.Book;
import model.LBMS;
import model.Visit;
import model.Visitor;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LBMSTest {

  LBMS lbms;
  Visitor v1 = new Visitor("Tom", "Smith", "1134 Avalon", 5709139903L, 1);
  Visitor v2 = new Visitor("Dave", "Smith", "1134 Avalon", 5709139903L, 2);


  @Before
  public void before(){
    this.lbms = new LBMS();
  }

  @Test
  public void registerVisitor() {
    this.lbms.registerVisitor(v1);
    System.out.println("Test");
  }

  @Test
  public void startVisit(){
    lbms.startVisit(1);
  }

  @Test
  public void endVisit() {
    this.lbms.registerVisitor(v1);
    this.lbms.registerVisitor(v2);
    lbms.startVisit(1);
    lbms.startVisit(2);
    lbms.endVisit(1);
    lbms.endVisit(2);
  }

  @Test
  public void buyBooks() throws FileNotFoundException {
    ArrayList isbns = new ArrayList();
    isbns.add(9781450431835L);
    isbns.add(9780375896798L);
    this.lbms.buyBooks(isbns, 2);
    ArrayList otherISBNS = new ArrayList();
    otherISBNS.add(9781450431835L);
    this.lbms.buyBooks(otherISBNS, 3);
    System.out.println("Test");
  }

  @Test
  public void borrowBooks() throws FileNotFoundException{
    lbms.registerVisitor(v1);
    lbms.startVisit(v1.getVisitorID());
    ArrayList isbns = new ArrayList();
    isbns.add(9781450431835L);
    isbns.add(9780375896798L);
    lbms.buyBooks(isbns, 2);
    lbms.borrowBook(v1.getVisitorID(), isbns);
    System.out.println(":");
  }

  @Test
  public void findBorrowedBooks(){

  }
}
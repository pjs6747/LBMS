package Tests;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LBMSTest {

  private LBMS lbms;
  private ArrayList<Long> isbns;


  @Before
  public void beforeEach() throws FileNotFoundException{
    this.lbms = new LBMS();
    this.isbns = new ArrayList<>();
    this.isbns.add(9781450431835L);
    this.isbns.add(9780375896798L);
    lbms.registerVisitor("Tom", "Smith", "1134 Avalon", 5709139903L);
    lbms.startVisit("0000000001");
    lbms.buyBooks(isbns, 2);
  }


  @Test
  public void endVisit() {
    lbms.registerVisitor("Tom", "Smith", "1134 Avalon", 5709139903L);
    lbms.registerVisitor("Dave", "Smith", "1134 Avalon", 5709139903L);
    lbms.startVisit("0000000001");
    lbms.startVisit("0000000002");
    lbms.endVisit("0000000001");
    lbms.endVisit("0000000002");
  }


  @Test
  public void findBorrowedBooks() {
    lbms.borrowBook("0000000001", isbns);
    assertEquals(2, lbms.findBorrowedBooks().size());
  }

  @Test
  public void returnBook() {
    lbms.borrowBook("0000000001", isbns);
    this.isbns.add(9781450431835L);
    lbms.returnBooks("0000000001", isbns);
    assertEquals(1, lbms.findBorrowedBooks().size());
  }

  @Test
  public void payFine() {
    lbms.borrowBook("0000000001", isbns);
    this.isbns.add(9781450431835L);
    lbms.changeTime(30, 0);
    lbms.returnBooks("0000000001", isbns);
    assertEquals(5, lbms.payFine("0000000001", 25));
    lbms.changeTime(30, 0);
    assertEquals(0, lbms.payFine("0000000001", 5));
  }
}
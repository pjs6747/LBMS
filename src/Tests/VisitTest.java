package Tests;

import model.Book;
import model.Visit;
import model.Visitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitTest {

  Book book;
  Visitor visitor;
  Visit visit;

  @Before public void setUp(){
    this.visitor = new Visitor("Ted", "Smith", "1134 Avalon", 5709718409L, 1);
    this.visit = new Visit(visitor, "02/28/2019", "7:00");
  }

  @Test
  public void endVisit() {
    visit.endVisit("8:00");
    assertEquals(visit.toString(), "Ted Smith visited on 02/28/2019 at 7:00 and left at 8:00");
  }

  @Test
  public void getVisitor() {
    Visitor v = visit.getVisitor();
    Assert.assertEquals(v.getFirstName(), "Ted");
  }

  @Test
  public void getDate() {
    assertEquals(visit.getDate(), "02/28/2019");
  }

  @Test
  public void getStartTime(){
    assertEquals(visit.getStartTime(), "7:00");
  }

  @Test
  public void getEndTime() {
    visit.endVisit("8:00");
    assertEquals(visit.getEndTime(), "8:00");
  }

}
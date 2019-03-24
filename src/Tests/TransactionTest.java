package Tests;

import model.Book;
import model.Transaction;
import model.Visit;
import model.Visitor;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TransactionTest {

  LocalDate checkoutDate;
  LocalTime checkoutTime;
  Visitor visitor;
  Book book;
  Visit visit;
  Transaction transaction;

  @Before
  public void setUp() throws Exception {
    this.checkoutDate = LocalDate.of(2019, 1, 1);
    this.checkoutTime = LocalTime.of(12, 0);
    this.visitor = new Visitor("Tom", "Smith", "1134 Avalon", 5709139903L, 1);
    this.book = new Book(1, "TestBook", "Alec", "My Mom", "Temp", 312, 2);
    this.visit =new Visit(visitor, checkoutDate, checkoutTime);
    this.transaction = new Transaction(this.book, visit);
  }

  @Test
  public void getBook() {
    assertEquals(transaction.getBook(), this.book);
  }

  @Test
  public void getVisitor() {
    assertEquals(transaction.getVisitor(), visitor);
  }

  @Test
  public void getDueBack() {
    assertEquals(transaction.getDueBack(), LocalDate.of(2019, 1, 8));
  }
}
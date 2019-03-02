package model;

import java.io.File;
import java.util.ArrayList;

public class Library {

  ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<>();
  }
    public ArrayList<Book> getBooks () {
      return this.books;
    }

    public void addBooks(ArrayList<Book> books){
      for (Book book : books){
        if (this.books.contains(book)){
          int numberCopies = book.getCopies();
          int index = this.books.lastIndexOf(book);
          this.books.get(index).addCopies(numberCopies);
        }
      }

    }
  }

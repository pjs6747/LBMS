package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Book;

public class Library {

  ArrayList<Book> books;
  File booksFile;

  public Library(String fileName) throws FileNotFoundException {
    this.books = new ArrayList<>();
    this.booksFile = new File("LBMS\\src\\Files\\books");
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

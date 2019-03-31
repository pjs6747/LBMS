package model;
/*
Project: LBMS
File: Library
Author: Group 4
 */

import java.io.File;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    /**
     * Adds books to the library
     * @param booksToAdd Book objects to add to library
     */
    public void addBooks(ArrayList<Book> booksToAdd) {
        for (Book book : booksToAdd) {
            if (this.books.contains(book)) {
                int numberCopies = book.getCopies();
                int index = this.books.lastIndexOf(book);
                this.books.get(index).addCopies(numberCopies);
            } else {
                this.books.add(book);
            }
        }
    }

    /**
     * Removes books from library
     * @param isbns isbns to remove
     * @return list of Books borrowed
     */
    public ArrayList<Book> borrowBooks(ArrayList isbns){
        ArrayList<Book> booksToAdd = new ArrayList<>();
        for (Book book : books) {
            long isbn = book.getIsbn();
            if (isbns.contains(isbn)){
                booksToAdd.add(book);
                isbns.remove(isbn);
            }
        }
        return booksToAdd;
    }

}



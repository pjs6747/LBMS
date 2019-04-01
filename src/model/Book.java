package model;
/*
Project: LBMS
File: Book
Author: Group 4
 */

import model.GoogleBook.GoogleBookRepsonse;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {


    /**
     * The isbn of the book
     */
    private long isbn;

    /**
     * The title of the book
     */
    private String title;

    /**
     * The author of the book
     */
    private ArrayList<String> author;

    /**
     * The publisher of the book
     */
    private String publisher;

    /**
     * The date book was published
     */
    private String publishDate;

    /**
     * The number of pages in book
     */
    private int PageCount;

    /**
     * The number of this book in library
     */
    private int copies;

    /**
     * The number of copies of this book checked out of the library
     */
    private int copiesCheckedOut;

    public Book(GoogleBookRepsonse responseBook, int quantity) {
        this.isbn = Integer.parseInt(responseBook.volumeInfo.industryIdentifiers[1].identifier);
        this.title = responseBook.volumeInfo.title;
        this.author = new ArrayList<>(Arrays.asList(responseBook.volumeInfo.authors));
        this.publisher = responseBook.volumeInfo.publisher;
        this.publishDate = responseBook.volumeInfo.publishedDate;
        this.PageCount = Integer.parseInt(responseBook.volumeInfo.pageCount);
        this.copies = quantity;
        this.copiesCheckedOut = 0;
    }

    public Book(long isbn, String title, String author, String publisher, String publishDate, int pageCount, int copies){
        this.isbn = isbn;
        this.title = title;
        this.author = new ArrayList<>();
        this.author.add(author);
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.PageCount = pageCount;
        this.copies = copies;
        this.copiesCheckedOut = 0;
    }

    public void addCopies(int number){
        this.copies += number;
    }

    /**
     * Gets isbn
     * @return Book isbn
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Gets author
     * @return Book author
     */
    public ArrayList<String> getAuthor() {
        return author;
    }

    /**
     * Gets title
     * @return Book tiile
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets publisher
     * @return Book publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Gets publish date
     * @return date Book was published
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * Gets page count
     * @return number of pages in Book
     */
    public int getPageCount() {
        return PageCount;
    }

    /**
     * Gets copies
     * @return number of this Book in library
     */
    public int getCopies() {
        return copies;
    }

    /**
     * Gets copies checked out
     * @return number of the Book checked out
     */
    public int getCopiesCheckedOut() {
        return copiesCheckedOut;
    }

    /**
     * Checks out book if possible
     * @return True if checkout was successful
     */
    public Boolean checkBook(){
        if (copies > 0){
            copies--;
            copiesCheckedOut++;
            return true;
        }
        return false;
    }

    /**
     * Adds 1 to copies
     */
    public void returnBook(){
        this.copies++;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Book){
            Book other = (Book) o;
            return (this.isbn == other.isbn);
        }
        return false;
    }

}

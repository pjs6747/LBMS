public class Book {


  /**
   * The isbn of the book
   */
  private int isbn;

  /**
   * The title of the book
   */
  private String title;

  /**
   * The author of the book
   */
  private String author;

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


  public void Book(int isbn, String title, String author, String publisher, String publishDate, int pageCount, int copies){
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.publishDate = publishDate;
    this.PageCount = pageCount;
    this.copies = copies;
    this.copiesCheckedOut = 0;
  }

  /**
   * Gets isbn
   * @return Book isbn
   */
  public int getIsbn() {
    return isbn;
  }

  /**
   * Gets author
   * @return Book author
   */
  public String getAuthor() {
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

}

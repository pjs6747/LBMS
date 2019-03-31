package model.strategy;

import model.Book;

import java.util.ArrayList;

/**
 * interface of strategy pattern for sorting books
 */
public interface BookSort{
    public void sort(ArrayList<Book> books);
}
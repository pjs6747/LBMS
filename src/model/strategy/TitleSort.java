package model.strategy;

import model.Book;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TitleSort implements BookSort{
    private Comparator<Book> TitleCompare = new Comparator<model.Book>() {
        @Override
        public int compare(model.Book book1, model.Book book2) {
            return book1.getTitle().toUpperCase().compareTo(book2.getTitle().toUpperCase());
        }
    };

    @Override
    public void sort(ArrayList<Book> books) {
        Collections.sort(books, TitleCompare);
    }
}

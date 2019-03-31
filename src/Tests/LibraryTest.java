package Tests;

/*
Project: LBMS
File: LibraryTest
Author: Group 4
 */

import model.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;

    @Before
    public void setUp() throws Exception {
        this.library = new Library();
        System.out.println("hey");
    }

    @Test
    public void getBooks() {
    }
}
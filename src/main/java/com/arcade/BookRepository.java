package com.arcade;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

public class BookRepository {

    public Set<String> getBooks() {
        return new HashSet<String>();
    }

    public String addBook(String book) {
        return book;
    }

}

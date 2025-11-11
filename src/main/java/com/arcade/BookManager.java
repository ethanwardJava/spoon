package com.arcade;


import java.util.Set;

public class BookManager {
    BookRepository repo;

    public BookManager(BookRepository repo) {
        this.repo = repo;
    }

    public int getBookInventoryCount() {
        Set<String> allBooks = repo.getBooks();
        return allBooks.size();
    }

    public void addBook(String bookName) {
        repo.addBook(bookName);
    }
}

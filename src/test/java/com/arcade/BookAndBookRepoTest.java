package com.arcade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

public class BookAndBookRepoTest {

    @Spy
    BookRepository repo;
    @InjectMocks
    BookManager manager;

    Set<String> booksDB;

    @BeforeEach
    void setUp() {
        booksDB = new HashSet<String>();
        booksDB.add("Economy");
    }

    @Test
    public void testingTheCountOfBooks() {
        BookManager bookManagerSpy = Mockito.spy(manager);
        when(repo.getBooks()).thenReturn(booksDB);
    }



}

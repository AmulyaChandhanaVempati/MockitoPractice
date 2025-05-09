package com.practice.mockito.test_doubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookRepositoryDummy implements BookRepository {

    // In memory database or HashMap or List to act as a book store
    Map<String, Book> bookStore = new HashMap<>();
    @Override
    public void save(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        bookStore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}

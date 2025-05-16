package com.practice.mockito.argument.captor;


public interface BookRepository {
    void save(Book book);

    Book findById(String bookId);
}

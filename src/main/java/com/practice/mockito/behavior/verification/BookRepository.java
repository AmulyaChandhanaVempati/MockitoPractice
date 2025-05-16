package com.practice.mockito.behavior.verification;



public interface BookRepository {
    void save(Book book);

    Book findById(String bookId);
}

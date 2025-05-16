package com.practice.mockito.spies;

import com.practice.mockito.stubbing.BookRepository;
import com.practice.mockito.stubbing.BookRequest;

import java.util.List;
public class BookService {
    private BookRepository bookRepository;

    public BookService() {
    }
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //we will spy this method
    public Book findById(String bookId) {
        throw  new RuntimeException("Method not implemented");
    }

    // we will call this method
    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (price * discountRate) / 100;
        return newPrice;
    }
}

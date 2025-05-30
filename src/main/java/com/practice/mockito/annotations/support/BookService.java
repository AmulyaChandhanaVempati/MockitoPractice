package com.practice.mockito.annotations.support;

import java.util.List;
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        // 500 , apply 10% discount -> 10% 500 is 50. 500-50 = 450
        for (Book book : newBooks) {
            int price = book.getPrice();
            int newPrice = price - (price * discountRate / 100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }

}

package com.practice.mockito.spies;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int discountRate) {
        Book book = bookService.findById(bookId); // we need to mock this method
        int discountedPrice = bookService.getAppliedDiscount(book, discountRate); // we need to call this method
        return discountedPrice;
    }
}

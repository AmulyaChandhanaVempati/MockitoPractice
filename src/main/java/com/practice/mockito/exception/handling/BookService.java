package com.practice.mockito.exception.handling;


import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBook();
        } catch (SQLException e) {
            throw new DataBaseReadException("Unable to read from Database due to "+ e.getMessage());
        }
        int totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    public void addBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            throw new DataBaseWriteException("Unable to writr from Database due to "+ e.getMessage());
        }
    }
}

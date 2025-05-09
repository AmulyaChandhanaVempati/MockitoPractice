package com.practice.mockito.test_doubles.spy;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        if(book.getPrice()>400){
            return;
        }
        bookRepository.save(book);
    }
}

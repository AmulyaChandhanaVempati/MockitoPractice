package com.practice.mockito.test_doubles.dummy;

public class BookService {
    private BookRepository bookRepository;
    private EmailService emailService;

    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        bookRepository.save(book);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }
}

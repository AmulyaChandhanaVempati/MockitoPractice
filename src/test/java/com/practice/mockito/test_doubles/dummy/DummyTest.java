package com.practice.mockito.test_doubles.dummy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void testDummy(){
        BookRepository bookRepository = new BookRepositoryDummy();
        // Email Service is of no use in this test, but we still need it to satisfy constructor
        // this dependency is a dummy, just to make this code compile
        EmailService emailService = new EmailServiceDummy();
        BookService bookService = new BookService(bookRepository,emailService);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        bookService.addBook(book1);
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());
        bookService.addBook(book2);

        int numberOfBooks = bookService.findNumberOfBooks();
        assertEquals(2, numberOfBooks);
    }

    @Test
    public void testDummyWithMockito(){
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);
        BookService bookService = new BookService(bookRepository,emailService);

        Collection<Book> books = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());

        books.add(book1);
        books.add(book2);

        // Mocking the behavior of the bookRepository
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBooks());
    }
}

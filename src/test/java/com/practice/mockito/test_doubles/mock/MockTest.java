package com.practice.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockTest {

    @Test
    public void testMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save called

        bookRepositoryMock.verify(book2, 1); // verify that save was called with book2
    }

    @Test
    public void testMockWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save called

        // verify that save was called with book2
        Mockito.verify(bookRepository,Mockito.times(1)).save(book2);

        // verify that save was called with book1
        Mockito.verify(bookRepository,Mockito.times(0)).save(book1);
    }
}

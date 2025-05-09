package com.practice.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpyTest {

    @Test
    public void testSpy() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());
        bookService.addBook(book1);
        assertEquals(0, bookRepositorySpy.timesCalled());
        bookService.addBook(book2);

        assertEquals(1, bookRepositorySpy.timesCalled());
        assertEquals(true, bookRepositorySpy.calledWith(book2));
    }

    @Test
    public void testSpyWithMockito() {
        BookRepository bookRepository = Mockito.spy(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());
        bookService.addBook(book1);
        bookService.addBook(book2);
        // verify that save was called with book2
        Mockito.verify(bookRepository, Mockito.times(1)).save(book2);
        // verify that save was called with book1
        Mockito.verify(bookRepository, Mockito.times(0)).save(book1);
    }
}

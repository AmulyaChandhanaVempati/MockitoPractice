package com.practice.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class FakeTest {

    @Test
    public void testFake(){
        BookRepository bookRepository = new BookRepositoryFake();
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        bookService.addBook(book1);
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());
        bookService.addBook(book2);

        int numberOfBooks = bookService.findNumberOfBooks();
        assertEquals(2, numberOfBooks);
    }

    @Test
    public void testFakeWithMockito(){
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBooks());
    }
}

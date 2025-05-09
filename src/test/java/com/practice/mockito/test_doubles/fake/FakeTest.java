package com.practice.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
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
}

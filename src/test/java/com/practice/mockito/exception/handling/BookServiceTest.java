package com.practice.mockito.exception.handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;


    @Test
    public void testTotalPriceOfBooks() throws SQLException {
        Mockito.when(bookRepository.findAllBook()).thenThrow(SQLException.class);
        assertThrows(DataBaseReadException.class,()->bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testTotalPriceOfBooks1() throws SQLException {
        Mockito.when(bookRepository.findAllBook()).thenThrow(new SQLException("Can't connect to DataBase"));
        assertThrows(DataBaseReadException.class,()->bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testAddBook() throws SQLException {
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Mockito.doThrow(DataBaseWriteException.class).when(bookRepository).save(book1);

        assertThrows(DataBaseWriteException.class,()->bookService.addBook(book1));
    }
}

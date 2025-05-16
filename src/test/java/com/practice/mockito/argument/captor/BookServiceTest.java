package com.practice.mockito.argument.captor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Captor
    ArgumentCaptor<Book> argumentCaptor;

    @Test
    public void testSaveBook(){
       BookRequest bookRequest = new BookRequest("Mockito In Action", 600, "Amulya", "Chandhana", null);
       //ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
       bookService.addBook(bookRequest);
       Mockito.verify(bookRepository).save(argumentCaptor.capture());
       Book book = argumentCaptor.getValue();
       assertEquals("Mockito In Action", book.getTitle());
    }


}

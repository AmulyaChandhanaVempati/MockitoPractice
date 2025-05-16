package com.practice.mockito.bdd.stubbing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
public class StubTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testStubbingInTraditionalMockitoStyle(){

        List<Book> books = new ArrayList<>();

        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    @DisplayName("Given - NewBooks, When - GetNewBooksWithAppliedDiscount is called, Then - Return Books with applied discount")
    public void test_Given_NewBooks_When_GetNewBooksWithAppliedDiscountIsCalled_Then_ReturnBooksWithAppliedDiscount() {
        //Arrange - Given
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", LocalDate.now());
        books.add(book1);
        books.add(book2);
        given(bookRepository.findNewBooks(7)).willReturn(books);
        // Act - When
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
        // Assert - Then
        //AssertJ - BDDAssertions
//        then(newBooksWithAppliedDiscount)isNotNull();
//        then(newBooksWithAppliedDiscount).hasSize(2);
//        then(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
//        then(newBooksWithAppliedDiscount.get(1).getPrice()).isEqualTo(360);
    }
}

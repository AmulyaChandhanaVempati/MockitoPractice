package com.practice.mockito.test_doubles.mock;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {
    int saveCalled = 0;
    Book lastSavedBook = null;
    @Override
    public void save(Book book) {
        saveCalled++;
        lastSavedBook = book;
    }

    //Behaviour verification at mock level
    public void verify(Book book, int times){
        assertEquals(saveCalled, times);
        assertEquals(lastSavedBook, book);
    }

}

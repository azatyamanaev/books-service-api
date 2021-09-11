package ru.itis.booksservice.services;

import ru.itis.booksservice.dto.BookDto;
import ru.itis.booksservice.models.Book;

import java.util.List;

public interface BookService {
    void addBook(BookDto bookDto);
    void updateBook(Long bookId, BookDto bookDto);
    void deleteBook(Long bookId);
    BookDto getBookByTitle(String title);
    List<BookDto> getAllBooks();
    void readBook(Long bookId);
    List<BookDto> getBooks(int number);
    List<BookDto> getBooksByPhrase(String string, int number);
}

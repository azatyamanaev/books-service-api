package ru.itis.booksservice.mappers;


import ru.itis.booksservice.dto.BookDto;
import ru.itis.booksservice.models.Book;

public interface BookMapper {
    Book toBook(BookDto bookDto);
    BookDto toDto(Book book);
}

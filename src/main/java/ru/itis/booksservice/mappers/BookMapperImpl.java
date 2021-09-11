package ru.itis.booksservice.mappers;

import org.springframework.stereotype.Component;
import ru.itis.booksservice.dto.BookDto;
import ru.itis.booksservice.models.Book;


@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public Book toBook(BookDto bookDto) {

        if (bookDto == null) {
            return null;
        }

        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .printYear(bookDto.getPrintYear())
                .readAlready(bookDto.getReadAlready())
                .image(bookDto.getImage())
                .build();
    }

    @Override
    public BookDto toDto(Book book) {
        if (book == null) {
            return null;
        }

        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .printYear(book.getPrintYear())
                .readAlready(book.getReadAlready())
                .image(book.getImage())
                .build();
    }
}

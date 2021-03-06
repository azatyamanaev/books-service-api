package ru.itis.booksservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private String author;
    private String isbn;
    private Long printYear;
    private Boolean readAlready;
    private String image;
}

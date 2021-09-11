package ru.itis.booksservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookWithStatsDto {
    private String title;
    private String description;
    private String author;
    private String isbn;
    private Long printYear;
    private Boolean readAlready;
    private String image;
    private Long count;
}

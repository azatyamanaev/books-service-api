package ru.itis.booksservice.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.io.File;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@Schema(description = "Class representing a book in the application")
public class Book {

    @Schema(description = "Unique identifier of the book", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Schema(description = "Title of the book", example = "Postgresql.Основы", required = true)
    @Column(name = "title", nullable = false)
    private String title;

    @Schema(description = "Description of the book", required = true)
    @Column(name = "description", nullable = false)
    private String description;

    @Schema(description = "Author of the book", example = "Ричард Стоунз", required = true)
    @Column(name = "author", nullable = false, updatable = false)
    private String author;

    @Schema(description = "ISBN of the book", example = "978-5-367-03333-5", required = true)
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Schema(description = "Release year of the book", example = "2012", required = true)
    @Column(name = "print_year", nullable = false)
    private Long printYear;

    @Schema(description = "Shows if the book has been read", example = "true", required = true)
    @Column(name = "read_already", nullable = false)
    private Boolean readAlready;

    @Schema(description = "Book cover", required = true)
    @Column(name = "image", nullable = false)
    private String image;

    @Transient
    private File sourceFile;


    @PostLoad
    public void loadFile() {
        sourceFile = new File(image);
    }

    @PreUpdate
    public void updateFileInformation() {
        this.image = sourceFile.getAbsolutePath();
    }


}

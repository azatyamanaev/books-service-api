package ru.itis.booksservice.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stats")
@Schema(description = "Class representing book's number of reads")
public class Stats {

    @Schema(description = "Unique identifier of the stat", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Number of reads in one day", example = "10", required = true)
    @Column(name = "count", nullable = false)
    private Long count;

    @Schema(description = "Specific day on which the reads were counted", example = "2021-09-21", required = true)
    @Column(name = "local_date", nullable = false)
    private String localDate;

    @Schema(description = "Link to the book for which the reads were counted", required = true)
    @ManyToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false, name = "book_id")
    private Book book;
}

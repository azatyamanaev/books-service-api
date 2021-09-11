package ru.itis.booksservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.booksservice.dto.BookWithStatsDto;
import ru.itis.booksservice.services.StatsService;

import java.util.List;

@RestController
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @Operation(summary = "get books' number of reads for the period")
    @GetMapping("/books/stats")
    public ResponseEntity<List<BookWithStatsDto>> getBooksWithStats(@RequestParam("from") String from, @RequestParam("to") String to) {
        return ResponseEntity.ok().body(statsService.getBooksWithStats(from, to));
    }
}

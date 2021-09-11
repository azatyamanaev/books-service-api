package ru.itis.booksservice.services;

import ru.itis.booksservice.dto.BookWithStatsDto;

import java.util.List;

public interface StatsService {
    void updateOrCreateStat(Long bookId);
    List<BookWithStatsDto> getBooksWithStats(String from, String to);
}

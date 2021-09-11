package ru.itis.booksservice.services;

import org.springframework.stereotype.Service;
import ru.itis.booksservice.dto.BookWithStatsDto;
import ru.itis.booksservice.models.Stats;
import ru.itis.booksservice.repositories.BookRepository;
import ru.itis.booksservice.repositories.StatsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    private final BookRepository bookRepository;
    private final StatsRepository statsRepository;

    public StatsServiceImpl(BookRepository bookRepository, StatsRepository statsRepository) {
        this.bookRepository = bookRepository;
        this.statsRepository = statsRepository;
    }

    private void addStat(Long bookId) {
        Stats stats = Stats.builder()
                .count(1L)
                .localDate(LocalDate.now().toString())
                .book(bookRepository.getById(bookId))
                .build();
        statsRepository.save(stats);
    }

    private void updateStat(Stats stats) {
        stats.setCount(stats.getCount() + 1);
        statsRepository.save(stats);
    }

    @Override
    public void updateOrCreateStat(Long bookId) {
        List<Stats> statsList = statsRepository.getAllByBook_Id(bookId);
        Stats stats = null;
        for (Stats s : statsList) {
            if (s.getLocalDate().equals(LocalDate.now().toString())) {
                stats = s;
            }
        }
        if (stats != null) {
            updateStat(stats);
        } else {
            addStat(bookId);
        }
    }

    @Override
    public List<BookWithStatsDto> getBooksWithStats(String from, String to) {
        return statsRepository.getBooksWithStats(from, to);
    }

}

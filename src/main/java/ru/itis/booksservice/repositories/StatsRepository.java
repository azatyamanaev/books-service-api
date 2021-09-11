package ru.itis.booksservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.booksservice.dto.BookWithStatsDto;
import ru.itis.booksservice.models.Book;
import ru.itis.booksservice.models.Stats;

import javax.transaction.Transactional;
import java.util.List;

public interface StatsRepository extends JpaRepository<Stats, Long> {
    @Query(value = "select * from stats where book_id = :bookId", nativeQuery = true)
    List<Stats> getAllByBook_Id(Long bookId);
    @Query("select new ru.itis.booksservice.dto.BookWithStatsDto(book.title, book.description, book.author, book.isbn, book.printYear, book.readAlready, book.image, sum(stats.count)) " +
            "from Stats stats join Book book on stats.book.id = book.id where stats.localDate between :from and :to " +
            "group by book.id")
    List<BookWithStatsDto> getBooksWithStats(@Param("from") String from, @Param("to") String to);
}

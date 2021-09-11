package ru.itis.booksservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.booksservice.models.Book;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookByTitle(String title);
    @Modifying
    @Transactional
    @Query(value = "update book set read_already = true where id = :bookId and read_already = false", nativeQuery = true)
    void updateStatus(@Param("bookId") Long bookId);
}

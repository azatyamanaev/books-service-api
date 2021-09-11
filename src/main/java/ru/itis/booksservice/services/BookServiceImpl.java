package ru.itis.booksservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.booksservice.dto.BookDto;
import ru.itis.booksservice.mappers.BookMapper;
import ru.itis.booksservice.models.Book;
import ru.itis.booksservice.repositories.BookRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final StatsService statsService;

    @Autowired
    private EntityManager entityManager;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, StatsService statsService) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.statsService = statsService;
    }

    @Override
    public void addBook(BookDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, BookDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        book.setId(bookId);
        book.setReadAlready(false);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDto getBookByTitle(String title) {
        return bookMapper.toDto(bookRepository.getBookByTitle(title));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream().map(bookMapper :: toDto).collect(Collectors.toList());
    }

    @Override
    public void readBook(Long bookId) {
        statsService.updateOrCreateStat(bookId);
        bookRepository.updateStatus(bookId);
    }

    @Override
    public List<BookDto> getBooks(int number) {
        return bookRepository.findAll(PageRequest.ofSize(number)).getContent()
                .stream().map(bookMapper :: toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBooksByPhrase(String string, int number) {
        List<Book> bookList = entityManager.createNativeQuery("select * from book where to_tsvector(description) @@ to_tsquery(:string)", Book.class)
                .setParameter("string", string).setMaxResults(number).getResultList();
        return bookList.stream().map(bookMapper :: toDto).collect(Collectors.toList());
    }
}

package ru.itis.booksservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.booksservice.dto.BookDto;
import ru.itis.booksservice.models.Book;
import ru.itis.booksservice.services.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Find book by title")
    @GetMapping("/books/one")
    public ResponseEntity<BookDto> getBookById(@RequestParam("name") String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

    @Operation(summary = "Add a new book")
    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update an existing book")
    @PutMapping("/books/{book-id}")
    public ResponseEntity<?> updateBook(@PathVariable("book-id") Long bookId, @RequestBody BookDto bookDto) {
        bookService.updateBook(bookId, bookDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update an existing book's status")
    @PutMapping("/books/{book-id}/read")
    public ResponseEntity<?> readBook(@PathVariable("book-id") Long bookId) {
        bookService.readBook(bookId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete a book")
    @DeleteMapping("/books/{book-id}")
    public ResponseEntity<?> deleteBook(@PathVariable("book-id") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Find all books")
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @Operation(summary = "Find a number of books")
    @GetMapping("/books/page")
    public ResponseEntity<List<BookDto>> getBooks(@RequestParam("number") int number) {
        return ResponseEntity.ok().body(bookService.getBooks(number));
    }

    @Operation(summary = "Find a book by phrase")
    @GetMapping("/books/search")
    public ResponseEntity<List<BookDto>> getBookByPhrase(@RequestParam("string") String string, @RequestParam("number") int number) {
        return ResponseEntity.ok().body(bookService.getBooksByPhrase(string, number));
    }

}

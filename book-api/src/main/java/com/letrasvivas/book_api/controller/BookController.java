package com.letrasvivas.book_api.controller;

import com.letrasvivas.book_api.model.Book;
import com.letrasvivas.book_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title) {
        if (title != null && !title.isEmpty()) {
            List<Book> books = bookService.findBooksByTitle(title);
            return ResponseEntity.ok(books);
        } else {
            List<Book> books = bookService.findAllBooks();
            return ResponseEntity.ok(books);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
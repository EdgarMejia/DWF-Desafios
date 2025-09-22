package com.letrasvivas.book_api.controller;

import com.letrasvivas.book_api.dto.BookCreateDTO;
import com.letrasvivas.book_api.model.Book;
import com.letrasvivas.book_api.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Management", description = "Operaciones para gestionar libros")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los libros",
            description = "Devuelve una lista de todos los libros. Se puede filtrar por título.")
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title) {
        if (title != null && !title.isEmpty()) {
            List<Book> books = bookService.findBooksByTitle(title);
            return ResponseEntity.ok(books);
        } else {
            List<Book> books = bookService.findAllBooks();
            return ResponseEntity.ok(books);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un libro por ID",
            description = "Devuelve un libro específico según su ID.")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.findBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo libro",
            description = "Registra un nuevo libro en la base de datos con validación de datos.")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookCreateDTO bookDto) {
        // Mapear el DTO a la entidad Book
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un libro existente",
            description = "Actualiza los datos de un libro existente usando su ID.")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookCreateDTO bookDto) {
        return bookService.findBookById(id)
                .map(existingBook -> {
                    existingBook.setTitle(bookDto.getTitle());
                    existingBook.setAuthor(bookDto.getAuthor());
                    existingBook.setIsbn(bookDto.getIsbn());
                    Book updatedBook = bookService.saveBook(existingBook);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un libro",
            description = "Elimina un libro de la base de datos por su ID.")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
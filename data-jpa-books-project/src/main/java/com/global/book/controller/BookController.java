package com.global.book.controller;

import com.global.book.dto.BookDto;
import com.global.book.entity.Book;
import com.global.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {
    public final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        //we're using DTO here to return specific data
        BookDto bookDto = new BookDto(book.getId(), book.getName(), book.getPrice());
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.updateName(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}

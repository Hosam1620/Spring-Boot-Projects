package com.global.book.controller;

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping
    public Iterable<Author> findAll() {
        return authorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
    //should remember that if you call insert, you shouldn't give it an id
    //because this is make jpa redirect the request as updating request not insert one.
    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.insert(author));
    }

    @PutMapping
    public ResponseEntity<Author> updateUserName(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.updateName(author));
    }

}

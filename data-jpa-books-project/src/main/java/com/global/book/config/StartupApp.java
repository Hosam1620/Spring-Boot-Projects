package com.global.book.config;

import com.global.book.entity.Author;
import com.global.book.entity.Book;
import com.global.book.service.AuthorService;
import com.global.book.service.BookService;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class StartupApp implements ApplicationRunner {
//    private final BookService bookService;
//    private final AuthorService authorService;
//
//    public StartupApp(BookService bookService, AuthorService authorService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//    }

    @Override
    public void run(@NonNull ApplicationArguments args) throws Exception {
//        //add some data for authors
//        Author author1 = new Author();
//        author1.setName("Ahmed");
//        Author author2 = new Author();
//        author2.setName("Mohamed");
//        Author author3 = new Author();
//        author3.setName("Ali");
//
//        authorService.insertAll(Arrays.asList(author1, author2, author3));
//
//        //add some data for books
//        Book book1 = new Book();
//        book1.setName("Java JPA");
//        book1.setPrice(180);
//        book1.setAuthor(authorService.getReferenceById(1L));//findById(1L) should be using getReferenceById();
//        Book book2 = new Book();
//        book2.setName("Data base Oracle");
//        book2.setPrice(150);
//        book2.setAuthor(authorService.getReferenceById(2L));//findById(1L)
//        Book book3 = new Book();
//        book3.setName("Python");
//        book3.setPrice(200);
//        book3.setAuthor(authorService.getReferenceById(2L));
//
//        bookService.insertAll(Arrays.asList(book1, book2, book3));
    }

    //note that Runnable is an interface from Java SE not recommended to use with strat up application
    //it runs willing app is running.
}

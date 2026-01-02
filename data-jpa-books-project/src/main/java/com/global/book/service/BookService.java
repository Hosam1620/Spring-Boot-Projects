package com.global.book.service;

import com.global.book.base.BaseRepository;
import com.global.book.base.BaseService;
import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService extends BaseService<Book, Long> {
    private final BookRepo bookRepo;

    @Autowired
    BookService(BaseRepository<Book, Long> baseRepository, BookRepo bookRepo) {
        super(baseRepository);
        this.bookRepo = bookRepo;
    }
//
//    public Book findById(Long id) {
//        return bookRepo.findById(id).orElseThrow();
//    }
//
//    public List<Book> findAll() {
//        return bookRepo.findAll();
//    }
//
//    @Transactional
//    public Book insert(Book book) {
//        if (book.getId() != null) {
//            throw new RuntimeException("Should send Id with null");
//        }
//        return bookRepo.save(book);
//    }
//
//    @Transactional
//    public List<Book> insertAll(List<Book> books) {
//        return bookRepo.saveAll(books);
//    }

    @Override
    @Transactional
    public Book updateName(Book book) {
        Book bookFromDB = findById(book.getId());
        bookFromDB.setPrice(book.getPrice());
        return bookRepo.save(bookFromDB);
    }
//
//    @Transactional
//    public void delete(Long id) {
//        bookRepo.deleteById(id);
//    }
}
